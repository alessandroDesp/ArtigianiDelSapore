function rimuoviProdotto(idProdotto){

    var data = {
        textIdProdotto : idProdotto
    };
    $.ajax({
        url: 'RimuoviDaListaDesideri',
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