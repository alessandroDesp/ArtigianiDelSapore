<%@ page import="model.prodotti.Prodotti" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 05/03/2022
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Lista desideri"/>
    </jsp:include>
    <link rel="stylesheet" href="css/dataTable.css">
    <link rel="stylesheet" href="css/tooltipStyle.css">
    <script src="script/listaDesideri.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<%@ include file="/WEB-INF/views/partials/areaUtenteBar.jsp" %>
<%
    List<Prodotti> prodotti = (List<Prodotti>) request.getAttribute("listaProdotti");
    int tipoChiamata = (Integer) request.getAttribute("Tipo");
%>
<section>
    <div class="vhPage">
        <%if(prodotti.isEmpty()) {%>
        <div class="empty-datatable">
            <p class="is-empty">Lista desideri vuota, aggiungi un prodotto alla lista desideri per poterlo visualizzare</p>
        </div>
        <%}else{%>
        <table id="dataTable" class="display" style="width:100%">
            <thead>
            <tr>
                <th>Nome</th>
                <th>Descrizione</th>
                <th>Prezzo</th>
                <th>Sconto</th>
                <th>Quantità attuale</th>
                <th>Azione</th>
            </tr>
            </thead>
            <tbody>
            <%for(Prodotti p: prodotti){%>
            <tr>
                <td data-head="Nome"><%=p.getNome()%></td>
                <td data-head="Descrizione"><%=p.getDescrizione()%></td>
                <td data-head="Prezzo"><%=p.getPrezzo()%></td>
                <td data-head="Sconto"><%=p.getSconto()%></td>
                <td data-head="Quantita attuale"><%=p.getQuantitaAttuale()%></td>
                <td data-head="Azione">
                    <a class="far fa-file-alt tooltip" href="DettagliProdotto?id=<%=p.getIdProdotti()%>">
                        <span class="tooltip-text tooltip-font-size">Dettagli</span>
                    </a>
                    <a class="fas fa-trash-alt tooltip" onclick="rimuoviProdotto(<%=p.getIdProdotti()%>)">
                        <span class="tooltip-text">Rimuovi</span>
                    </a>
                </td>

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
                <th>Azione</th>
            </tr>
            </tfoot>
        </table>
        <%}%>
    </div>
</section>
<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
</html>