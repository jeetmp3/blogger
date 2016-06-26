/**
 * Created by jitendra on 26/6/16.
 */
(function () {
    jQuery(document).ready(function () {
        jQuery("#logout-link").click(function () {
            jQuery("#logout-form").submit();
        });
    });
})();