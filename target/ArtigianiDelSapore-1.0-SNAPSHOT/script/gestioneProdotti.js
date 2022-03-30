function iconModificaProdotti(id,nome,prezzo,sconto,quantitaAttuale,quantitaVenduta,descrizione){
    $("#idProdotto").val(id);
    $("#nomeId").val(nome);
    $("#prezzoId").val(prezzo);
    $("#scontoId").val(sconto);
    $("#quantitaAttualeId").val(quantitaAttuale);
    $("#quantitaVendutaId").val(quantitaVenduta);
    $("#descrizioneId").val(descrizione);
    $("#categorieAggiunte").val( $("#categorieAggiunte").val() + "[" + categorieDaAggiungere + "]");
}

function iconAggiungiQuantitaProdotto(id,nome,quantitaAttuale){
    $("#idProdottoQuantita").val(id);
    $("#nomeIdQuantita").val(nome);
    $("#quantitaAttualeIdQuantita").val(quantitaAttuale);
}

function addCategoria(){
    var categorieAggiunte = $("#categorieAggiunte").val();
    var categorieDaAggiungere = $("#categoriaId option:selected").text();
    if(!categorieAggiunte.includes(categorieDaAggiungere) &&  !($("#categoriaId").val() == "")){
        $("#categorieAggiunte").val(categorieAggiunte + "[" + categorieDaAggiungere + "]");
        $("#categorieAggiunteId").val($("#categorieAggiunteId").val() + $("#categoriaId").val() + "-");
    }
}

function validateFormCreazione(){
    var nome = $('#creazioneNome').val();
    var prezzo = $('#creazionePrezzo').val();
    var descrizione = $('#creazioneDescrizione').val();
    return regex(nome,descrizione,prezzo);
}

function validateFormModifica(){
    var nome = $('#nomeId').val();
    var prezzo = $('#prezzoId').val();
    var descrizione = $('#descrizioneId').val();
    return regex(nome,descrizione,prezzo);
}

function regex(nome,descrizione,prezzo){
    const regexNome = new RegExp("^[A-Za-z0-9._%+-]{2,30}$");
    const regexDescr = new RegExp("^[A-Za-z0-9._%+-]{0,255}$");
    if(!regexNome.test(nome)){
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci un nome valido!',
        })
        return false;
    }

    if(!regexDescr.test(descrizione)){
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci una descrizione valida!',
        })
        return false;
    }

    if(prezzo <= 0){
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci il prezzo!',
        })
        return false;
    }
    return true;
}