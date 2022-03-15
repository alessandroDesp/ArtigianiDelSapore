$(document).ready(function(){

    var modal = document.getElementById("myModal");

    $('.myBtn').on('click', function () {
        modal.style.display = "block";
    });
    $('.close').on('click', function () {
        modal.style.display = "none";
    });

});