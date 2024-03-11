document.addEventListener("DOMContentLoaded", function() {

   const menuSetList = document.querySelectorAll('nav');

       function isMobileAndTabView() {

         const mobileThreshold = 768;

         const tabThreshold = 991;

         // Get the current viewport width

         const viewportWidth = window.innerWidth || document.documentElement.clientWidth;

         // Check if the viewport width is less than the mobile threshold

         if (viewportWidth < mobileThreshold || viewportWidth < tabThreshold) {

           return true;

         }



         return false;

       }

       menuSetList.forEach((menuSet) => {

         const menuList = menuSet.querySelectorAll('.nav-menus-wrapper li:has(ul li)');

         menuList.forEach((menu) => {
           
           menu.addEventListener('mouseover', () => {

             const megamenu = menu.querySelector('.megamenu') || menu.querySelector('.dropdown');

             if (megamenu) {

               if (megamenu.style.display !== 'block') {

                 megamenu.style.display = 'block';

               }

             }

           });

           menu.addEventListener('mouseout', () => {

             const megamenu = menu.querySelector('.megamenu') || menu.querySelector('.dropdown');

             if (megamenu) {

               if (megamenu.style.display === 'block') {

                 megamenu.style.display = 'none';

               }

             }

           });

         });

       });

       function toggleSliderHandler(e) {

         e.stopPropagation();

         e.preventDefault();

         const parentElementToggle = e.target.parentElement.parentElement.parentElement;

         const mobileNavigation = document.querySelector('.navigation');

         const navMenuMobile = parentElementToggle.querySelector('.nav-sidepanel');

         if (navMenuMobile) {

           navMenuMobile.style.height = 'auto';

           navMenuMobile.style.transition = '0.5s';

           navMenuMobile.style.width = '100%';

           mobileNavigation.style.marginTop = '0';

           mobileNavigation.classList.add('navigation_mobile_active');
         }



         const sourceDiv = parentElementToggle?.querySelector('.nav-menus-wrapper');

         const clone = sourceDiv?.cloneNode(true);

         if (navMenuMobile) {

           const navMenuMobilewrapper = navMenuMobile.querySelector('.nav-sidepanel-wrapper');

           navMenuMobilewrapper?.appendChild(clone);

           navMenuMobilewrapper.style.paddingTop = '45px';

           const navSidepanel = document.querySelector('.nav-sidepanel');

           navSidepanel.style.height = `${window.innerHeight}px`;

           const navMenuMob = navMenuMobile?.querySelector('.nav-menus-wrapper');

           navMenuMob.style.display = 'block';

           if (navSidepanel.querySelectorAll('.bottom').length <= 1) {

             const bottomSelector = document.querySelector('.bottom');

             navMenuMobile?.appendChild(bottomSelector);

           }

         }



         // Get a reference to the .nav-menus-wrapper element

         const navMenusWrapper = document.querySelector('.nav-menus-wrapper');



         // Check if it exists and if it contains an element with the class .bottom

         if (navMenusWrapper) {

           const bottomElement = navMenusWrapper.querySelector('.bottom');

           // If the .bottom element exists, remove it

           if (bottomElement) {

             navMenusWrapper.removeChild(bottomElement);

           }

         }



         // Handle the click action for ul items

         const mobileViewMenuList = parentElementToggle.querySelector('.nav-sidepanel');

         const navList = mobileViewMenuList?.querySelectorAll('.nav-menus-wrapper li:has(ul li');

         if (navList) {

           navList?.forEach((list) => {

             const spanEle = document.createElement('span');

             spanEle.classList.add('icon-semi-arrow-down');

             if (!list.querySelector('.icon-semi-arrow-down') && !list.querySelector('.icon-semi-arrow-up')) {

               if (!list.classList.contains('nav-toggle')) {

                 const liHref = list.querySelector('li > megamenu');

                 list?.insertBefore(spanEle, liHref);

               }

             }

             const caretAction = list.querySelector('.icon-semi-arrow-down') || list.querySelector('.icon-semi-arrow-up');

             caretAction?.addEventListener('click', () => {

               navList.forEach((activeItem) => {

                 if (caretAction.parentElement !== activeItem) {

                   const megamenuItem = activeItem.querySelector('.megamenu') || activeItem.querySelector('.dropdown');

                   megamenuItem.classList.remove('active');

                 }

               });

               const megamenu = list.querySelector('.megamenu') || list.querySelector('.dropdown');

               if (megamenu) {

                 if (megamenu.classList.contains('active')) {

                   megamenu.classList.remove('active');

                   caretAction.classList.replace('icon-semi-arrow-up', 'icon-semi-arrow-down');

                 } else {

                   megamenu.classList.add('active');

                   caretAction.classList.replace('icon-semi-arrow-down', 'icon-semi-arrow-up');

                 }

               }



               navList.forEach((activeItem) => {

                 if (caretAction.parentElement !== activeItem) {

                   const megamenuItem1 = activeItem.querySelector('.megamenu') || activeItem.querySelector('.dropdown');

                   const caretAction1 = megamenuItem1.parentElement.querySelector('.icon-semi-arrow-down') || megamenuItem1.parentElement.querySelector('.icon-semi-arrow-up');

                   caretAction1?.classList.replace('icon-semi-arrow-up', 'icon-semi-arrow-down');

                 }

               });

             });

           });

         }

       }

       function mobileCloseHandler(e) {

         e.stopPropagation();

         e.preventDefault();

         const navSidePanel = document.querySelector('.nav-sidepanel');

         const mobileNavMenu = navSidePanel?.querySelector('.nav-menus-wrapper');

         const parentElementToggle = e.target.parentElement.parentElement.parentElement;

         const mainWapper = parentElementToggle.parentElement.parentElement;



         const mobileNavigation = document.querySelector('.navigation');

         try {

           if (e.target.classList.contains('icon-close')) {

             mainWapper.style.width = '0';

             mainWapper.style.minHeight = `${window.innerHeight}px`;

             mobileNavMenu?.remove();

             return true;

           }

         } finally {

           mainWapper.style.height = '0px';

           mainWapper.style.minHeight = '0px';

           mobileNavigation.style.marginTop = '45px';

           mobileNavigation.classList.remove('navigation_mobile_active');

         }

         return true;

       }



       const navbar = document.querySelector('nav');

       const sticky = navbar?.offsetTop;

       const toggleThemeDarkBar = document.querySelector('.navbar-theme-dark .icon-nav-menu');

       const toggleLightDarkBar = document.querySelector('.navbar-theme-light .icon-nav-menu');

       function myFunction() {

         if (window.scrollY >= sticky) {

           navbar.classList.add('sticky');
           
            if (toggleThemeDarkBar) {
              toggleThemeDarkBar.style.color = '#2E3D4C';
            }

         }

         if (window.scrollY === 0) {

           navbar.classList.remove('sticky');

           if (toggleThemeDarkBar) {
             toggleThemeDarkBar.style.color = '#fff';
           }

           if(toggleLightDarkBar){
             toggleLightDarkBar.style.color = '#2E3D4C';
           }

         }

       }

       window.onscroll = function () { myFunction(); };



       function handleResize() {

         const navToggle = document.querySelector('.nav-toggle');

         navToggle.addEventListener('click', toggleSliderHandler);

         const findMenuHandler = document.querySelector('.nav-sidepanel > .nav-menus-wrapper');

         const sidePanelHeight = document.querySelector('.nav-sidepanel');

         const mobileNavMenu = sidePanelHeight?.querySelector('.nav-menus-wrapper');

         if (findMenuHandler && !isMobileAndTabView()) {

           findMenuHandler.style.display = 'none';

           sidePanelHeight.style.minHeight = '0';

           sidePanelHeight.style.width = 'unset';

         } else if (findMenuHandler) {

           findMenuHandler.style.display = 'block';

           sidePanelHeight.style.minHeight = '0';

           sidePanelHeight.style.width = '100%';

         }

         const toggleClose = document.querySelector('.close');

         toggleClose.addEventListener('click', mobileCloseHandler);

         sidePanelHeight.style.minHeight = '0';

         sidePanelHeight.style.height = '0';

         mobileNavMenu?.remove();

       }

       // adding script for handling mobile view

       if (isMobileAndTabView()) {

         menuSetList.forEach((menuSet) => {

           const navToggle = menuSet.querySelector('.nav-toggle');

           navToggle.addEventListener('click', toggleSliderHandler);

           const toggleClose = menuSet.querySelector('.close');

           toggleClose.addEventListener('click', mobileCloseHandler);

         });

       }

       window.addEventListener('resize', handleResize);

  // // FIX TITLE
  function handleLiClick(event) {
    const liURL = event.currentTarget.getAttribute('data-url');
    window.location.href = liURL;
  }

  const megaMenu = document.querySelectorAll('.megamenu-wrapper-frame-2 li');
  megaMenu.forEach(li => li.onclick = handleLiClick);

  const dropdownMenu = document.querySelectorAll('.dropdown li');
  dropdownMenu.forEach(li => li.onclick = handleLiClick);

});