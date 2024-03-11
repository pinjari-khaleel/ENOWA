const newsRoom = document.querySelectorAll('.news-room');
    newsRoom.forEach((newsSelector) => {
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
    });