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
<section class="slider">
    <div>
        <img src="images/img2.jpg">
    </div>
</section>
<%--
<section class="prodotti">
    <% for (int i=0;i<6;i++) { %>
      <%@ include file="/WEB-INF/views/partials/cardProdotti.jsp" %>
    <%}%>
</section>
--%>
</body>
</html>