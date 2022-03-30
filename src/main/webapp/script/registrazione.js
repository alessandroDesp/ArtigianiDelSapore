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
    if(checkRegex()) {
        $.ajax({
            url: 'Registrazione',
            dataType: "json",
            type: "post",
            data: data,
            success: function (result) {
                if(result.Ris == 1) {
                    Swal.fire({
                        icon: 'success',
                        title: result.Mess,
                    }).then(function () {
                        window.location.href = "./";
                    })
                }else {
                    Swal.fire({
                        icon: 'error',
                        title: 'Errore',
                        text: result.Mess,
                    })
                }
            }
        });
    }
}

function checkRegex() {
    const regexNome = new RegExp("^[A-z'-( *)]{2,30}$");
    const regexCF = new RegExp("^[A-z0-9]{16}$");
    const regexEmail = new RegExp("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$");
    const regexPassword = new RegExp("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}:;',?+\\*~$^=<>]).{8,20}$");
    var nome = $('#nomeId').val();
    var cognome = $('#cognomeId').val();
    var codiceFiscale = $('#codiceFiscaleId').val();
    var indirizzoEmail = $('#indirizzoEmailId').val();
    var password = $('#passwordId').val();

    if (!regexNome.test(nome)) {
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci un nome valido!',
        })
        return false;
    }
    if (!regexNome.test(cognome)) {
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci un cognome valido!',
        })
        return false;
    }
    if (!regexCF.test(codiceFiscale)) {
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci un codice fiscale valido!',
        })
        return false;
    }
    if (!regexEmail.test(indirizzoEmail)) {
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci un email valida!',
        })
        return false;
    }
    if (!regexPassword.test(password)) {
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'La password deve contenere almeno una lettera maiuscola,una minuscola, un numero e un carattere speciale e deve essere da 8 a 20 caratteri',
        })
        return false;
    }
    if ($('#dataNascitaId').val() != ''){
        var dataNascita = new Date($('#dataNascitaId').val());
        var dataAttuale = new Date();
        if (dataNascita > dataAttuale) {
            Swal.fire({
                icon: 'error',
                title: 'Errore',
                text: 'La data di nascita non è consentita',
            })
            return false;
        }
    }else{
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci una data',
        })
        return false;
    }
    return true;
}