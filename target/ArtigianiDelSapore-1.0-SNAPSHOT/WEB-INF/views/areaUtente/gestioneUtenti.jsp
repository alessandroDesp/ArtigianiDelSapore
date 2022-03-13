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
    <link rel="stylesheet" href="css/gestioneUtenti.css">
    <link rel="stylesheet" href="css/dataTable.css">
</head>
<body>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<%@ include file="/WEB-INF/views/partials/areaUtenteBar.jsp" %>
<%
    List<Utente> utente = (List<Utente>) request.getAttribute("listaUtente");
    int tipoChiamata = (Integer) request.getAttribute("Tipo");
%>
<section class="vh30">
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
            <td><%=ut.getNome()%></td>
            <td><%=ut.getCognome()%></td>
            <td><%=ut.getCf()%></td>
            <td><%=Utilita.convertDateToView(ut.getDataNascita())%></td>
            <td><%=ut.getEmail()%></td>
            <td><%=Utilita.getRuoloString(ut.getKsRuolo())%></td>
            <td>bla</td>

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

</section>

</body>
</html>