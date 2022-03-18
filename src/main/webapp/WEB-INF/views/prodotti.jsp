<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 18/02/2022
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.prodotti.Prodotti" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Prodotti"/>
    </jsp:include>
    <link rel="stylesheet" href="css/prodotti.css">
    <script src="script/cardProdotti.js"></script>
    <link rel="stylesheet" href="css/cardProdotti.css">
</head>
<body>
<%
    List<Prodotti> prodotti=(List<Prodotti>) request.getAttribute("listaProdotti");
%>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<section class="title-Prodotti">
    <h1 class="">Prodotti</h1>
</section>

<section id="product-list">
    <div class="container">
        <ul class="cards">
            <% for (Prodotti pd : prodotti) {%>
               <jsp:include page="/WEB-INF/views/partials/cardProdotti.jsp">
                   <jsp:param name="id" value="<%=pd.getIdProdotti()%>"/>
                   <jsp:param name="nome" value="<%=pd.getNome()%>"/>
                   <jsp:param name="prezzo" value="<%=pd.getPrezzo()%>"/>
                   <jsp:param name="sconto" value="<%=pd.getSconto()%>"/>
                   <jsp:param name="quantita_att" value="<%=pd.getQuantitaAttuale()%>"/>
                   <jsp:param name="descrizione" value="<%=pd.getDescrizione()%>"/>
               </jsp:include>
            <%}%>
        </ul>
    </div>
</section>

<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
</html>
