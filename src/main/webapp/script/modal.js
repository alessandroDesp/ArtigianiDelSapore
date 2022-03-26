$(document).ready(function(){

    var modalCreazione = document.getElementById("myModalCreazione");

    $('.myBtnCreazione').on('click', function () {
        modalCreazione.style.display = "block";
    });
    $('.closeCreazione').on('click', function () {
        modalCreazione.style.display = "none";
    });

    var modal = document.getElementById("myModal");

    $('.myBtn').on('click', function () {
        modal.style.display = "block";
    });
    $('.close').on('click', function () {
        modal.style.display = "none";
    });

    var modalAggiungiQuantita = document.getElementById("myModalAggiungiQuantita");

    $('.myBtnQuantitaProdotto').on('click', function () {
        modalAggiungiQuantita.style.display = "block";
    });
    $('.closeQuantitaProdotto').on('click', function () {
        modalAggiungiQuantita.style.display = "none";
    });

});