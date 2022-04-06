function validateFormPagamento() {
    const regexNome = new RegExp("^[A-z'-( *)]{2,30}$");
    const regexCF = new RegExp("^[A-z0-9]{16}$");
    const regexEmail = new RegExp("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$");
    const regexCodiceSicurezza = new RegExp("^[0-9]{3}$");
    const regexCartaCredito = new RegExp("^[0-9]{16}$");
    const regexIndirizzo = new RegExp("^[A-Za-z0-9'._%+\\s-]{2,55}$");
    const regexCodicePostale = new RegExp("^[0-9]{2,10}$");


    let nome = $('#nomeId').val();
    let cognome = $('#cognomeId').val();
    let codiceFiscale = $('#codiceFiscaleId').val();
    let indirizzoEmail = $('#indirizzoEmailId').val();
    let codiceSicurezza = $('#codiceSicurezzaId').val();
    let numeroCartaCredito = $('#numeroCartaCreditoId').val();
    let indirizzo = $('#indirizzoId').val();
    let citta = $('#cittaId').val();
    let nazione = $('#nazioneId').val();
    let codicePostale = $('#codicePostaleId').val();

    if (!regexIndirizzo.test(indirizzo)) {
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci un indirizzo di residenza valido!',
        })
        return false;
    }
    if (!regexIndirizzo.test(citta)) {
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci una citta di residenza valida!',
        })
        return false;
    }
    if (!regexIndirizzo.test(nazione)) {
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci una nazione valida!',
        })
        return false;
    }
    if (!regexCodicePostale.test(codicePostale)) {
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci un codice postale valido!',
        })
        return false;
    }
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
    if (!regexCartaCredito.test(numeroCartaCredito)) {
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci una carta di credito valida!',
        })
        return false;
    }
    if (!regexCodiceSicurezza.test(codiceSicurezza)) {
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci un codice di sicurezza valido!',
        })
        return false;
    }

    return true;
}