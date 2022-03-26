function accedi() {
    var email = $('#emailId').val();
    var password = $('#passwordId').val();
    var ricordami = $('#ricordamiId').is(":checked");
    var data = {
        textEmail: email,
        textPassword: password,
        textRicordami: ricordami
    }
    if (checkRegex()){
        $.ajax({
            url: 'Login',
            dataType: "json",
            type: "post",
            data: data,
            success: function (result) {
                if (result.Ris == 1) {
                    if (!alert(result.Mess)) {
                        window.location.reload();
                    }
                } else {
                    alert(result.Mess)
                }
            }
        });
    }
}

function checkRegex() {
    const regexEmail = new RegExp("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$");
    const regexPassword = new RegExp("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}:;',?+\\*~$^=<>]).{8,20}$");
    var indirizzoEmail = $('#emailId').val();
    var password = $('#passwordId').val();

    if (!regexEmail.test(indirizzoEmail)) {
        alert("Inserisci un email valida!");
        return false;
    }
    if (!regexPassword.test(password)) {
        alert("La password deve contenere almeno una lettera maiuscola,una minuscola, un numero e un carattere speciale e deve essere da 8 a 20 caratteri");
        return false;
    }
    return true;
}