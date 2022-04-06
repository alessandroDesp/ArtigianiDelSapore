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
<section class="registrazione-section ">
    <div class="vhPage">
        <div class="div-container">
            <div class="form-registrazione">
                <div class="column-registrazione">
                    <div class="container-input">
                        <div>
                            <label for="nomeId">Nome</label>
                        </div>
                        <div>
                            <input id="nomeId" type="text">
                        </div>
                    </div>
                    <div class="container-input">
                        <div>
                            <label for="cognomeId">Cognome</label>
                        </div>
                        <div>
                            <input id="cognomeId" type="text">
                        </div>
                    </div>
                </div>
                <div class="column-registrazione">
                    <div class="container-input">
                        <div>
                            <label for="codiceFiscaleId">Codice fiscale</label>
                        </div>
                        <div>
                            <input id="codiceFiscaleId" type="text">
                        </div>
                    </div>
                    <div class="container-input">
                        <div>
                            <label for="dataNascitaId">Data di nascita</label>
                        </div>
                        <div>
                            <input id="dataNascitaId" type="date" required>
                        </div>
                    </div>
                </div>
                <div class="column-registrazione">
                    <div class="container-input">
                        <div>
                            <label for="indirizzoEmailId">Indirizzo email</label>
                        </div>
                        <div>
                            <input id="indirizzoEmailId" type="text">
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
                </div>
                <div class="button-registrati">
                    <div>
                        <button onclick="registrati()">Registrati</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
</html>
