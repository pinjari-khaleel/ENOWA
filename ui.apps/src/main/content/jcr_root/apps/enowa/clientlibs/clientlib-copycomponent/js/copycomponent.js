(function($, Coral) {
    "use strict";

    console.log(" --------CLIENTLIBS LOADED------- ");

        var registry = $(window).adaptTo("foundation-registry");
     /////////// Set max Value to title
          registry.register("foundation.validation.validator", {
                selector: "[data-validation=copycomponent-max-title-validation]",
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

   /////////// Set max Value to Bigtitle
               registry.register("foundation.validation.validator", {
                            selector: "[data-validation=copycomponent-max-bigtitle-validation]",
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

                         /////////// Set max Value to Bigtitle
                                       registry.register("foundation.validation.validator", {
                                                    selector: "[data-validation=copycomponent-max-headertitle-validation]",
                                                    validate: function(element) {
                                                        let el = $(element);
                                                        let value = el.val();
                                                        // Check if the length exceeds the maximum length (15 characters)
                                                        let maxLength = 150;
                                                        if (value.length > maxLength) {
                                                            return "Maximum length should be " + maxLength + " characters";
                                                        }
                                                    }
                                                });

})(jQuery, Coral);