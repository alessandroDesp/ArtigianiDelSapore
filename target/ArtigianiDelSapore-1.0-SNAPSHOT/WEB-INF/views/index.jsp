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

<main>

</main>
<%--
<section class="prodotti">
    <% for (int i=0;i<6;i++) { %>
      <%@ include file="/WEB-INF/views/partials/cardProdotti.jsp" %>
    <%}%>
</section>
--%>

<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
</html>