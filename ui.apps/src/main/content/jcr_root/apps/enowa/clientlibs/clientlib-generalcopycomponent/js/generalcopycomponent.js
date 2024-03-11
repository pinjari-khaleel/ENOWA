document.addEventListener("DOMContentLoaded", function() {

    const generalCopyComponent = document.querySelectorAll(".generalcopycompoenent");
    generalCopyComponent.forEach((element) => {
      const sixSixContainer = element.querySelectorAll(".six-six-container");
      sixSixContainer.forEach((e) => {
        const div = e.querySelector("div:not([class])");
        if (div?.childElementCount == 0) {
          e.style.gap = '0px';
        }
      });
    });
});