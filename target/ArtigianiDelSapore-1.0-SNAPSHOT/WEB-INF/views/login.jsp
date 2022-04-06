<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 21/02/2022
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Login"/>
    </jsp:include>
    <link rel="stylesheet" href="css/login.css">
    <script src="script/login.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<section class="login-section">
    <div class="vhPage">
        <div class="div-container">
            <div class="form-login">
                <div class="container-input">
                    <div>
                        <label for="emailId">Email</label>
                    </div>
                    <div>
                        <input id="emailId" type="text">
                    </div>
                </div>
                <div class="container-input">
                    <div>
                        <label for="passwordId">Password</label>
                    </div>
                    <div>
                        <input id="passwordId" type="password">
                    </div>
                </div>
                <div class="container-input">
                    <div>
                        <label for="ricordamiId">Ricordami</label>
                        <input id="ricordamiId" type="checkbox">
                    </div>
                </div>
                <div class="button-accedi">
                    <div>
                        <button onclick="accedi()">Accedi</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
</html>