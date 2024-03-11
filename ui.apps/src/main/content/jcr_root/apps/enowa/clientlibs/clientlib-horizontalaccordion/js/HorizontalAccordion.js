document.addEventListener("DOMContentLoaded", function() {
const haccordian = document.querySelectorAll('.h_accordion_container');
    haccordian.forEach((accordian) => {
      const containers = accordian.querySelectorAll('.h_accordion_mini_container');
      const contents = accordian.querySelectorAll('.h_accordion_expanded_container');
      const items = accordian.querySelectorAll('.h_accordion_card');
      contents.forEach((content, index) => {
        if (index === 0) {
          content.classList.add('active');
        } else {
          content.classList.remove('active');
        }
      });
      containers.forEach((container, index) => {
        if (index === 0) {
          container.classList.remove('active');
        } else {
          container.classList.add('active');
        }
      });
      items.forEach((item, index) => {
        if (index === 0) {
          item.classList.add('selected');
        } else {
          item.classList.remove('selected');
        }
      });
      containers.forEach((container) => {
        container.addEventListener('click', function () {
          contents.forEach((content) => {
            content.classList.remove('active');
          });
          const cntrs = containers;
          cntrs.forEach((cntr) => {
            cntr.classList.add('active');
          });
          container.classList.remove('active');
          const content = this.nextElementSibling;
          content.classList.add('active');
        });
      });
      items.forEach((item, idx) => {
        item.addEventListener('click', () => {
          const itms = items;
          itms.forEach((itm) => {
            itm.classList.remove('selected');
          });
          item.classList.add('selected');
        });
      });
    });
});