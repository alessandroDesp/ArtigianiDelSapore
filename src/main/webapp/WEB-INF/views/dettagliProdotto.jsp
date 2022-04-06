<%@ page import="model.prodotti.Prodotti" %><%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 24/03/2022
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="DettagliProdotto"/>
    </jsp:include>
    <link rel="stylesheet" href="css/dettagliProdotto.css">
    <link rel="stylesheet" href="css/tooltipStyle.css">
    <script src="script/cardProdotti.js"></script>
</head>
<body>
<%
    Prodotti prodotto=(Prodotti) request.getAttribute("prodotto");
%>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<section>
    <section>
        <div class="title__dettagliProdotto">
          <h1 class="">Dettagli prodotto</h1>
        </div>
    </section>
    <section class="vhPage">
        <div class="card__dettagliProdotto">
            <div class="container__image">
                 <img src="covers/<%=prodotto.getFotoPath()%>" class="image__prodotto" alt="" />
            </div>
            <div class="descrizione__dettagliProdotto">
                <div>
                    <label for="nome">Nome</label>
                    <p id="nome"><%=prodotto.getNome()%></p>
                </div>
                <div>
                    <label for="prezzo">Prezzo</label>
                    <%if (prodotto.getSconto()>0){%>
                        <p id="prezzo"><%=Math.round((prodotto.getPrezzo() - (prodotto.getPrezzo()*prodotto.getSconto()/100))*100.0)/100.0%></p>
                    <%}else{%>
                        <p id="prezzo"><%=prodotto.getPrezzo()%></p>
                    <%}%>
                </div>
                <div class="descr">
                    <label for="descrizione">Descrizione</label>
                    <p id="descrizione"><%=prodotto.getDescrizione()%></p>
                </div>
                <div>
                    <label for="quantita">Quantita disponibile</label>
                    <p id="quantita"><%=prodotto.getQuantitaAttuale()%></p>
                </div>
                <%if(u!=null){%>
                <div>
                    <label for="quantitaDaAcquistare${param.id}">Quantita</label>
                    <input type="number" min="1" value="1" onchange="if(!(this.value>1)){this.value = 1}else{this.value = parseInt(this.value);}" id="quantitaDaAcquistare${param.id}">
                    <button onclick="aggiungiCarrello(<%=prodotto.getIdProdotti()%>)">Aggiungi al carrello</button>
                </div>
                <div class="icon__dettagliProdotto">
                    <a class="fa-solid fa-star tooltip" onClick="aggiungiPreferiti(${param.id})">
                        <span class="tooltip-text-prodotti">Aggiungi ai preferiti</span>
                    </a>
                </div>
                <%}%>
            </div>
        </div>

    </section>
</section>


<%@ include file="/WEB-INF/views/partials/footer.jsp" %>

</body>
</html>
