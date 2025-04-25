$(document).ready(function() {
    $('#btn').click(function() {
        

        let formData = new FormData();
        let name = $('#name').val();
        let skills = [];

        $('input[name="skills"]:checked').each(function() {
            skills.push($(this).val());
        });

        let files = $('#files')[0].files;
        for (let i = 0; i < files.length; i++) {
            formData.append('files', files[i]);
        }

        formData.append('name', name);
        formData.append('skills', skills.join(','));

        $.ajax({
            url: '/submit', // Change this to your server endpoint
            type: 'POST',
            data: formData,
            processData: false,
            contentType: false,
            success: function(response) {
                alert("Form submitted successfully!");
                console.log(response);
            },
            error: function(err) {
                alert("Error submitting form.");
                console.log(err);
            }
        });
    });
});
