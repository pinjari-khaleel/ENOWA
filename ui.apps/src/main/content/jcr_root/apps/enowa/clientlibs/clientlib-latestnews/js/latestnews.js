document.addEventListener('DOMContentLoaded', function() {

 const newsSection = document.querySelectorAll('.news-container');
     newsSection.forEach((newsSelector) => {
       const leftArrow = newsSelector.querySelector('.left_arrow');
       const rightArrow = newsSelector.querySelector('.right_arrow');
       let prevIndex = 0;

       const card = newsSelector.querySelectorAll('.news__section__card');
       const movePer = 640;
       const cardWidth = card[0]?.offsetWidth;
       const radioCardCount = newsSelector.querySelectorAll('.carousel-dot-news');
       let activeIndex = -1;
       let l = -cardWidth;

       const firstDot = newsSelector.querySelector('.carousel-item-0');
       if (firstDot) {
         firstDot.classList.add('active');
       }
       const handleDotClick = (index) => {
         const dots = newsSelector.querySelectorAll('.carousel-dot-news');
         dots.forEach((dot) => dot.classList.remove('active'));
         const clickedDot = newsSelector.querySelectorAll(`.carousel-item-${index}`)[0];
         if (clickedDot) {
           clickedDot.classList.add('active');
         }
       };

       const updateCarouselPosition = () => {
         const newsParentWidth = newsSelector.offsetWidth;
         Array.from(card)?.forEach((i, index) => {
           i.style.left = `-${l}px`;
           if (newsParentWidth < 991) {
             i.style.opacity = 1;
           } else {
             const distanceFromCenter = Math.abs(-l + index * movePer + cardWidth / 3 - newsSelector.offsetWidth / 3);

             const halfCarouselWidth = newsSelector.offsetWidth / 2;

             const maxDistanceForFullOpacity = halfCarouselWidth - cardWidth / 2;

             const opacity = distanceFromCenter < maxDistanceForFullOpacity ? 1 : 1; // 0.5

             i.style.opacity = opacity;
           }
         });

         if (l < 0) {
           Array.from(card)?.forEach((i) => {
             i.style.opacity = 0.5;
           });
         }
         const totalCards = card.length;
         if (l > 0) {
           leftArrow.style.color = '';
           leftArrow.style.pointerEvents = "unset";
         } else {
           leftArrow.style.color = '#8fd3d3';
           leftArrow.style.pointerEvents = "none";
         }
         if (l < (totalCards - 1) * movePer) {
           rightArrow.style.color = '';
           rightArrow.style.pointerEvents = "unset";
         } else {
           rightArrow.style.color = '#8fd3d3';
           rightArrow.style.pointerEvents = "none";
         }
         if (l === 0) {
           leftArrow.style.pointerEvents = 'none';
         }
         if (l == (totalCards - 2) * movePer) {
           rightArrow.style.color = '#8fd3d3';
           rightArrow.style.pointerEvents = "none";
         }
       };

       const moveRight = () => {
         if (activeIndex === (radioCardCount.length - 1)) {
           activeIndex = 0;
         } else {
           activeIndex += 1;
         }
         handleDotClick(activeIndex);
         const totalCards = card.length;
         // eslint-disable-next-line no-shadow
         const cardWidth = card[0]?.offsetWidth;
         l = activeIndex * movePer;
         if (activeIndex === totalCards - 1) {
           l = -cardWidth + movePer;
         }
         updateCarouselPosition();
       };
       const moveLeft = () => {
         if (activeIndex === 0) {
           activeIndex = radioCardCount.length - 1;
         } else if (activeIndex > 0) {
           activeIndex -= 1;
         }
         handleDotClick(activeIndex);
         // eslint-disable-next-line no-shadow
         const cardWidth = card[0]?.offsetWidth;
         l = activeIndex * movePer;
         if (l < -cardWidth) {
           l = -(card.length - 1) * movePer;
         }
         updateCarouselPosition();
       };

       const moveRight1 = (index) => {
         const totalCards = card.length;
         // eslint-disable-next-line no-shadow
         const cardWidth = card[0]?.offsetWidth;
         l = index * movePer;
         if (l > totalCards * movePer) {
           l = 0;
         }
         if (l >= totalCards * movePer) {
           l = -cardWidth;
         }
         updateCarouselPosition();
       };

       const moveLeft1 = (index) => {
         // eslint-disable-next-line no-shadow
         const cardWidth = card[0]?.offsetWidth;
         l = index * movePer;
         if (l < -cardWidth) {
           l = -(card.length - 1) * movePer - 30;
         }
         updateCarouselPosition();
       };

       function moveToSlide(index) {
         handleDotClick(index);

         // eslint-disable-next-line no-unused-vars
         const stepsToMove = Math.abs(index - prevIndex);

         // eslint-disable-next-line no-unused-vars
         Array.from({ length: stepsToMove }).forEach((_, step) => {
           if (index > prevIndex) {
             activeIndex = index;
             moveRight1(index);
           } else if (index < prevIndex) {
             activeIndex = index;
             moveLeft1(index);
           }
         });

         prevIndex = index;
       }

       radioCardCount.forEach((radio, i) => {
         radio.addEventListener('click', () => {
           moveToSlide(i);
         });
       });

       function setupVideoHover(videoHover, span) {
         let timeoutId;
         let firstHover = true;
         videoHover.muted = true;
         videoHover.controls = false;

         const mouseEnterHandler = () => {
           if (firstHover) {
             videoHover.play();
             timeoutId = setTimeout(() => {
               videoHover.pause();
             }, 3000);
           }
         };

         const mouseLeaveHandler = () => {
           if (firstHover) {
             clearTimeout(timeoutId);
             timeoutId = setTimeout(() => {
               videoHover.pause();
             }, 1000);
           }
         };

         videoHover.addEventListener('mouseenter', mouseEnterHandler);
         videoHover.addEventListener('mouseleave', mouseLeaveHandler);

         span.addEventListener('click', () => {
           videoHover.controls = true;
           span.style.display = 'none';
           firstHover = false;
           videoHover.play();
           videoHover.removeEventListener('mouseenter', mouseEnterHandler);
           videoHover.removeEventListener('mouseleave', mouseLeaveHandler);
         });

         videoHover.addEventListener('pause', () => {
           videoHover.controls = false;
           span.style.display = 'block';
         });
       }

       const videoHovers = newsSelector.querySelectorAll('.videoHover');
       const spans = newsSelector.querySelectorAll('.icon-button-video-play');

       videoHovers.forEach((videoHover, index) => {
         setupVideoHover(videoHover, spans[index], index);
       });

       leftArrow.addEventListener('click', moveLeft);
       rightArrow.addEventListener('click', moveRight);
       moveRight();
     });
});