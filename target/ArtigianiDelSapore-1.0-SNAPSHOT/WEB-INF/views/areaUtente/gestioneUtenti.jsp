<%@ page import="java.util.List" %>
<%@ page import="utility.Utilita" %><%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 05/03/2022
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Gestione utenti"/>
    </jsp:include>
    <link rel="stylesheet" href="css/dataTable.css">
    <link rel="stylesheet" href="css/tooltipStyle.css">
    <link rel="stylesheet" href="css/modal.css">
    <script src="script/modal.js"></script>
    <script src="script/gestioneUtenti.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<%@ include file="/WEB-INF/views/partials/areaUtenteBar.jsp" %>
<%
    List<Utente> utente = (List<Utente>) request.getAttribute("listaUtente");
    int tipoChiamata = (Integer) request.getAttribute("Tipo");
%>
<section>
    <div class="vhPage">
        <table id="dataTable" class="display" style="width:100%">
            <thead>
            <tr>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Codice fiscale</th>
                <th>Data di nascita</th>
                <th>Email</th>
                <th>Ruolo</th>
                <th>Azione</th>
            </tr>
            </thead>
            <tbody>
            <%for(Utente ut:utente){%>
            <tr>
                <td data-head="Nome"><%=ut.getNome()%></td>
                <td data-head="Cognome"><%=ut.getCognome()%></td>
                <td data-head="Codice fiscale"><%=ut.getCf()%></td>
                <td data-head="Data di nascita"><%=Utilita.convertDateToView(ut.getDataNascita())%></td>
                <td data-head="Email"><%=ut.getEmail()%></td>
                <td data-head="Ruolo"><%=Utilita.getRuoloString(ut.getKsRuolo())%></td>
                <td data-head="Azione">
                    <%if(u.getIdUtente()!=ut.getIdUtente()){%>
                    <a class="fas fa-edit tooltip myBtn" onclick="iconModificaPermessi(<%=ut.getIdUtente()%>,<%=ut.getKsRuolo()%>)">
                      <span class="tooltip-text">Modifica permessi</span>
                    </a>
                    <%}%>
                </td>

            </tr>
            <%}%>

            </tbody>
            <tfoot>
            <tr>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Codice fiscale</th>
                <th>Data di nascita</th>
                <th>Email</th>
                <th>Ruolo</th>
                <th>Azione</th>
            </tr>
            </tfoot>
        </table>
    </div>
</section>
<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
<!-- The Modal -->
<div id="myModal" class="modal">

    <div class="modal-content">
        <div class="modal-header">
            <span class="close cl">&times;</span>
            <h2>Modifica permessi</h2>
        </div>
        <div class="modal-body">
            <form action="ModificaPermessi" method="post" class="form-tag">
                <label for="selectPermessi">Permessi</label>
                <select class="form-control" name ="ruolo" id="selectPermessi">
                    <option value="1">Admin</option>
                    <option value="2">Assistente</option>
                    <option value="3">Utente</option>
                </select>
                <input type="hidden" name="idUtente" id="idUtenteInput" value="">
                <button type="submit" name="sub">Modifica permessi</button>
            </form>
        </div>
    </div>
</div>
</html>