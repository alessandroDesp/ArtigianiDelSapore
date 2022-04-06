<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 17/02/2022
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,viewport-fit=cover">

<!-- Tag per la corretta visualizzazione su iOS -->
<meta name="format-detection" content="telephone-no"> <!-- Evita che le stringhe numeriche vengano interpretate
come numeri di telefono -->
<meta name="apple-mobile-web-app-capable" content="yes"> <!-- Abilita il salvataggio del sito come webapp -->
<meta name="apple-mobile-web-app-title" content="levelUp"> <!-- Nome del sito se salvato come webapp -->
<meta name="apple-mobile-web-app-status-bar-style" content="default"> <!-- Colore della barra di stato -->
<link rel="apple-touch-icon" href="images/iconFood.png"> <!-- Icona nella barra dei preferiti di iOS -->
<link rel="apple-touch-startup-image" href="images/favicon.png"> <!-- Icona schermata di caricamento -->
<!-- Tag per la corretta visualizzazione du Android -->
<meta name="theme-color" content="#000000"> <!-- Colore del sito -->
<link rel="shortcut icon" href="images/iconFood.png" type="image/x-icon">
<link rel="icon" href="images/iconFood.png" type="image/x-icon">
<link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet"/>
<!-- Contenuti di default -->
<meta charset="UTF-8">
<title> ${param.title} </title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Script -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/620c90930a.js" crossorigin="anonymous"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<script>
    toastr.options = {
    "closeButton": true,
    "debug": false,
    "newestOnTop": false,
    "progressBar": false,
    "positionClass": "toast-top-right",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "3000",
    "extendedTimeOut": "0",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
}</script>