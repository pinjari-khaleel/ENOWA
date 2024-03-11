document.addEventListener("DOMContentLoaded", function() {

   const container = document.querySelectorAll('.container-video');



       container.forEach((videoContainer) => {

         const mainVideo = videoContainer.querySelector('video');

         const previewVideo = videoContainer.querySelector('.hover-area');

         const playButtonBox = videoContainer.querySelector('.play-pause');

         const playButton = videoContainer.querySelector('.play-pause .icon-play');

         const previewVideoPlayIcon = videoContainer.querySelector('.preview-video-play .icon-play');

         const playNowButton = videoContainer.querySelector('.hover-area');

         const videoDuration = videoContainer.querySelector('.video-duration');

         const progressRange = videoContainer.querySelector('.progress-range');

         const progressBar = videoContainer.querySelector('.progress-bar');

         const videoControls = videoContainer.querySelector('.video-controls');

         const playPauseButton = videoContainer.querySelector('.play-pause span');

         const previewVideoContainer = videoContainer.querySelector('.preview-video-container');

         const currentTime = videoContainer.querySelector('.time-elapsed');

         const durationElement = videoContainer.querySelector('.time-duration');



         function formatTime(seconds) {

           const minutes = Math.floor(seconds / 60);

           const remainingSeconds = Math.floor(seconds % 60);

           return `-${minutes}:${remainingSeconds < 10 ? '0' : ''}${remainingSeconds}`;

         }

         mainVideo.addEventListener('loadedmetadata', () => {

           const totalDuration = mainVideo.duration;

           durationElement.innerText = formatTime(totalDuration);

         });



         function displayTime(time, remainDuration) {

           const remaining = remainDuration - time;

           const minutes = Math.floor(remaining / 60);

           const seconds = Math.floor(remaining % 60);

           return `-${(minutes < 10 ? '0' : '') + minutes}:${(seconds < 10 ? '0' : '') + seconds}`;

         }

         function updateProgress() {

           const progress = (mainVideo.currentTime / mainVideo.duration) * 100;

           progressBar.style.width = `${progress}%`;



           if (mainVideo.currentTime === mainVideo.duration) {

             playPauseButton.classList.remove('icon-pause');

             playPauseButton.classList.add('icon-play');

           }



           currentTime.textContent = displayTime(mainVideo.currentTime, mainVideo.duration);

         }



         progressRange.addEventListener('click', (e) => {

           const { offsetX } = e;

           const newTime = offsetX / progressRange.offsetWidth;

           progressBar.style.width = `${newTime * 100}%`;

           mainVideo.currentTime = newTime * mainVideo.duration;

         });



         mainVideo.addEventListener('timeupdate', updateProgress);

         mainVideo.addEventListener('canplay', updateProgress);

         previewVideo.muted = true;

         let previewClicked = false;

         previewVideo.play();



         previewVideo.addEventListener('click', () => {

           if (!previewClicked) {

             previewClicked = true;

             mainVideo.muted = false;



             // if (!mainVideo.paused) {

             //   mainVideo.pause();

             // }



             mainVideo.currentTime = 0;

             const clickEvent = new Event('click');

             playNowButton.dispatchEvent(clickEvent);

           }

         });



         playButtonBox.addEventListener('click', () => {

           if (mainVideo.paused) {

             mainVideo.play();

             playButton.classList.remove('icon-play');

             playButton.classList.add('icon-pause');

           } else {

             mainVideo.pause();

             playButton.classList.remove('icon-pause');

             playButton.classList.add('icon-play');

           }

         });

         mainVideo.addEventListener('loadedmetadata', () => {

           // eslint-disable-next-line no-shadow

           const { duration } = mainVideo;

           const formattedDuration = this.formatTime(duration);

           if (videoDuration) {

             videoDuration.innerText = formattedDuration;

           }

         });

         this.formatTime = (time) => {

           const minutes = Math.floor(time / 60);

           const seconds = Math.floor(time % 60);

           return `${(minutes < 10 ? '0' : '') + minutes}:${(seconds < 10 ? '0' : '') + seconds}`;

         };



         let timer;



         const muteButton = videoContainer.querySelector('.icon-unmute');

         muteButton.addEventListener('click', () => {

           if (mainVideo.muted) {

             mainVideo.muted = false;

             muteButton.classList.add('icon-unmute');

             muteButton.classList.remove('icon-mute');

           } else {

             mainVideo.muted = true;

             muteButton.classList.add('icon-mute');

             muteButton.classList.remove('icon-unmute');

           }

         });



         if (mainVideo.muted) {

           muteButton.classList.add('icon-mute');

         } else {

           muteButton.classList.remove('icon-mute');

         }



         const fullScreenButton = videoContainer.querySelector('.icon-teamscard-read-more');



         fullScreenButton.addEventListener('click', () => {

           if (document.fullscreenElement) {

             fullScreenButton.classList.replace('icon-teamscard-read-less', 'icon-teamscard-read-more');

             document.exitFullscreen();

           } else {

             fullScreenButton.classList.replace('icon-teamscard-read-more', 'icon-teamscard-read-less');

             videoContainer.requestFullscreen();

             document.addEventListener('fullscreenchange', () => {

               if (document.fullscreenElement === videoContainer) {

                 videoContainer.style.display = 'flex';

                 videoContainer.style.justifyContent = 'center';

                 videoContainer.style.alignItems = 'center';

                 playNowButton.style.borderRadius = '0px';

               } else {

                 videoContainer.style.display = '';

                 videoContainer.style.justifyContent = '';

                 videoContainer.style.alignItems = '';

                 playNowButton.style.borderRadius = '16px';

               }

             });

           }

         });



         videoContainer.addEventListener('mousemove', () => {

           videoContainer.classList.add('show-controls');

           clearTimeout(timer);

         });



         const speedOptionsButton = videoContainer.querySelector('.icon-setting');

         const speedOptions = videoContainer.querySelector('.speed-options');



         speedOptionsButton.addEventListener('click', () => {

           speedOptions.classList.toggle('active');

         });



         const speedItems = videoContainer.querySelectorAll('.speed-options li');

         speedItems.forEach((item) => {

           item.addEventListener('click', () => {

             const selectedSpeed = item.getAttribute('data-speed');

             mainVideo.playbackRate = parseFloat(selectedSpeed);

             speedOptions.classList.remove('active');

             speedItems.forEach((option) => {

               option.classList.remove('active');

             });

             item.classList.add('active');

           });

         });



         videoControls.style.display = 'none';



         previewVideoPlayIcon.addEventListener('click', () => {

           previewVideoContainer.style.display = 'none';

           mainVideo.muted = false;

           mainVideo.pause();

           mainVideo.currentTime = 0;

           mainVideo.play();

           videoControls.style.display = 'flex';

           playPauseButton.classList.remove('icon-play');

           playPauseButton.classList.add('icon-pause');

           playNowButton.style.cursor = 'pointer';

         });



         playNowButton.addEventListener('click', () => {

           previewVideoContainer.style.display = 'none';

           if (mainVideo.paused) {

             mainVideo.play();

             videoControls.style.display = 'flex';

             playPauseButton.classList.remove('icon-play');

             playPauseButton.classList.add('icon-pause');

             playNowButton.style.cursor = 'pointer';

           } else {

             mainVideo.pause();

             playPauseButton.classList.remove('icon-pause');

             playPauseButton.classList.add('icon-play');

           }

         });



         videoControls.addEventListener('mouseover', () => {

           videoControls.style.display = 'flex';

         });

       });

});