
document.addEventListener('DOMContentLoaded', function() {
function readMoreShowHandler(event) {
      event.preventDefault();
      const leadershipCard = event.target.closest('.leadership-card');
      const ReadMoreBtn = event.target;
      if (leadershipCard) {
        const iconBtn = leadershipCard.querySelector('.cta-primary-light-icon span');
        
        const profileDescDetailMore = leadershipCard.querySelector('.profile-desc_detail-more');

        if (profileDescDetailMore) {

          if (profileDescDetailMore.style.display === 'block') {

            profileDescDetailMore.style.display = 'none';

            ReadMoreBtn.innerHTML = 'Read More';

            iconBtn.classList.remove('icon-teamscard-read-less');

            iconBtn.classList.add('icon-teamscard-read-more');

          } else {

            profileDescDetailMore.style.display = 'block';

            ReadMoreBtn.innerHTML = 'Read Less';

            iconBtn.classList.remove('icon-teamscard-read-more');

            iconBtn.classList.add('icon-teamscard-read-less');

          }

        }

      }
    }
    const readMoreLinks = document.querySelectorAll('.cta a');
    readMoreLinks.forEach((link) => {

      link.addEventListener('click', readMoreShowHandler);

    });
  });