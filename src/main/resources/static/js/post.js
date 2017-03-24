$(document).ready(function () {

    // SUBMIT FORM
    $("#customerForm").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPost();
        reload()
    });


    function ajaxPost() {

        // PREPARE FORM DATA
        var formData = {
            name: $("#name").val(),
            age: $("#age").val(),
            address: $("#address").val()
        };

        // DO POST
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/add",
            data: JSON.stringify(formData),
            dataType: 'json'
        });

        // Reset FormData after Posting
        resetData();

    }

    function resetData() {
        $("#name").val("");
        $("#age").val("");
        $("#address").val("");
    }

    function reload() {
        window.location.reload();
    }

});