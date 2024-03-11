
document.addEventListener('DOMContentLoaded', function() {

const counters = document.querySelectorAll('[data-infographic] h1');
    const observerOptions = {

      root: null,

      rootMargin: '0px',

      threshold: 0.1,

    };
    function startCounterAnimation(entries, observer) {

      entries.forEach((entry) => {

        if (entry.isIntersecting) {

          const counter = entry.target;

          const countTo = parseFloat(counter.getAttribute('data-countto'));

          const countDuration = parseInt(counter.getAttribute('data-duration'));

          const startTime = performance.now();



          function updateCounter(timestamp) {

            const progress = timestamp - startTime;
            const countToTmp = countTo % 10 === 0 ? countTo - 1 : countTo;

            let value = Math.floor((progress / countDuration) * (countToTmp % 10));

            const startCount = countToTmp - (countToTmp % 10) + 1;
            if (value === -1) {
              value = startCount;
            } else {
              value = startCount + value;
            }



            if (progress < countDuration) {

              counter.textContent = value;

              requestAnimationFrame(updateCounter);

            } else {

              counter.textContent = countTo;

            }

          }

          requestAnimationFrame(updateCounter);

          observer.unobserve(counter);

        }

      });

    }

    const counterObserver = new IntersectionObserver(startCounterAnimation, observerOptions);

    counters.forEach((counter) => {

      counterObserver.observe(counter);

    });

    let counterRunning = false;

    window.addEventListener('scroll', () => {

      counters.forEach((counter) => {

        const oTop = counter.offsetTop - window.innerHeight;

        if (window.scrollY > oTop && !counterRunning && counter.textContent !== counter.getAttribute('data-countto')) {

          const countTo = parseInt(counter.getAttribute('data-countto'));

          const countDuration = parseInt(counter.getAttribute('data-duration'));

          const startTime = performance.now();



          function updateCounter(timestamp) {

            const progress = timestamp - startTime;
            const countToTmp = countTo % 10 === 0 ? countTo - 1 : countTo;

            let value = Math.floor((progress / countDuration) * (countToTmp % 10));

            const startCount = countToTmp - (countToTmp % 10) + 1;
            if (value === -1) {
              value = startCount;
            } else {
              value = startCount + value;
            }

            if (progress < countDuration) {

              counter.textContent = value;

              requestAnimationFrame(updateCounter);

            } else {

              counter.textContent = countTo;

            }

          }



          requestAnimationFrame(updateCounter);

          counterRunning = true;

        }

      });

    });

  });