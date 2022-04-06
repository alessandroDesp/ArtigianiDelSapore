<%@ page import="model.prodotti.Prodotti" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 15/03/2022
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Carrello"/>
    </jsp:include>
    <link rel="stylesheet" href="css/cart.css">
    <script src="script/cardProdotti.js"></script>
    <script src="script/cardCarrello.js"></script>
    <link rel="stylesheet" href="css/cardCarrello.css">
</head>
<body>
<%
    List<Prodotti> prodotti=(List<Prodotti>) request.getAttribute("listaProdotti");
    float costoTotale = 0;
    int i = 0;
%>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<section>
    <div class="vhPage">
        <%if(prodotti.isEmpty()) {%>

            <div class="empty-datatable">
                <p class="is-empty">Carrello vuoto, aggiungi un prodotto al carrello per poterlo visualizzare in questa sezione</p>
            </div>
        <%}else{%>
        <div class="title-Prodotti">
            <h1 class="">Carrello</h1>
        </div>
        <div id="product-list">
            <div class="container">
                <ul class="cards">
                    <% for (Prodotti pd : prodotti) {
                        i +=1;
                        if(pd.getSconto()>0){
                            costoTotale += (Math.round((pd.getPrezzo() - (pd.getPrezzo()*pd.getSconto()/100))*100.0)/100.0) * pd.getQuantitaDaAcquistare();
                        }else {
                            costoTotale += pd.getPrezzo() * pd.getQuantitaDaAcquistare();
                        }
                    %>
                    <jsp:include page="/WEB-INF/views/partials/cardCarrello.jsp">
                        <jsp:param name="id" value="<%=pd.getIdProdotti()%>"/>
                        <jsp:param name="nome" value="<%=pd.getNome()%>"/>
                        <jsp:param name="prezzo" value="<%=pd.getPrezzo()%>"/>
                        <jsp:param name="sconto" value="<%=pd.getSconto()%>"/>
                        <jsp:param name="quantita_att" value="<%=pd.getQuantitaAttuale()%>"/>
                        <jsp:param name="descrizione" value="<%=pd.getDescrizione()%>"/>
                        <jsp:param name="quantitaDaAcquistare" value="<%=pd.getQuantitaDaAcquistare()%>"/>
                        <jsp:param name="fotoPath" value="<%=pd.getFotoPath()%>"/>
                    </jsp:include>
                    <%}%>
                </ul>
            </div>
        </div>
        <div id="ordine-list">
            <div class="container-list">
                <div class="card-list">
                     <p>Totale provvisorio (<%=i%> Articoli)</p>
                     <span  id="costoTotaleId"><%=(Math.round((costoTotale)*100.0)/100.0)%></span>€
                     <button class="pagamento-button" onclick="procediAlPagamento(<%=i%>)">Conferma ordine</button>
                </div>
            </div>
        </div>
        <%}%>
    </div>
</section>
<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
</html>
