<%@ page import="java.util.List" %>
<%@ page import="model.prodotti.Prodotti" %>
<%@ page import="model.ordini.Ordini" %><%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 30/03/2022
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="DettagliOrdine"/>
    </jsp:include>
    <link rel="stylesheet" href="css/dettagliOrdine.css">
    <link rel="stylesheet" href="css/tooltipStyle.css">
    <link rel="stylesheet" href="css/dataTable.css">
</head>
<body>
<%
    Ordini ordine = (Ordini) request.getAttribute("ordine");
    List<Prodotti> prodottiList=(List<Prodotti>) request.getAttribute("listaProdotti");
%>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<section>
    <section>
        <div class="title__dettagliOrdine">
            <h1>Dettagli Ordine</h1>
            <h3> prezzo totale:<%=ordine.getPrezzoTotale()%></h3>
        </div>
    </section>
    <section>
        <div class="vhPage">
            <table id="dataTable" class="display" style="width:100%">
                <thead>
                <tr>
                    <th>Nome</th>
                    <th>Quantita acquistata</th>
                    <th>Prezzo articolo</th>
                </tr>
                </thead>
                <tbody>
                <%for(Prodotti p:prodottiList){%>
                <tr>
                    <td data-head="Nome"><%=p.getNome()%></td>
                    <td data-head="Quantita acquistata"><%=p.getQuantitaDaAcquistare()%></td>
                    <td data-head="Prezzo articolo"><%=Math.round((p.getPrezzo() - (p.getPrezzo()*p.getSconto()/100))*100.0)/100.0%></td>
                </tr>
                <%}%>

                </tbody>
                <tfoot>
                <tr>
                    <th>Nome</th>
                    <th>Quantita acquistata</th>
                    <th>Prezzo articolo</th>
                </tr>
                </tfoot>
            </table>
        </div>
    </section>
</section>


<%@ include file="/WEB-INF/views/partials/footer.jsp" %>

</body>
</html>