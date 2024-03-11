
document.addEventListener('DOMContentLoaded', function() {
const wrapper = document.querySelectorAll('.quotes-wrapper');
    let currentIndex = 0;
    wrapper.forEach((quote) => {
      const slides = quote.querySelectorAll('.about-us');
      const navigation = quote.querySelector('.navigation');
      const dotsContainer = quote.querySelector('.navigation-dot');
      const leftArrowColor = quote.querySelector('.left-arrow');
      leftArrowColor.style.color = '#8fd3d3';
      const wrapperWidth = quote.offsetWidth;
      function showSlide(index) {
        slides.forEach((slide, i) => {
          if (i === index) {
            slide.style.display = 'flex';
          } else {
            slide.style.display = 'none';
          }
        });
        const dots = dotsContainer.querySelectorAll('.dot');
        dots.forEach((dot, i) => {
          if (i === index) {
            dot.classList.add('activedot');

          } else {

            dot.classList.remove('activedot');
          }
        });
      }
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

        const rightArrow = slides[currentIndex].querySelector('.right-arrow');

        const leftArrow = slides[currentIndex].querySelector('.left-arrow');

        leftArrow.style.color = currentIndex === 0 ? '#8fd3d3' : '#2E3D4C';
        rightArrow.style.color = currentIndex === slides.length - 1 ? '#8fd3d3' : '#2E3D4C';
      }
      if (slides.length > 1) {
        dotsContainer.innerHTML = '';
        for (let i = 0; i < slides.length; i += 1) {
         const dot = document.createElement('div');
          dot.textContent = '●';
          dot.classList.add('dot');
          if (i === currentIndex) {
            dot.classList.add('activedot');
          }
          dot.onclick = () => showSlide(i);
          dotsContainer.appendChild(dot);
        }
      }
      slides.forEach((item) => {
        const leftArrow = item.querySelector('.left-arrow');
        const rightArrow = item.querySelector('.right-arrow');
        leftArrow.addEventListener('click', () => {
          plusSlides(-1);
        });
        rightArrow.addEventListener('click', () => {
          plusSlides(1);
        });
      });
      function showNavigation() {
        if (wrapperWidth > 991) {
          if (slides.length > 1) {
            navigation.style.display = 'flex';
          } else {
            navigation.style.display = 'none';
          }
        }
      }
      showNavigation();
    });
});