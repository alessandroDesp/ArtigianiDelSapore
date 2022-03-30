<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 24/03/2022
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Errore"/>
    </jsp:include>
</head>
<body>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<section class="vhPage">
    <div class="notification-page">
        <div class="notification-page-title">
            Ops si è verificato un errore!
        </div>
        <div class="notification-page-body">
            Se l'errore sussiste contattare l'assistenza
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
</html>
