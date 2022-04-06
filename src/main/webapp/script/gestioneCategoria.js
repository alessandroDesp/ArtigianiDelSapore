function iconModificaCategoria(id,nome){
    $("#idCategoriaModifica").val(id);
    $("#nomeIdModifica").val(nome);
}

function validateFormCreazione(){
    var nome = $('#nomeIdCreazione').val();
    return regex(nome);
}

function validateFormModifica(){
    var nome = $('#nomeIdModifica').val();
    return regex(nome);
}

function regex(nome){
    const regexNome = new RegExp("^[A-Za-z0-9._%+-]{2,30}$");
    if(!regexNome.test(nome)) {
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Inserisci un nome valido!',
        })
        return false;
    }
    return true;
}