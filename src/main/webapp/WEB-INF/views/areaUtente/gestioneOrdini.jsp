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
    <script src="script/gestioneOrdini.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<%@ include file="/WEB-INF/views/partials/areaUtenteBar.jsp" %>
<%
    List<Ordini> ordini = (List<Ordini>) request.getAttribute("listaOrdini");
    int tipoChiamata = (Integer) request.getAttribute("Tipo");
%>
<section>
    <div class="vhPage">
        <%if(ordini.isEmpty()) {%>
        <div class="empty-datatable">
            <p class="is-empty">Lista ordini vuota, effettua un ordine per poterlo visualizzare in questa sezione</p>
        </div>
        <%}else{%>
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
            <%for(Ordini o :ordini){%>
            <tr>
                <td data-head="Data"><%=Utilita.convertDateToView(o.getData())%></td>
                <td data-head="Prezzo totale"><%=o.getPrezzoTotale()%></td>
                <td data-head="Stato"><%=Utilita.getStatoString(o.getKsStatoOrdini())%></td>
                <td data-head="Azione">
                    <a class="fa-solid fa-circle-info tooltip" href="DettagliOrdine?id=<%=o.getIdOrdini()%>">
                        <span class="tooltip-text">Dettagli ordine</span>
                    </a>
                    <%if(u.getKsRuolo()==3){
                        switch(o.getKsStatoOrdini()){
                        case 1:%>
                        <a class="fas fa-wallet tooltip" href="Pagamento?id=<%=o.getIdOrdini()%>">
                            <span class="tooltip-text">Paga</span>
                        </a>
                        <%break;
                        case 2:%>
                        <i class="fa-solid fa-circle confermata tooltip">
                            <span class="tooltip-text">Confermato</span>
                        </i>
                        <%break;
                         case 3:%>
                        <i class="fa-solid fa-circle consegnata tooltip">
                            <span class="tooltip-text">Consegnato</span>
                        </i>
                        <%break;
                        }
                    } else{
                     switch(o.getKsStatoOrdini()){
                        case 1:%>
                        <i class="fa-solid fa-circle daPagare tooltip">
                            <span class="tooltip-text">Da pagare</span>
                        </i>
                        <%break;
                        case 2:%>
                            <a class="fa-solid fa-circle-check tooltip" onclick="consegnaOrdine(<%=o.getIdOrdini()%>)">
                            <span class="tooltip-text">Consegna</span>
                            </a>
                        <%break;
                         case 3:%>
                        <i class="fa-solid fa-circle consegnata tooltip">
                            <span class="tooltip-text">Consegnato</span>
                        </i>
                        <%break;
                        }
                    }%>


                </td>
                <%}%>
            </tr>
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
        <%}%>
    </div>
</section>
<%@ include file="/WEB-INF/views/partials/footer.jsp" %>

</body>
</html>