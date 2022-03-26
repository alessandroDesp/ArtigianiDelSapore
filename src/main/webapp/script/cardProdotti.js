$(document).ready(function() {
    $('.cardClick').on('click', function () {
        if(!($(this).hasClass("cardAttiva"))){
            $(this).addClass('cardAttiva');
            $(this).find('input[type="checkbox"]').prop('checked', true);
        }else{
            $(this).removeClass('cardAttiva');
            $(this).find('input[type="checkbox"]').prop('checked', false);
        }
    });

} );

function aggiungiCarrello(idProdotto){
    var parola = "#quantitaDaAcquistare" + idProdotto;
    var quantita = $(parola).val();
    let quantitaCarrello;
    var data ={
        idProdotto : idProdotto,
        quantitaDaAcquistare : quantita
    }
    $.ajax({
        url: 'AggiungiAlCarrello',
        dataType: "json",
        type: "post",
        data: data,
        success: function (result) {
            if(result.Ris == 1) {
                quantitaCarrello = 1 * $("#iconCarrello").attr("value") + 1;
                $("#iconCarrello").attr("value",quantitaCarrello);
                alert(result.Mess)
            }else {
                alert(result.Mess)
            }
        }
    });

}

function aggiungiPreferiti(idProdotto){

    var data ={
        idProdotto : idProdotto
    }
    $.ajax({
        url: 'AggiungiPreferiti',
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