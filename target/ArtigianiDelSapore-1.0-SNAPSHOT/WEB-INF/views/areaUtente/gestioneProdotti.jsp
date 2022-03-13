<%@ page import="model.prodotti.Prodotti" %>
<%@ page import="java.util.List" %><%--
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
        <jsp:param name="title" value="Gestione prodotti"/>
    </jsp:include>
    <link rel="stylesheet" href="css/gestioneProdotti.css">
    <link rel="stylesheet" href="css/dataTable.css">
</head>
<body>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<%@ include file="/WEB-INF/views/partials/areaUtenteBar.jsp" %>
<%
    List<Prodotti> prodotti = (List<Prodotti>) request.getAttribute("listaProdotti");
    int tipoChiamata = (Integer) request.getAttribute("Tipo");
%>
<section class="vh30">
    <table id="dataTable" class="display" style="width:100%">
        <thead>
        <tr>
            <th>Nome</th>
            <th>Descrizione</th>
            <th>Prezzo</th>
            <th>Sconto</th>
            <th>Quantità attuale</th>
            <th>Quantità venduta</th>
        </tr>
        </thead>
        <tbody>

        <%for(Prodotti p: prodotti){%>
        <tr>
            <td><%=p.getNome()%></td>
            <td><%=p.getDescrizione()%></td>
            <td><%=p.getPrezzo()%></td>
            <td><%=p.getSconto()%></td>
            <td><%=p.getQuantitaAttuale()%></td>
            <td><%=p.getQuantitaVenduta()%></td>
        </tr>
        <%}%>

        </tbody>
        <tfoot>
        <tr>
            <th>Nome</th>
            <th>Descrizione</th>
            <th>Prezzo</th>
            <th>Sconto</th>
            <th>Quantità attuale</th>
            <th>Quantità venduta</th>
        </tr>
        </tfoot>
    </table>

</section>

</body>
</html>