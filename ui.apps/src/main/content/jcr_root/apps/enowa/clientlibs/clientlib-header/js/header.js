document.addEventListener("DOMContentLoaded", function() {

        const cardWrapper = document.querySelectorAll('.carousel-container');
        let currentIndex = 0;

        cardWrapper.forEach((quote) => {
          const carouselContent = quote.querySelectorAll('.carousel-content');
          const slides = quote.querySelectorAll('.carousel-card');
          const navigation = quote.querySelector('.nav-box');
          const dotsContainer = quote.querySelector('.header-carousel-dots');
          const navBox = quote.querySelectorAll('.nav-box');
          const nextCard = quote.querySelectorAll('.next-item');
          const leftArrowColor = quote.querySelector('.icon-arrow-left-side');
          leftArrowColor.style.color = '#8fd3d3';

          const cardWidth = quote.offsetWidth;
          function showSlide(index) {
            slides.forEach((slide, i) => {
              if (i === index) {
                slide.style.display = 'flex';
              } else {
                slide.style.display = 'none';
              }
            });

            const dots = dotsContainer.querySelectorAll('.progress-dot');
            dots.forEach((dot, i) => {
              if (i === index) {
                dot.classList.add('active-card');
              } else {
                dot.classList.remove('active-card');
              }
            });
          }

          window.addEventListener('resize', () => {
            showSlide(currentIndex);
          })

          showSlide(currentIndex);

          function plusSlides(n) {
            if (n === 1 && currentIndex === slides.length - 1) {
              return;
            }

            if (n === -1 && currentIndex === 0) {
              return;
            }

            currentIndex += n;
            showSlide(currentIndex);

            const rightArrow = slides[currentIndex].querySelectorAll('.Arrow-right');
            const leftArrow = slides[currentIndex].querySelectorAll('.Arrow-left');
            rightArrow.forEach((right) => {
              right.style.color = currentIndex === slides.length - 1 ? '#8fd3d3' : '#2E3D4C';
            });
            leftArrow.forEach((left) => {
              left.style.color = currentIndex === 0 ? '#8fd3d3' : '#2E3D4C';
            });
          }

          function NextSlideS() {
            currentIndex += 1;
            if (currentIndex < 0) {
              currentIndex = slides.length - 1;
            } else if (currentIndex >= slides.length) {
              currentIndex = 0;
            }

            showSlide(currentIndex);

            const rightArrow = slides[currentIndex].querySelectorAll('.Arrow-right');
            const leftArrow = slides[currentIndex].querySelectorAll('.Arrow-left');
            rightArrow.forEach((right) => {
              right.style.color = currentIndex === slides.length - 1 ? '#8fd3d3' : '#2E3D4C';
            });
            leftArrow.forEach((left) => {
              left.style.color = currentIndex === 0 ? '#8fd3d3' : '#2E3D4C';
            });

            carouselContent.forEach((cont) => {
              cont.style.animation = 'none';
            });

            slides.forEach((slide) => {
              slide.style.animation = 'none';
            });

            nextCard.forEach((slide) => {
              const nextSlide = slide.querySelector('.next-video');
              const nextContent = slide.querySelector('.next-card-content');
              nextSlide.style.animation = 'none';
              nextContent.style.animation = 'none';
            });
          }

          if (slides.length > 1) {
            dotsContainer.innerHTML = '';
            for (let i = 0; i < slides.length; i += 1) {
              const progress = document.createElement('div');
              progress.textContent = '●';
              progress.classList.add('progress-dot');
              if (i === currentIndex) {
                progress.classList.add('active-card');
              }
              progress.onclick = () => showSlide(i);
              progress.addEventListener('click', () => {
                carouselContent.forEach((cont) => {
                  cont.style.animation = 'none';
                });

                slides.forEach((slide) => {
                  slide.style.animation = 'none';
                });

                nextCard.forEach((slide) => {
                  const nextSlide = slide.querySelector('.next-video');
                  const nextContent = slide.querySelector('.next-card-content');
                  nextSlide.style.animation = 'none';
                  nextContent.style.animation = 'none';
                });
              });
              dotsContainer.appendChild(progress);
            }
          } else {
            nextCard.forEach((slide) => {
              slide.style.display = 'none';
            });
          }

          navBox.forEach((item) => {
            const leftArrow = item.querySelector('.icon-arrow-left-side');
            const rightArrow = item.querySelector('.icon-arrow-right-side');

            leftArrow.addEventListener('click', () => {
              plusSlides(-1);
              carouselContent.forEach((cont) => {
                cont.style.animation = 'none';
              });

              slides.forEach((slide) => {
                slide.style.animation = 'none';
              });

              nextCard.forEach((slide) => {
                const nextSlide = slide.querySelector('.next-video');
                const nextContent = slide.querySelector('.next-card-content');
                nextSlide.style.animation = 'none';
                nextContent.style.animation = 'none';
              });
            });

            rightArrow.addEventListener('click', () => {
              plusSlides(1);
              carouselContent.forEach((cont) => {
                cont.style.animation = 'none';
              });

              slides.forEach((slide) => {
                slide.style.animation = 'none';
              });

              nextCard.forEach((slide) => {
                const nextSlide = slide.querySelector('.next-video');
                const nextContent = slide.querySelector('.next-card-content');
                nextSlide.style.animation = 'none';
                nextContent.style.animation = 'none';
              });
            });
          });

          nextCard.forEach((slide) => {
            const nextSlide = slide.querySelector('.next-video');
            const nextContent = slide.querySelector('.next-card-content');
            nextSlide.addEventListener('click', () => {
              NextSlideS();
            });
            nextContent.addEventListener('click', () => {
              NextSlideS();
            });
          });

          if (cardWidth > 991) {
            if (slides.length > 1) {
              navigation.style.display = 'flex';
            } else {
              navigation.style.display = 'none';
            }
          }

          function videoHandler(event) {
            event.preventDefault();
            const videoSection = event.target.closest('.pageheader__content__flex');
            const modalBlock = videoSection?.querySelector('.modal-custom');
            if (modalBlock) {
              modalBlock.style.display = 'block';
            }
          }
          const getAllVideoComponent = quote.querySelectorAll('.cta a');
          getAllVideoComponent?.forEach((item) => {
            item.addEventListener('click', videoHandler);
          });
        });

});