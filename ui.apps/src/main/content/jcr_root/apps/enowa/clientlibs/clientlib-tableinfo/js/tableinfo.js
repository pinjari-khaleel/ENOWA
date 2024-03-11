document.addEventListener("DOMContentLoaded", function() {

const reveals = document.querySelectorAll('.tableinfo__bottom');

    const options = {
      threshold: 0.0,
    };

    const observer = new IntersectionObserver((entries) => {
      entries.forEach((entry) => {
        if (entry.isIntersecting) {
          entry.target.style.transition = 'opacity 1s, transform 1s';
          entry.target.style.opacity = 1;
          entry.target.style.transform = 'translateY(0)';
          if (window.innerWidth <= 991) {
            entry.target.style.paddingBottom = '0px';
          } else {
            entry.target.style.paddingBottom = '60px';
          }
          console.log('Element is in the viewport');
        } else {
          entry.target.style.transition = 'none';
          entry.target.style.opacity = 0;
          entry.target.style.transform = 'translateY(90px)';
          console.log('Element is out of the viewport');
        }
      });
    }, options);

    reveals.forEach((element) => {
      observer.observe(element);
    });

    const targetElements = document.querySelectorAll('.tableinfo__bottom');
    targetElements.forEach((element) => {
      element.style.transition = 'none';
      element.style.opacity = 0;
      element.style.transform = 'translateY(90px)';
      if (window.innerWidth <= 991) {
        element.style.paddingBottom = '0px';
      } else {
        element.style.paddingBottom = '60px';
      }
    });
});