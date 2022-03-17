function registrati(){
    var nome = $('#nomeId').val();
    var cognome = $('#cognomeId').val();
    var codiceFiscale = $('#codiceFiscaleId').val();
    var dataNascita = $('#dataNascitaId').val();
    var indirizzoEmail = $('#indirizzoEmailId').val();
    var password = $('#passwordId').val();

    var data ={
        textNome : nome,
        textCognome : cognome,
        textCodiceFiscale : codiceFiscale,
        textDataNascita : dataNascita,
        textIndirizzoEmail : indirizzoEmail,
        textPassword : password
    }

    $.ajax({
        url: 'Registrazione',
        dataType: "json",
        type: "post",
        data: data,
        success: function (result) {
            if(result.Ris == 1) {
                if(!alert(result.Mess)){window.location.reload();}
            }else {
                alert(result.Mess)
            }
        }
    });
}