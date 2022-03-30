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
                Swal.fire({
                    icon: 'success',
                    title: result.Mess,
                }).then(function () {
                    location.reload();
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