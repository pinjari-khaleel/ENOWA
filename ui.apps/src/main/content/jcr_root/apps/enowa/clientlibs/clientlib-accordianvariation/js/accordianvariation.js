
document.addEventListener('DOMContentLoaded', function() {


const faq = document.querySelectorAll('.faq-wrapper');

    faq.forEach((items) => {

      const wrapper = items.querySelector('.faq');

      const moreItems1 = items.querySelector('.more_items');

      const moreItemsLoader = wrapper.querySelectorAll('.faq_container_items_content_loader');

      const faqContainers = wrapper.querySelectorAll('.faq_container');

      const visibleItemCount = wrapper.getAttribute('data-faq-count');

      const faqFooter = items.querySelector('.faq-footer');



      function toggleDescription(icon, answer) {

        const isActive = icon.classList.contains('icon-circle-minus');



        // Close all FAQ items

        faqContainers.forEach((item) => {

          const itemIcon = item.querySelector('.icon-circle-minus');

          const itemAnswer = item.querySelector('.faq_container_items_content_answer');



          if (itemIcon && itemAnswer && itemIcon !== icon) {

            itemIcon.classList.remove('icon-circle-minus');

            itemIcon.classList.add('icon-circle-plus');

            itemAnswer.style.display = 'none';

          }

        });



        if (!isActive) {

          icon.classList.remove('icon-circle-plus');

          icon.classList.add('icon-circle-minus');

          answer.style.display = 'block';

        } else {

          icon.classList.remove('icon-circle-minus');

          icon.classList.add('icon-circle-plus');

          answer.style.display = 'none';

        }

      }



      faqContainers.forEach((item) => {

        const icon = item.querySelector('.icon-circle-plus');

        const answer = item.querySelector('.faq_container_items_content_answer');

        if (icon && answer) {

          item.addEventListener('click', () => {

            toggleDescription(icon, answer);

          });

        }

      });



      function toggleVisibility(startIndex, endIndex, displayStyle) {

        faqContainers.forEach((item, index) => {

          if (index >= startIndex && index < endIndex) {

            item.style.display = displayStyle;

          }

        });

      }



      toggleVisibility(visibleItemCount, faqContainers.length, 'none');

      moreItemsLoader.forEach((content) => {

        const moreItems = content.querySelector('.more_items');

        moreItems.addEventListener('click', () => {

          if (moreItems.style.display === 'none' || moreItems.style.display === '') {

            moreItems.style.display = 'block';

            toggleVisibility(0, faqContainers.length, 'block');

            moreItems.style.display = 'none';

          }

        });

      });



      faqFooter?.addEventListener('click', () => {

        toggleVisibility(visibleItemCount, faqContainers.length, 'block');

        moreItems1.style.display = 'none';

      });

    });

  });