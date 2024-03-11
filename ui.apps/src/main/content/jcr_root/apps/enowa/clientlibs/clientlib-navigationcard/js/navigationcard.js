/* global jQuery, Coral */
(function($, Coral) {
    "use strict";

    console.log(" --------CLIENTLIBS LOADED------- ");

        var registry = $(window).adaptTo("foundation-registry");
     /////////// Set max Value to Description
          registry.register("foundation.validation.validator", {
                selector: "[data-validation=navigationcard-max-description-validation]",
                validate: function(element) {
                    let el = $(element);
                    let value = el.val();
                    // Check if the length exceeds the maximum length (15 characters)
                    let maxLength = 300;
                    if (value.length > maxLength) {
                        return "Maximum length should be " + maxLength + " characters";
                    }
                }
            });

})(jQuery, Coral);