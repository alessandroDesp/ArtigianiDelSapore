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
    <link rel="stylesheet" href="css/prodotti.css">
    <script src="script/cardProdotti.js"></script>
    <link rel="stylesheet" href="css/cardCarrello.css">
</head>
<body>
<%
    List<Prodotti> prodotti=(List<Prodotti>) request.getAttribute("listaProdotti");
%>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<section class="title-Prodotti">
    <h1 class="">Carrello</h1>
</section>
<section id="product-list">
    <div class="container">
        <ul class="cards">
            <% for (Prodotti pd : prodotti) {%>
            <jsp:include page="/WEB-INF/views/partials/cardCarrello.jsp">
                <jsp:param name="id" value="<%=pd.getIdProdotti()%>"/>
                <jsp:param name="nome" value="<%=pd.getNome()%>"/>
                <jsp:param name="prezzo" value="<%=pd.getPrezzo()%>"/>
                <jsp:param name="sconto" value="<%=pd.getSconto()%>"/>
                <jsp:param name="quantita_att" value="<%=pd.getQuantitaAttuale()%>"/>
                <jsp:param name="descrizione" value="<%=pd.getDescrizione()%>"/>
                <jsp:param name="quantitaDaAcquistare" value="<%=pd.getQuantitaDaAcquistare()%>"/>
            </jsp:include>
            <%}%>
        </ul>
    </div>
</section>

</body>
</html>
