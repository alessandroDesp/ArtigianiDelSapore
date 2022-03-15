<%@ page import="model.ordini.Ordini" %>
<%@ page import="java.util.List" %>
<%@ page import="utility.Utilita" %><%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 05/03/2022
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Gestione ordini"/>
    </jsp:include>
    <link rel="stylesheet" href="css/gestioneOrdini.css">
    <link rel="stylesheet" href="css/dataTable.css">
    <link rel="stylesheet" href="css/tooltipStyle.css">
</head>
<body>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<%@ include file="/WEB-INF/views/partials/areaUtenteBar.jsp" %>
<%
    List<Ordini> ordini = (List<Ordini>) request.getAttribute("listaOrdini");
    int tipoChiamata = (Integer) request.getAttribute("Tipo");
%>
<section class="vh30">
    <table id="dataTable" class="display" style="width:100%">
        <thead>
        <tr>
            <th>Data</th>
            <th>Prezzo totale</th>
            <th>Stato</th>
            <th>Azione</th>
        </tr>
        </thead>
        <tbody>
        <%if(ordini.isEmpty()){%>
        <tr>
            <td>Nessun valore</td>
            <td>""</td>
            <td>""</td>
            <td>""</td>

        </tr>
        <%}else{%>
            <%for(Ordini o :ordini){%>
            <tr>
                <td><%=o.getData()%></td>
                <td><%=o.getPrezzoTotale()%></td>
                <td><%=Utilita.getStatoString(o.getKsStatoOrdini())%></td>
                <td><% switch(o.getKsStatoOrdini()){
                        case 1:%>
                        <a class="fas fa-wallet tooltip" href="Pagamento?id=<%=o.getIdOrdini()%>">
                            <span class="tooltip-text">Paga</span>
                        <%break;
                        case 2:%>
                        <i class="far fa-circle confermata tooltip">
                            <span class="tooltip-text">Confermata</span>
                        <%break;
                         case 3:%>
                        <i class="far fa-circle consegnata tooltip">
                            <span class="tooltip-text">Consegnata</span>
                        <%break;
                } %>


                </td>
            </tr>
           <%}
           }%>

        </tbody>
        <tfoot>
        <tr>
            <th>Data</th>
            <th>Prezzo totale</th>
            <th>Stato</th>
            <th>Azione</th>
        </tr>
        </tfoot>
    </table>

</section>

</body>
</html>