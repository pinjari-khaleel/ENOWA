(function($document, $) {
    "use strict";

     $document.on("dialog-loaded", function (e) {
        updateTooltip(e)
     });

     $document.on("selected", "coral-multifield", function (e) {
        updateTooltip(e)
     });

    function updateTooltip(e){

        let coralMultifieldItems = $(e.currentTarget).find("coral-multifield-item-content");

        for (let i = 0; i < coralMultifieldItems.length; i++) {

            let item = $(coralMultifieldItems[i]);
            var variation = item.find('.landing_infographic_block_variation');
            var selected =  variation.find('.coral-Select-button-text');

            if(selected[0].outerText == 'Button-only variant') {
                item.find("._coral-Tooltip-label")[0].innerHTML='15 characters'
                item.find("._coral-Tooltip-label")[1].innerHTML='50-55 characters'
            }

            else {
                item.find("._coral-Tooltip-label")[0].innerHTML='65 characters'
                item.find("._coral-Tooltip-label")[1].innerHTML='160 characters'
            }
        }
    }

})($(document), jQuery);
