$(document).ready(function () {
    //Validation of User edit form
    $.validator.setDefaults({
        errorClass: 'help-block',
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
        }
    });
    
    $("#userForm").validate({
        rules: {
            "email": {
                required: true,
                email: true,
                maxlength: 32
            },
            "firstName": {
                required: true,
                maxlength: 20
            },
            "lastName": {
                required: true,
                maxlength: 20
            }
        },
        messages: {
            "email": {
                required: "Please enter email",
                maxlength: "Email must be not longer than 32 characters",
                email: "Please enter valid email"
            },
            "firstName": {
                required: "Please enter first name",
                maxlength: "First name must be not longer than 20 characters"
            },
            "lastName": {
                required: "Please enter last name ",
                maxlength: "Last name must be not longer than 20 characters"
            },
        }
    });

    //text editor
    CKEDITOR.replace('editor1', {toolbar: 'Basic'});

    //Edit User
    $('#chooseProject').change(function(){
        //show fields of choosing user role and project
        if ($(this).is(':checked')){
            $('#role').show();
            $('#project').show();
            alert($('#projectInput').val() == 0);
            if($('#projectInput').val() == 0){
                $('#roleInput').prop('disabled', true);
            }
        }else{
            $('#project').hide();
            $('#role').hide();
            $('#projectInput').val($('#projectDefault').html()).change();
            $('#roleInput').val($('#roleDefault').html()).change();
        }
    });

    //validation of input of user's role
    $('#projectInput').select().on("change", function() {
        $('#roleInput').prop('disabled', true);
        if($('#projectInput').val() != 0){
            $('.roleOptionUser').hide();
            $('#roleInput').val('ROLE_QA').change();
            $('#roleInput').prop('disabled', false);
        }if(($('#projectInput').val() == 0)) {
            $('#roleInput').val('ROLE_USER').change();
            $('.roleOptionUser').show();
            $('#roleInput').prop('disabled', true);
        }
    });

    //validation of input of user's project
    $(function () {
        $('#roleInput').select().on("change", function () {
            if($('#projectInput').val() != 0 && $('#roleInput').val() == 'ROLE_USER'){
                $('#projectInput').val(0).change();
            }
        });
    });

    //cancel button of form
    $("#cancelBtn").click(function(event){
        event.preventDefault();
        window.location.href = document.referrer;
    });
});