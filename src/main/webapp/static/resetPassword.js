jQuery(App);
function App($) {
    $("#confp").on("keyup", function () {
        if ($("#p").val() !== $("#confp").val()) {
            $("#s").prop("disabled", true);
            $("#conft").html("confirm password and password do not match");
        } else {
            $("#s").prop("disabled", false);
            $("#conft").html("");

        }
    });

    
    $("#p").on("keyup", function () {
        if ($("#confp").val() !== "") {
            if ($("#p").val() !== $("#confp").val()) {
                $("#s").prop("disabled", true);
                $("#conft").html("confirm password and password do not match");
            } else {
                $("#s").prop("disabled", false);
                $("#conft").html("");

            }
        }
    });

}
