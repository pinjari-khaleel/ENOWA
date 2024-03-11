function convertToEmbedURL(url) {

	const watchRegex = /https:\/\/www\.youtube\.com\/watch\?v=([A-Za-z0-9_-]+)/;

	const match = url.match(watchRegex);

	if (match && match[1]) {

		const videoID = match[1];

		return `https://www.youtube.com/embed/${videoID}?autoplay=1`;

	}

	return url;

}

document.addEventListener("DOMContentLoaded", function() {

const pageHeader = document.querySelectorAll('[data-page-header]');

    pageHeader.forEach((items) => {

      function videoHandler(event) {

        event.preventDefault();

        const videoSection = event.target.closest('.pageheader__content__flex') || event.target.closest('.pagebanner__items__flexbox');

        const modalBlock = videoSection.querySelector('.modal-custom');

        modalBlock.style.display = 'block';

      }

      const getAllVideoComponent = items.querySelectorAll('.cta a');

      getAllVideoComponent?.forEach((item) => {

        item.addEventListener('click', videoHandler);

      });

    });

    const sectionContainer = document.querySelectorAll('.pagevideo-section');

        const navBar = document.querySelector('nav');
        sectionContainer.forEach((item) => {

          const modalCustom = item.querySelectorAll('.modal-custom');

          const openBtn = item?.querySelectorAll('.cta-primary-dark');

          const iframe = item.querySelector('iframe');

          const closeBtn = item?.querySelectorAll('.modal-custom_close');



          let originalVideoSrc;

          if (iframe) {

            originalVideoSrc = iframe.getAttribute('src');

          }


          let embedVideoSrc;

          if (originalVideoSrc) {

            embedVideoSrc = convertToEmbedURL(originalVideoSrc);

          }

          

          openBtn.forEach((open, index) => {

            open.addEventListener('click', () => {

              if (iframe) {

                iframe.setAttribute('src', embedVideoSrc);

              }

              navBar.style.display = "none";

              document.body.style.overflow = "hidden";

              document.body.classList.add("freeze");

              if (modalCustom[index]) {
                modalCustom[index].style.display = "block";

                modalCustom[index].classList.add("show-modal");
              }

            });
            
          });

          closeBtn.forEach((close, index) => {

            close.addEventListener('click', () => {

              if (iframe) {

                iframe.setAttribute('src', '');

              }


              document.body.classList.remove("freeze");

              document.body.style.overflow = "scroll";

              navBar.style.display = "flex";

              modalCustom.forEach((x) => {
                if (x) {
                  x.style.display = "none";

                  x.classList.remove("show-modal");
                }
              });

            });

          });

        });

});