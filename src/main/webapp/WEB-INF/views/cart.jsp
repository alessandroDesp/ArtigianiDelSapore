<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 15/03/2022
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carrello</title>
</head>
<body>

<section id="product-list">
    <div class="container">
        <ul class="cards">
            <% for (  : ) {%>
            <jsp:include page="/WEB-INF/views/partials/cardProdotti.jsp">
                <jsp:param name="id" value="<%=ct.getIdProdotti()%>"/>
                <jsp:param name="nome" value="<%=ct.getNome()%>"/>
                <jsp:param name="prezzo" value="<%=ct.getPrezzo()%>"/>
                <jsp:param name="quantita_att" value="<%=ct.getQuantitaAttuale()%>"/>
                <jsp:param name="descrizione" value="<%=ct.getDescrizione()%>"/>
            </jsp:include>
            <%}%>
        </ul>
    </div>
</section>

</body>
</html>
