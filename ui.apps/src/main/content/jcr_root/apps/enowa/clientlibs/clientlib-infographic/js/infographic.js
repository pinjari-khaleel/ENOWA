/* global jQuery, Coral */
(function($, Coral) {
    "use strict";

    console.log(" --------CLIENTLIBS LOADED------- ");

   var registry = $(window).adaptTo("foundation-registry");
    /////////// Set max Value to title
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=infographic-max-title-validation]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (15 characters)
            let maxLength = 10;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

        /////////// Set max Value to CTA
        registry.register("foundation.validation.validator", {
            selector: "[data-validation=infographic-max-cta-validation]",
            validate: function(element) {
                let el = $(element);
                let value = el.val();
                // Check if the length exceeds the maximum length (15 characters)
                let maxLength = 15;
                if (value.length > maxLength) {
                    return "Maximum length should be " + maxLength + " characters";
                }
            }
        });

            /////////// Set max Value to Description
            registry.register("foundation.validation.validator", {
                selector: "[data-validation=infographic-max-description-validation]",
                validate: function(element) {
                    let el = $(element);
                    let value = el.val();
                    // Check if the length exceeds the maximum length (15 characters)
                    let maxLength = 50;
                    if (value.length > maxLength) {
                        return "Maximum length should be " + maxLength + " characters";
                    }
                }
            });

})(jQuery, Coral);
