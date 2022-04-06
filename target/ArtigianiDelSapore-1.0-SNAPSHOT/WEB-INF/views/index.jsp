<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Home"/>
    </jsp:include>
    <script src="script/home.js"></script>
    <link rel="stylesheet" href="css/home.css">
</head>
<body>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>

<section>
    <div class="vhPage">
        <div>
          <img class="image-home" src="images/img-spezie.jpg">
        </div>
        <div class="content-grid">
            <div class="text-align-center border-right padding_2">
                <h2>
                    I nostri prodotti
                </h2>
                <h3 class="fw-unset">
                    I nostri dipendenti lavorano accuratamente per garantire la freschezza e la qualità dei nostri prodotti,
                    potrai trovare ogni tipo di prodotto che fa al caso tuo!
                </h3>
            </div>
            <div class="text-align-center border-right padding_2">
                <h2>
                    Dove siamo
                </h2>
                <h3 class="fw-unset">
                    Abbiamo il nostro negozio in Salerno, Campania. Non puoi raggiungerci? Non temere, il nostro servizio
                    di spedizione ricopre tutta l'Italia, che aspetti!
                </h3>
            </div>
            <div class="text-align-center padding_2">
                <h2>
                    Le nostre offerte
                </h2>
                <h3 class="fw-unset">
                    Ogni giorno offerte esclusive! Potrai visualizzare nella sezione offerte dei prodotti con prezzi incredibili!

                </h3>
            </div>
        </div>
    </div>
</section>

<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
</html>