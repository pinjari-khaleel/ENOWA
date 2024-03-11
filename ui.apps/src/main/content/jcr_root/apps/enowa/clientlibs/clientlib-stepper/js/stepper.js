document.addEventListener("DOMContentLoaded", function() {
    const stepperContainer = document.querySelectorAll('.stepper-container');

        stepperContainer?.forEach((item) => {
          const stepperCircle = item?.querySelectorAll('.stepper-container_circle');
          let leftArrow = item.querySelector('.stepper-navigation .arrow__icons .icon-arrow-left-side');
          let rightArrow = item.querySelector('.stepper-navigation .arrow__icons .icon-arrow-right-side');
          const circle = item.querySelectorAll('.stepper-container_right_slide_wrapper');
          const carouselDots = item.querySelector('.stepper-carousel-dots');
          const stepperNavigation = item.querySelector('.stepper-navigation');
          const svgContainer = item.querySelectorAll('.stepper-container_circle_logo');
          const dottedLine = item.querySelector('.stepper-dotted-line');
          let slideIndex = 0;

          function addEventClickArrow() {
            if (window.innerWidth <= 768) {
              leftArrow = item.querySelector(".stepper-navigation-mobile .arrow__icons .icon-arrow-left-side");
              rightArrow = item.querySelector(".stepper-navigation-mobile .arrow__icons .icon-arrow-right-side");
            } else {
              leftArrow = item.querySelector('.stepper-navigation .arrow__icons .icon-arrow-left-side');
              rightArrow = item.querySelector('.stepper-navigation .arrow__icons .icon-arrow-right-side');
            }
          }
          addEventClickArrow();

          function showSlide(index) {
            stepperCircle.forEach((slide, i) => {
              if (i === index) {
                slide.style.display = 'block';
              } else {
                slide.style.display = 'none';
              }
            });

            const dots = carouselDots.querySelectorAll('.stepper-dot');
            dots.forEach((dot, i) => {
              if (i === index) {
                dot.classList.add('active-circle');
              } else {
                dot.classList.remove('active-circle');
              }
            });
          }

          function plusSlides(n) {
            const newIndex = (slideIndex + n) % stepperCircle.length;

            if (newIndex < 0) {
              slideIndex = stepperCircle.length - 1;
            } else {
              slideIndex = newIndex;
            }

            showSlide(slideIndex);

            circle.forEach((slide, index) => {
              let indexValue = index;
              slide.querySelector('.circle-icon').innerHTML = logoArray[slideIndex][indexValue];
              slide.querySelector('.stepper-container_right_slide_wrapper_title').textContent = HeadingArray[slideIndex][indexValue];

              if (n === 1) {
                indexValue += 1;
              } else {
                indexValue -= 1;
              }
            });

            loadAndDisplaySVG(filepaths[slideIndex], svgContainer[slideIndex]);
            handleSlideChange();
          }

          function updateSlides(n) {
            showSlide(n);
            loadAndDisplaySVG(filepaths[n], svgContainer[n]);

            leftArrow.style.color = n === 0 ? '#8fd3d3' : '#2E3D4C';
            rightArrow.style.color = n === stepperCircle.length - 1 ? '#8fd3d3' : '#2E3D4C';
          }

          showSlide(slideIndex);

          leftArrow.addEventListener('click', () => {
            plusSlides(-1);
          });

          rightArrow.addEventListener('click', () => {
            plusSlides(1);
          });

          const circleWrapper = item.querySelectorAll('.stepper-container_circle');
          const logo = [];
          const content = [];

          circleWrapper.forEach((slide) => {
            const svg = slide.querySelector('.stepper-container_circle_logo').innerHTML;
            const heading = slide.querySelector('.stepper-container_circle_heading').textContent;
            logo.push(svg);
            content.push(heading);
          });

          const numSlides = logo.length;

          const logoArray = [];
          const HeadingArray = [];

          const rotations = [];

          for (let i = 1; i <= numSlides; i += 1) {
            const rotation = [];
            for (let j = 1; j < numSlides; j += 1) {
              rotation.push((i + j - 1) % numSlides);
            }
            rotations.push(rotation);
          }

          rotations.forEach((rotation) => {
            const logoToDisplay = rotation.map((i) => logo[i]);
            const contentToDisplay = rotation.map((i) => content[i]);
            logoArray.push(logoToDisplay);
            HeadingArray.push(contentToDisplay);
          });

          carouselDots.innerHTML = '';
          for (let i = 0; i < stepperCircle.length; i += 1) {
            const progress = document.createElement('div');
            progress.textContent = '●';
            progress.classList.add('stepper-dot');
            if (i === slideIndex) {
              progress.classList.add('active-circle');
            }

            // eslint-disable-next-line no-loop-func
            progress.addEventListener('click', () => {
              plusSlides(i - slideIndex);
              updateCircleContent(i);
            });
            carouselDots.appendChild(progress);
          }

          const dotsWrapper = carouselDots.offsetWidth;
          const stepperWidth = item.offsetWidth;

          if (stepperWidth < 1440 && stepperWidth > 991) {
            const newStepperWidth = 980 - (1440 - stepperWidth);
            stepperNavigation.style.width = `${newStepperWidth}px`;
            stepperNavigation.style.gap = '15px';
          }

          if (stepperWidth > 991) {
            if (dotsWrapper > 80) {
              dottedLine.style.width = `400px`;
            }
          }

          if (stepperWidth <= 1024){ 
            if (dotsWrapper > 80){ 
              const newDotsWidth = 555  - (dotsWrapper - 22);
              dottedLine.style.width = `${newDotsWidth}px`;
              stepperNavigation.style.gap = '0px';
            } 
          }

          if (stepperWidth >= 1440) {
            const newStepperWidth = 980 + (stepperWidth - 1440);
            stepperNavigation.style.width = `${newStepperWidth}px`;
            const newDotsWidth = 555 + (dotsWrapper - 80);
            dottedLine.style.width = `${newDotsWidth}px`;
            stepperNavigation.style.gap = '0px';
          }

          function updateCircleContent(clickedIndex) {
            circle.forEach((slide, index) => {
              let indexValue = index;
              slide.querySelector('.circle-icon').innerHTML = logoArray[clickedIndex][indexValue];
              slide.querySelector('.stepper-container_right_slide_wrapper_title').textContent = HeadingArray[clickedIndex][indexValue];
              if (clickedIndex === 0) {
                indexValue += index;
              } else {
                indexValue -= index;
              }
            });
          }

          circle.forEach((circleItem) => {
            circleItem.addEventListener('click', () => {
              const circleText = circleItem.querySelector('.stepper-container_right_slide_wrapper_title').textContent;
              const contentIndex = content.findIndex((itemIndex) => itemIndex === circleText);
              updateSlides(contentIndex);
              updateCircleContent(contentIndex);
            });
          });

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

          const svgFilePath = logo;
          const filepaths = [];
          svgFilePath.forEach((data) => {
            const regex = /src="([^"]+)"/;
            const match = data.match(regex);
            match && filepaths.push(match[1]);
          });

          loadAndDisplaySVG(filepaths[0], svgContainer[0]);

          function handleSlideChange() {
            const bigCircles = item.querySelectorAll('.stepper-logo-container-wrapper');
            const smallCircleLogo = item.querySelectorAll('.circle-icon');
            const smallCircleText = item.querySelectorAll('.stepper-container_right_slide_wrapper_title');
            let startTime;

            const duration = 500;

            function animate(timestamp) {
              if (!startTime) startTime = timestamp;
              const elapsed = timestamp - startTime;
              const progress = Math.min(elapsed / duration, 1);

              bigCircles.forEach((bigCircle) => {
                bigCircle.style.opacity = progress;
              });

              smallCircleLogo.forEach((smallLogo) => {
                smallLogo.style.opacity = progress;
              });

              smallCircleText.forEach((SmallText) => {
                SmallText.style.opacity = progress;
              });

              if (elapsed < duration) {
                requestAnimationFrame(animate);
              }
            }

            requestAnimationFrame(animate);
          }

          function onSetPosition3Dots() {
            let idx = 0;
            const isDev = document.querySelector('.component-dev');
            const mainWidth = isDev ? document.querySelector('body') : item;
            const isDevWidth = isDev ? 50 : 0;
            circle.forEach((x, idex) => { x.getBoundingClientRect().right + isDevWidth <= window.innerWidth ? idx = idex : null; });
            const positionCircleLast = circle[idx].getBoundingClientRect();
            const isScrollVisible = window.innerWidth - mainWidth.clientWidth ?? 0;
            if (window.innerWidth - positionCircleLast.right - isScrollVisible > dottedLine.getBoundingClientRect().width) {
              dottedLine.style.display = "contents";
            }
            stepperNavigation.style.right = `${(window.innerWidth - (positionCircleLast.right) - isScrollVisible - isDevWidth)}px`;
            let stepperHeader = item.querySelector('.stepper-header');
            // TITLE STEPPER
            if(window.innerWidth > 991) {
              const headerBounding = stepperHeader.getBoundingClientRect();
              const rightPosition = window.innerWidth - positionCircleLast.right;
              stepperHeader.style.width = `${window.innerWidth - rightPosition - headerBounding.left}px`;
            } else {
              stepperHeader.style.width = `auto`;
            }
          }
          onSetPosition3Dots();
          window.addEventListener('resize', () => {
            onSetPosition3Dots();

            addEventClickArrow();
          })
        });
});