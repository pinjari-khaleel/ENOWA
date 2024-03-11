document.addEventListener('DOMContentLoaded', function() {

 const tableinfo = document.querySelectorAll('.table-info2');

     tableinfo.forEach((item) => {
       const tableContent = item.querySelector('.table-info2_content');
       const leftArrow = item?.querySelector('.left-arrow');
       const rightArrow = item?.querySelector('.right-arrow');
       const icons = item.querySelectorAll('.icons-row_icon');
       const tableCardRow1 = item.querySelector('.table-info2_content_row1');
       const tableCardRow2 = item.querySelector('.table-info2_content_row2');
       const tableCard1 = tableCardRow1.querySelectorAll('.table-card');
       const tableCard2 = tableCardRow2.querySelectorAll('.table-card');
       const iconsRow = item.querySelector('.table-info2_mobile-view > .icons-container > .icons-row');
       const cardRow = item.querySelector('.table-info2_mobile-view > .cards-row');
       const allIconElements = iconsRow.querySelectorAll('.icons-row_icon');
       const iconsRowContainer = item.querySelector('.table-info2_mobile-view > .icons-container');
       const cardRowItems = item.querySelectorAll('.table-info2_mobile-view > .cards-row > .cards-container > .cards-container_card');
       const cardRowContainer = item.querySelector('.table-info2_mobile-view > .cards-row > .cards-container');
       const svgIcon = [];

       icons.forEach((row) => {
         const svg = row.innerHTML;
         svgIcon.push(svg);
       });

       let cardIndex1 = Math.floor(tableCard1.length / 2);
       let cardIndex2 = Math.floor(tableCard2.length / 2);
       const cardCount1 = tableCard1.length;
       const cardCount2 = tableCard2.length;
       const cardWidth = tableCard1[0].offsetWidth;

       function updateCarousel() {
         const offset1 = -cardIndex1 * cardWidth;
         const offset2 = -cardIndex2 * cardWidth;
         tableCardRow1.style.transition = 'transform 0.3s';
         tableCardRow2.style.transition = 'transform 0.3s';
         tableCardRow1.style.transform = `translateX(${offset1}px)`;
         tableCardRow2.style.transform = `translateX(${offset2}px)`;
       }

       function scrollLeftSide() {
         if (cardIndex1 === 1 || cardIndex2 === cardCount2 - 1) {
           cardIndex1 = cardCount1 - 2;
           cardIndex2 = 1;
         } else {
           cardIndex1 -= 1;
           cardIndex2 += 1;
         }
         updateCarousel();
       }

       function scrollRightSide() {
         if (cardIndex1 === cardCount1 - 1 || cardIndex2 === 1) {
           cardIndex2 = cardCount2 - 1;
           cardIndex1 = 1;
         } else {
           cardIndex1 += 1;
           cardIndex2 -= 1;
         }
         updateCarousel();
       }

       if (leftArrow) {
         leftArrow.addEventListener('click', () => {
           scrollLeftSide();
         });
       }

       if (rightArrow) {
         rightArrow.addEventListener('click', () => {
           scrollRightSide();
         });
       }

       updateCarousel();

       function addCardToStartAndEnd() {
         const firstCardClone1 = tableCardRow1.firstElementChild.cloneNode(true);
         const firstCardClone2 = tableCardRow2.firstElementChild.cloneNode(true);
         const lastCardClone1 = tableCardRow1.lastElementChild.cloneNode(true);
         const lastCardClone2 = tableCardRow2.lastElementChild.cloneNode(true);

         tableCardRow1.appendChild(firstCardClone1);
         tableCardRow2.appendChild(firstCardClone2);
         tableCardRow1.insertBefore(lastCardClone1, tableCardRow1.firstElementChild);
         tableCardRow2.insertBefore(lastCardClone2, tableCardRow2.firstElementChild);
       }

       addCardToStartAndEnd();

       async function loadAndDisplaySVG(filePath, circleContainer) {
         fetch(filePath)
           .then((response) => response.text())
           .then((svgCode) => {
              const safeContent = DOMPurify.sanitize(svgCode);
              circleContainer.innerHTML = safeContent;
           })
           .catch((error) => {
             console.error('Error loading SVG');
           });
       }

       const svgFilePath = svgIcon;
       const filepaths = [];
       svgFilePath.forEach((data) => {
         const regex = /src="([^"]+)"/;
         const match = data.match(regex);
         filepaths.push(match[1]);
       });

       loadAndDisplaySVG(filepaths[0], icons[0]);

       // Mobile view function
       function removeActiveClass() {
         allIconElements.forEach((icon) => {
           icon.classList.remove('active-icon');
         });
       }

       function applyOpacityToInactiveCards(activeCardId) {
         cardRowItems.forEach((card, index) => {
           if (cardRowItems[index] !== cardRowItems[activeCardId]) {
             card.classList.add('inactive-card');
           } else {
             card.classList.remove('inactive-card');
           }
         });
       }

       let movableElementDimension = 0;

       allIconElements[0]?.classList.add('active-icon');

       // Active the card when user click the icon
       allIconElements?.forEach((icon, index) => {
         icon?.addEventListener('click', () => {
           removeActiveClass();
           movableElementDimension = index * 332;
           icon.classList.add('active-icon');
           cardRow.scroll({
             left: movableElementDimension,
             behavior: 'smooth',
           });
           applyOpacityToInactiveCards(index);
           loadAndDisplaySVG(filepaths[index], icons[index]);
         });
       });

       // Active the icon when user click the card
       cardRowItems?.forEach((card, index) => {
         card?.addEventListener('click', () => {
           removeActiveClass();
           movableElementDimension = index * 83;
           iconsRowContainer.scroll({
             left: movableElementDimension,
             behavior: 'smooth',
           });
           allIconElements[index].classList.add('active-icon');
           applyOpacityToInactiveCards(index);
           loadAndDisplaySVG(filepaths[index], icons[index]);
         });
       });

       // Animation for Desktop view
       function scrollAnimation() {
         window.addEventListener('scroll', () => {
           const rect = tableContent.getBoundingClientRect();
           const scrollPosition = rect.top <= 0 ? 267 : rect.top > 1850 ? -582 : rect.top - 886;
           const scrollSpeed = 0.4;
           cardIndex1 = Math.floor(Math.abs(scrollPosition) / cardWidth);
           cardIndex2 = Math.floor(Math.abs(scrollPosition) / cardWidth);
           let offset1;
           let offset2;
           if (cardIndex1 === 1 || cardIndex2 === cardCount2 - 1) {
             offset1 = -cardIndex1 * cardWidth + scrollPosition * scrollSpeed;
             offset2 = -cardIndex2 * cardWidth - scrollPosition * scrollSpeed;
           } else if (cardIndex1 === cardCount1 - 1 || cardIndex2 === 1) {
             offset1 = -cardIndex1 * cardWidth - scrollPosition * scrollSpeed;
             offset2 = -cardIndex2 * cardWidth + scrollPosition * scrollSpeed;
           }
           tableCardRow1.style.transition = 'transform 0.3s';
           tableCardRow2.style.transition = 'transform 0.3s';
           tableCardRow1.style.transform = `translateX(${offset1}px)`;
           tableCardRow2.style.transform = `translateX(${offset2}px)`;
         });
       }

       const options = {
         threshold: 0.0,
       };

       const observer = new IntersectionObserver((entries) => {
         entries.forEach((entry) => {
           console.log('Entry:', entry);
           if (entry.isIntersecting) {
             scrollAnimation();
           }
         });
       }, options);

       observer.observe(item);

        if(window.innerWidth <= 991){
          removeActiveClass();
          allIconElements[0].classList.add("active-icon");
          applyOpacityToInactiveCards(0);
        }
        cardRow.addEventListener("scroll", () => {
          if (window.innerWidth <= 991) {
            const rect = cardRowContainer.getBoundingClientRect();
            const widthCenter = (window.innerWidth - cardRowItems[0].offsetWidth) / 2;
            const idx = Math.floor((rect.x * -1 + widthCenter) / cardRowItems[0].offsetWidth);
            removeActiveClass();
            allIconElements[idx].classList.add("active-icon");
            applyOpacityToInactiveCards(idx);
            movableElementDimension = idx * 83;
            iconsRowContainer.scroll({
              left: movableElementDimension,
              behavior: 'smooth',
            });
            loadAndDisplaySVG(filepaths[idx], icons[idx]);

            // const cardLast = cardRowItems[cardRowItems.length - 1].getBoundingClientRect();
            // if (rect.width + rect.x == cardLast.width + cardLast.x && idx + 1 == allIconElements.length - 1) {
            //   removeActiveClass();
            //   allIconElements[allIconElements.length - 1].classList.add( "active-icon");
            //   applyOpacityToInactiveCards(allIconElements.length - 1);
            // }
          }
        });
     });
});