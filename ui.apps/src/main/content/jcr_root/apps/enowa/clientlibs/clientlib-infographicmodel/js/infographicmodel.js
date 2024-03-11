
  document.addEventListener("DOMContentLoaded", function() {
const play = (videoElement) => {
      if (videoElement.tagName === 'IFRAME') {
        let source = videoElement.getAttribute('src');
        source += '&autoplay=1';
        videoElement.setAttribute('src', source);
      } else if (videoElement.tagName === 'VIDEO') {
        videoElement.play();
      }
    };

    const stop = (videoElement) => {
      if (videoElement.tagName === 'IFRAME') {
        let source = videoElement.getAttribute('src');
        source = source.replace('&autoplay=1', '');
        videoElement.setAttribute('src', source);
      } else if (videoElement.tagName === 'VIDEO') {
        videoElement.pause();
      }
    };

    const landingCircles = document.querySelectorAll('.landingpage_circle');

    landingCircles.forEach((landingCircle) => {
      const videoElement = landingCircle.querySelector('iframe, video');

      if (videoElement) {
        landingCircle.addEventListener('mouseover', () => {
          play(videoElement);
        });

        landingCircle.addEventListener('mouseout', () => {
          stop(videoElement);
        });
      }
    });

    const landingCircle = document.querySelectorAll('.landingpage') 
    landingCircle.forEach((itm) => { 
      const circleList = itm.querySelectorAll('[class^="landingpage_wrap_variation_"]'); 
      const landingWidth = itm.offsetWidth; 
      function centerCircle() {
        if (landingWidth <= 1440 && landingWidth >= 991) {
          if (circleList.length < 3) {
            circleList.forEach(x => {
              x.style.flexBasis = "unset";
            })
          }
        }
      }
      centerCircle()
    });
});