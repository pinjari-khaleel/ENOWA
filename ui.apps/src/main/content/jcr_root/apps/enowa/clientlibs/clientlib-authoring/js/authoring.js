/* global jQuery, Coral */
(function($, Coral) {
    "use strict";

    console.log(" --------CLIENTLIBS LOADED------- ");

    var registry = $(window).adaptTo("foundation-registry");

    // Set max Value to title
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=max-value-validation-page]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (100 characters)
            let maxLength = 100;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    // Set max Value to Description
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=max-description-validation-page]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (100 characters)
            let maxLength = 100;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    // Set max Value to CTA button
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=max-cta-validation-page]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (80 characters)
            let maxLength = 80;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    // Testimonials validation

    registry.register("foundation.validation.validator", {
        selector: "[data-validation=max-testimonials-validation-title]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();

            let maxLength = 210;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    registry.register("foundation.validation.validator", {
        selector: "[data-validation=max-testimonials-validation-quote]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();

            let maxLength = 200;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });



    // latest news

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
            // Check if the length exceeds the maximum length (500 characters)
            let maxLength = 500;
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



    //Header corosel

    // Set max Value to title
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=max-value-validation-header]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            let maxLength = 100;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });


    //Drop Down 1-----------------------------------------------------------------------------------------

    // when dialog gets injected
    $(document).on("foundation-contentloaded", function(e) {
        // if there is already an inital value make sure the according target element becomes visible
        showHideHandler($(".cq-dialog-dropdown-showhide-first", e.target));
    });

    $(document).on("selected", ".cq-dialog-dropdown-showhide-first", function(e) {
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
    //Drop Down 1-----------------------------------------------------------------------------------------
    //Drop Down 2-----------------------------------------------------------------------------------------

    // when dialog gets injected
    $(document).on("foundation-contentloaded", function(e) {
        // if there is already an inital value make sure the according target element becomes visible
        showHideHandler($(".cq-dialog-dropdown-showhide-second", e.target));
    });

    $(document).on("selected", ".cq-dialog-dropdown-showhide-second", function(e) {
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
    //Drop Down 2-----------------------------------------------------------------------------------------



    ///////////////////////////////////////////////////////////// video component//////////////////////////////////////////////////////////////////////////////////////////////////


    /////////// Set max Value to title
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=videocomponent-max-title-validation]",
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

    /////////// Set max Value to description
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=videocomponent-max-description-validation]",
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


    ///////////////////////////////////////////////////////////// video component//////////////////////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////////teamcards/////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////// Set max Value to title
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=teamcards-max-title-validation]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (15 characters)
            let maxLength = 20;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    /////////// Set max Value to name
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=teamcards-max-name-validation]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (15 characters)
            let maxLength = 20;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    /////////// Set max Value to description
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=teamcards-max-description-validation]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (15 characters)
            let maxLength = 1500;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    ////////////////////////////////////////////////////////////teamcards/////////////////////////////////////////////////////////////////////////////////////////////////////////////



    ///////////////////////////////////////////////////tableinfo///////////////////////////////////////////////////////////////

    /////////// Set max Value to title
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=tableinfo-max-headerTitle-validation]",
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


    /////////// Set max Value to headerDescription
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=tableinfo-max-title-validation]",
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


    /////////// Set max Value to headerDescription
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=tableinfo-max-headerDescription-validation]",
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

    /////////// Set max Value to description
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=tableinfo-max-description-validation]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (15 characters)
            let maxLength = 100;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    /////////// Set max Value to iconDescription
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=tableinfo-max-iconDescription-validation]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (15 characters)
            let maxLength = 100;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    ///////////////////////////////////////////////////tableinfo///////////////////////////////////////////////////////////////


 ///////////////////////////////////////////////////tableinfo2///////////////////////////////////////////////////////////////

    /////////// Set max Value to header title
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=tableinfotwo-max-headerTitle-validation]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (20 characters)
            let maxLength = 20;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });


    /////////// Set max Value to table info title
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=tableinfotwo-max-title-validation]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (30 characters)
            let maxLength = 30;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });



    ///////////////////////////////////////////////////tableinfo2///////////////////////////////////////////////////////////////


    ///////////////////////////////////////////// Stepper/////////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////// Set max Value to title
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=stepper-max-title-validation]",
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
    /////////// Set max Value to Block title
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=stepper-max-blockTitle-validation]",
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


    /////////// Set max Value to blockDescription
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=stepper-max-blockDescription-validation]",
        validate: function(element) {
            let el = $(element);
            let value = el[0].innerText;
            // Check if the length exceeds the maximum length (15 characters)
            let maxLength = 210;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    /////////// Set max Value to Description
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=stepper-max-description-validation]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (15 characters)
            let maxLength = 210;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });


    //Drop Down -----------------------------------------------------------------------------------------

    // when dialog gets injected
    $(document).on("foundation-contentloaded", function(e) {
        // if there is already an inital value make sure the according target element becomes visible
        showHideHandler($(".cq-dialog-dropdown-showhide-stepper", e.target));
    });

    $(document).on("selected", ".cq-dialog-dropdown-showhide-stepper", function(e) {
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

    ///////////////////////////////////////////// Stepper/////////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////navigation card////////////////////////////////////////////////////////////////////////

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


    //Drop Down -----------------------------------------------------------------------------------------

    // when dialog gets injected
    $(document).on("foundation-contentloaded", function(e) {
        // if there is already an inital value make sure the according target element becomes visible
        showHideHandler($(".cq-dialog-dropdown-showhide-navigationcard", e.target));
    });

    $(document).on("selected", ".cq-dialog-dropdown-showhide-navigationcard", function(e) {
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
    /////////////////////////////////////////navigation card////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////infographics////////////////////////////////////////////////////////////////////////

    /////////// Set max Value to headertitle
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=infographics-max-headerTitle-validation-title]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (15 characters)
            let maxLength = 20;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    /////////// Set max Value to headerDescription
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=infographics-max-headerDescription-validation-description]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (15 characters)
            let maxLength = 200;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    /////////// Set max Value to description
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=infographics-max-description-validation-multidescription]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (15 characters)
            let maxLength = 70;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    //Drop Down -----------------------------------------------------------------------------------------

        // when dialog gets injected
        $(document).on("foundation-contentloaded", function(e) {
            // if there is already an inital value make sure the according target element becomes visible
            showHideHandler($(".cq-dialog-dropdown-showhide-infographics", e.target));
        });

        $(document).on("selected", ".cq-dialog-dropdown-showhide-infographics", function(e) {
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
    //////////////////////////////////////////infographics////////////////////////////////////////////////////////////////////////



    //////////////////////////////////////////////////infographic//////////////////////////////////////////////////////////////////

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

    //Drop Down -----------------------------------------------------------------------------------------

    // when dialog gets injected
    $(document).on("foundation-contentloaded", function(e) {
        // if there is already an inital value make sure the according target element becomes visible
        showHideHandler($(".cq-dialog-dropdown-showhide-infographic", e.target));
    });

    $(document).on("selected", ".cq-dialog-dropdown-showhide-infographic", function(e) {
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

    //////////////////////////////////////////////////infographic////////////////////////////////////////////////


    //////////////////////////////////horizontal Accordion////////////////////////////////////////////////////

    /////////// Set max Value to title
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=horizontalaccordion-max-title-validation]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (15 characters)
            let maxLength = 80;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    /////////// Set max Value to description
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=horizontalaccordion-max-description-validation]",
        validate: function(element) {
            let el = $(element);
            let value = el.val();
            // Check if the length exceeds the maximum length (15 characters)
            let maxLength = 500;
            if (value.length > maxLength) {
                return "Maximum length should be " + maxLength + " characters";
            }
        }
    });

    /////////// Set max Value to iconTitle
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=horizontalaccordion-max-iconTitle-validation]",
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


    /////////// Set max Value to iconDescription
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=horizontalaccordion-max-iconDescription-validation]",
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
        showHideHandler($(".cq-dialog-dropdown-showhide-horizontalaccordin", e.target));
    });

    $(document).on("selected", ".cq-dialog-dropdown-showhide-horizontalaccordin", function(e) {
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
    //////////////////////////////////horizontal Accordion////////////////////////////////////////////////////


    ////////////////////////////////////////////////copy component////////////////////////////////////////////////////////////

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


    //Drop Down -----------------------------------------------------------------------------------------

    // when dialog gets injected
    $(document).on("foundation-contentloaded", function(e) {
        // if there is already an inital value make sure the according target element becomes visible
        showHideHandler($(".cq-dialog-dropdown-showhide-copycomponent", e.target));
    });

    $(document).on("selected", ".cq-dialog-dropdown-showhide-copycomponent", function(e) {
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

    registry.register("foundation.validation.validator", {
        selector: "[data-validation=svg-media-validation]",
        validate: function(element) {
            var value = element.value;
            var fileExtension = value.split('.').pop().toLowerCase();
            if (fileExtension !== "svg") {
                return "Only SVG files are allowed.";
            }
        }
    });

    registry.register("foundation.validation.validator", {
        selector: "[data-validation=svg-png-media-validation]",
        validate: function(element) {
            var value = element.value;
            var fileExtension = value.split('.').pop().toLowerCase();
            if (fileExtension !== "png" && fileExtension !== "svg") {
                return "Only SVG and PNG files are allowed.";
            }
        }
    });


    ////////////////////////////////////////////////copy component//////////////////////////////////////////////////////////////////


})(jQuery, Coral);
