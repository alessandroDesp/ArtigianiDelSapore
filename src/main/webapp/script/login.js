function accedi(){
    var email = $('#emailId').val();
    var password = $('#passwordId').val();
    var ricordami = $('#ricordamiId').is(":checked");
    var data ={
        textEmail : email,
        textPassword : password,
        textRicordami : ricordami
    }

    $.ajax({
        url: 'Login',
        dataType: "json",
        type: "post",
        data: data,
        success: function (result) {
            if(result.Ris == 1) {
                alert(result.Mess)
            }else {
                alert(result.Mess)
            }
        }
    });
}