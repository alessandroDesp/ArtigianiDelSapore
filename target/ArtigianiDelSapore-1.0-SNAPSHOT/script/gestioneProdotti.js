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

function addCategoria(){
    var categorieAggiunte = $("#categorieAggiunte").val();
    var categorieDaAggiungere = $("#categoriaId option:selected").text();
    if(!categorieAggiunte.includes(categorieDaAggiungere) &&  !($("#categoriaId").val() == "")){
        $("#categorieAggiunte").val(categorieAggiunte + "[" + categorieDaAggiungere + "]");
        $("#categorieAggiunteId").val($("#categorieAggiunteId").val() + $("#categoriaId").val() + "-");
    }
}