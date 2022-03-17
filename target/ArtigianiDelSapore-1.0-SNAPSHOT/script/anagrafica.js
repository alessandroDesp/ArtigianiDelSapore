function modificaAnagrafica(){
    var id = $("#idUtente").val();
    var token = $("#tokenAuth").val();
    var nome = $("#nomeId").val();
    var cognome = $("#cognomeId").val();
    var codiceFiscale = $("#codiceFiscaleId").val();
    var dataNascita = $("#dataNascitaId").val();
    var email = $("#indirizzoEmailId").val();
    var data = {
        textIdUtente : id,
        textToken : token,
        textNome : nome,
        textCognome : cognome,
        textCodiceFiscale : codiceFiscale,
        textDataNascita : dataNascita,
        textEmail : email
    };
    $.ajax({
        url: 'ModificaAnagrafica',
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



function modificaPassword(){
    var id = $("#idUtente").val();
    var token = $("#tokenAuth").val();
    var nuovaPassword = $("#nuovaPasswordId").val();
    var ripetiPassword = $("#ripetiPasswordId").val();
    var vecchiaPassword = $("#vecchiaPasswordId").val();

    var data ={
        textIdUtente : id,
        textToken : token,
        textNuovaPassword : nuovaPassword,
        textRipetiPassword : ripetiPassword,
        textVecchiaPassword : vecchiaPassword
    }

    $.ajax({
        url: 'ModificaPassword',
        dataType: "json",
        type: "post",
        data: data,
        success: function (result) {
            if(result.Ris == 1) {
                alert(result.Mess);
                $("#VecchiaPassword").val("");
                $("#NuovaPassword").val("");
                $("#RipetiPassword").val("");
            }else {
                alert(result.Mess)
            }
        }
    });
}