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
        <jsp:param name="title" value="Registrazione"/>
    </jsp:include>
    <link rel="stylesheet" href="css/registrazione.css">
    <script src="script/registrazione.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<section class="vh100">
    <div class="div-container">
        <div class="form-registrazione">
            <div class="column-registrazione">
                <div class="container-input">
                    <div>
                        <label>Nome</label>
                    </div>
                    <div>
                        <input id="nomeId" type="text">
                    </div>
                </div>
                <div class="container-input">
                    <div>
                        <label>Cognome</label>
                    </div>
                    <div>
                        <input id="cognomeId" type="text">
                    </div>
                </div>
            </div>
            <div class="column-registrazione">
                <div class="container-input">
                    <div>
                        <label>Codice fiscale</label>
                    </div>
                    <div>
                        <input id="codiceFiscaleId" type="text">
                    </div>
                </div>
                <div class="container-input">
                    <div>
                        <label>Data di nascita</label>
                    </div>
                    <div>
                        <input id="dataNascitaId" type="date">
                    </div>
                </div>
            </div>
            <div class="column-registrazione">
                <div class="container-input">
                    <div>
                        <label>Indirizzo email</label>
                    </div>
                    <div>
                        <input id="indirizzoEmailId" type="text">
                    </div>
                </div>
                <div class="container-input">
                    <div>
                        <label>Password</label>
                    </div>
                    <div>
                        <input id="passwordId" type="password">
                    </div>
                </div>
            </div>
            <div class="button-registrati">
                <div>
                    <button onclick="registrati()">registrati</button>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
