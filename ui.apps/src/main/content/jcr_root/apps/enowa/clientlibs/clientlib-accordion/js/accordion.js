document.addEventListener("DOMContentLoaded", function() {

    const accordions = document.querySelectorAll('.accordion');

        accordions?.forEach((accordion) => {

          const accordionItems = accordion?.querySelectorAll('.accordion-item');

          accordionItems.forEach((item) => {

            const title = item.querySelector('.accordion-header');

            const content = item.querySelector('.accordion-body');

            const icon = item.querySelector('.icon-arrow-down');



            title.addEventListener('click', () => {

              const allAccordionBodies = accordion.querySelectorAll('.accordion-body');



              if (content?.classList.contains('active')) {

                content.classList.remove('active');
                
                if (icon?.classList.contains('icon-arrow-up')) {

                  icon?.classList.remove('icon-arrow-up');
  
                  icon?.classList.add('icon-arrow-down');
  
                }

              } else {

                allAccordionBodies.forEach((body) => {

                  body.classList.remove('active');

                });

                content.classList.add('active');
                
                if (icon?.classList.contains('icon-arrow-down')) {

                  icon?.classList.remove('icon-arrow-down');
  
                  icon?.classList.add('icon-arrow-up');
  
                }

              }

            });



            item.addEventListener('mouseover', () => {

              if (icon?.classList.contains('icon-arrow-down')) {

                icon?.classList.remove('icon-arrow-down');

                icon?.classList.add('icon-arrow-up');

              }

            });



            item.addEventListener('mouseout', () => {

              if (icon?.classList.contains('icon-arrow-up')) {

                icon?.classList.remove('icon-arrow-up');

                icon?.classList.add('icon-arrow-down');

              }

            });

          });

        });


});