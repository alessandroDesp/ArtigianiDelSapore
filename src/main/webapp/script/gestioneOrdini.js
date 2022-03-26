function consegnaOrdine(idOrdine){
    data = {
        idOrdine : idOrdine
    }
    $.ajax({
        url: 'ConsegnaOrdine',
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