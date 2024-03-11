$(function () {
	const currentUrl = window.top.location.href;
    console.log('currentUrl: ' + currentUrl);
    if (currentUrl.indexOf('/editor.html/') > -1) {
        console.log('has editor.html');
        $('.carousel-container .carousel-card').css({
        	height: $(window).height()
        });
    }
});
