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

function aggiungiCarrello(){
    console.log("add cart");

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