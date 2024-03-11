/* global jQuery, Coral */
(function($, Coral) {
    "use strict";

    console.log(" --------CLIENTLIBS LOADED------- ");

   var registry = $(window).adaptTo("foundation-registry");

// Set max Value to title
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=max-value-validation-news]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (15 characters)
            let maxLength = 30;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

 // Set max Value to Description
            registry.register("foundation.validation.validator", {
                selector: "[data-validation=max-description-validation-news]",
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


            //Drop Down -----------------------------------------------------------------------------------------

            // when dialog gets injected
                $(document).on("foundation-contentloaded", function(e) {
                    // if there is already an inital value make sure the according target element becomes visible
                    showHideHandler($(".cq-dialog-dropdown-showhide-multival", e.target));
                });

                $(document).on("selected", ".cq-dialog-dropdown-showhide-multival", function(e) {
                    showHideHandler($(this));
                });

                function showHideHandler(el) {
                    el.each(function(i, element) {
                        if ($(element).is("coral-select")) {
                            // handle Coral3 base drop-down
                            Coral.commons.ready(element, function(component) {
                                showHide(component, element);
                                component.on("change", function() {
                                    showHide(component, element);
                                });
                            });
                        } else {
                            // handle Coral2 based drop-down
                            var component = $(element).data("select");
                            if (component) {
                                showHide(component, element);
                            }
                        }
                    })
                }

                function showHide(component, element) {
                    // get the selector to find the target elements. its stored as data-.. attribute
                    var target = $(element).data("cqDialogDropdownShowhideTarget");
                    var $target = $(target);
                    var elementIndex = $(element).closest('coral-multifield-item').index();

                    if (target) {
                        var value;
                        if (component.value) {
                            value = component.value;
                        } else {
                            value = component.getValue();
                        }
                        $target.each(function(index) {
                            var tarIndex = $(this).closest('coral-multifield-item').index();
                            if (elementIndex == tarIndex) {
                                $(this).not(".hide").addClass("hide");
                                $(this).filter(function() {
                                    return $(this).data('showhidetargetvalue').replace(/ /g, '').split(',').includes(value);
                                }).removeClass("hide");
                            }
                        });
                    }
                }
 //Drop Down -----------------------------------------------------------------------------------------

})(jQuery, Coral);