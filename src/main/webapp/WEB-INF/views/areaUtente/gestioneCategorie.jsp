<%@ page import="model.categoria.Categoria" %>
<%@ page import="java.util.List" %>
<%@ page import="model.categoria.CategoriaDao" %><%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 05/03/2022
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Gestione categorie"/>
    </jsp:include>
    <link rel="stylesheet" href="css/gestioneCategorie.css">
    <link rel="stylesheet" href="css/dataTable.css">
</head>
<body>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<%@ include file="/WEB-INF/views/partials/areaUtenteBar.jsp" %>
<%
    List<Categoria> categoria = (List<Categoria>) request.getAttribute("listaCategoria");
    int tipoChiamata = (Integer) request.getAttribute("Tipo");
%>
<section>
    <div class="vhPage">
        <table id="dataTable" class="display" style="width:100%">
            <thead>
            <tr>
                <th>Nome</th>
                <th>Azione</th>
            </tr>
            </thead>
            <tbody>
            <%for(Categoria c: categoria){%>
            <tr>
                <td data-head="Nome"><%=c.getNome()%></td>
                <td data-head="Azione">bla</td>

            </tr>
            <%}%>


            </tbody>
            <tfoot>
            <tr>
                <th>Nome</th>
                <th>Azione</th>
            </tr>
            </tfoot>
        </table>
    </div>
</section>
<%@ include file="/WEB-INF/views/partials/footer.jsp" %>

</body>
</html>