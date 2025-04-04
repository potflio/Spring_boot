$(document).ready(function () {
    $('#userForm').submit(function (e) {
        e.preventDefault(); // Prevent normal form submission

        const name = $('#name').val();
        const age = $('#age').val();
        const mobile = $('#mobile').val();

        $.ajax({
            url: '/submit',  // Adjusted URL
            type: 'POST',
            data: {
                name : name,
                age : age,
                mobile : mobile
            },
            success: function (response) {
                $('#responseMessage').text("User saved successfully!");
                $('#userForm')[0].reset(); // clear form
            },
            error: function () {
                $('#responseMessage').text("Something went wrong.");
            }
        });
    });
});