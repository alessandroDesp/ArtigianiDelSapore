<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 05/03/2022
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Anagrafica"/>
    </jsp:include>
    <link rel="stylesheet" href="css/anagrafica.css">
    <script src="script/anagrafica.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<%@ include file="/WEB-INF/views/partials/areaUtenteBar.jsp" %>
<%
    Utente ut = (Utente)request.getAttribute("utente");
    int tipoChiamata = (Integer) request.getAttribute("Tipo");
%>

<section>
    <div class="div-container vhPage">
        <h1>Anagrafica</h1>
        <div class="form">
            <div class="column">
                <div class="container-input">
                    <div>
                        <label>Nome</label>
                    </div>
                    <div>
                        <input id="nomeId" type="text" value="<%=ut.getNome()%>">
                    </div>
                </div>
                <div class="container-input">
                    <div>
                        <label>Cognome</label>
                    </div>
                    <div>
                        <input id="cognomeId" type="text" value="<%=ut.getCognome()%>">
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="container-input">
                    <div>
                        <label>Codice fiscale</label>
                    </div>
                    <div>
                        <input id="codiceFiscaleId" type="text" value="<%=ut.getCf()%>">
                    </div>
                </div>
                <div class="container-input">
                    <div>
                        <label>Data di nascita</label>
                    </div>
                    <div>
                        <input id="dataNascitaId" type="date" value="<%=ut.getDataNascita()%>">
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="container-input">
                    <div>
                        <label>Indirizzo email</label>
                    </div>
                    <div>
                        <input id="indirizzoEmailId" type="text" value="<%=ut.getEmail()%>">
                    </div>
                </div>
                <div class="button-modifica">
                    <div>
                        <input id="tokenAuth" type="hidden" value="<%=ut.getTokenAuth()%>">
                        <input id="idUtente" type="hidden" value="<%=ut.getIdUtente()%>">
                        <button onclick="modificaAnagrafica()">Modifica</button>
                    </div>
                </div>
            </div>

        </div>
        <h1 class="modifica-password">Modifica password</h1>
        <div class="form">
            <div class="column">
                <div class="container-input">
                    <div>
                        <label>Nuova password</label>
                    </div>
                    <div>
                        <input id="nuovaPasswordId" type="password">
                    </div>
                </div>
                <div class="container-input">
                    <div>
                        <label>Ripeti password</label>
                    </div>
                    <div>
                        <input id="ripetiPasswordId" type="password">
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="container-input">
                    <div>
                        <label>Vecchia password</label>
                    </div>
                    <div>
                        <input id="vecchiaPasswordId" type="password">
                    </div>
                </div>
                <div class="button-modifica">
                    <div>
                        <button onclick="modificaPassword()">Modifica</button>
                    </div>
                </div>
            </div>

        </div>
    </div>

</section>
<%@ include file="/WEB-INF/views/partials/footer.jsp" %>

</body>
</html>