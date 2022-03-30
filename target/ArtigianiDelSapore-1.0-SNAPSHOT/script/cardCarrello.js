function changeQuantitaDaAcquistare(idProdotto){
    let parolaQuantitaDaAcquistare = "#quantitaDaAcquistare" + idProdotto;
    let quantitaDaAcquistare = $(parolaQuantitaDaAcquistare).val();
    if(!(quantitaDaAcquistare>1)){$(parolaQuantitaDaAcquistare).val(1)}else{$(parolaQuantitaDaAcquistare).val(parseInt(quantitaDaAcquistare))}
    quantitaDaAcquistare = $(parolaQuantitaDaAcquistare).val();
    let parolaQuantitaPrecedente = "#quantitaPrecedente" + idProdotto;
    let parolaPrezzo = "#prezzoId" + idProdotto;
    let costoTotale = document.getElementById('costoTotaleId').innerHTML;
    let quantitaPrecedente = $(parolaQuantitaPrecedente).val();
    let prezzo = $(parolaPrezzo).val();
    document.getElementById('costoTotaleId').innerHTML = Math.round((costoTotale - (quantitaPrecedente - quantitaDaAcquistare) * prezzo)*100)/100;
    $(parolaQuantitaPrecedente).val(quantitaDaAcquistare);
    data ={
        idProdotto : idProdotto,
        quantitaDaAcquistare : quantitaDaAcquistare
    }
    $.ajax({
        url: 'ModificaCarrello',
        dataType: "json",
        type: "post",
        data: data,
        success: function (result) {
            if(result.Ris == 1) {
                Swal.fire({
                    icon: 'success',
                    title: result.Mess,
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

function procediAlPagamento(numeroArticoli){
    if(numeroArticoli>0){
        location.href='Pagamento'
    }else{
        Swal.fire({
            icon: 'error',
            title: 'Errore',
            text: 'Nessun prodotto aggiunto al carrello',
        })
    }
}