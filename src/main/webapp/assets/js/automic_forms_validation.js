/*
 *  Document   : automic_forms_validation.js
 */
var AutomicFormValidation = function () {
    var func = function () {
        jQuery(".js-validation-material").validate({
            ignore: [],
            errorClass: "help-block text-right animated fadeInDown",
            errorElement: "div",
            errorPlacement: function (e, r) {
                jQuery(r).parents(".form-group > div").append(e)
            },
            highlight: function (e) {
                var r = jQuery(e);
                r.closest(".form-group").removeClass("has-error").addClass("has-error"), r.closest(".help-block").remove()
            },
            success: function (e) {
                var r = jQuery(e);
                r.closest(".form-group").removeClass("has-error"), r.closest(".help-block").remove()
            },
            rules: {
                "query": {required: !0}
            },
            messages: {
                "query": "Nội dung tìm kiếm chưa được nhập vào."
            }
        })
    };
    return {
        init: function () {
            func()
        }
    }
}();
jQuery(function () {
    AutomicFormValidation.init()
});