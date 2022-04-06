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
    <link rel="stylesheet" href="css/tooltipStyle.css">
    <link rel="stylesheet" href="css/modal.css">
    <script src="script/modal.js"></script>
    <script src="script/gestioneCategoria.js"></script>
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
        <%if(u.getKsRuolo()==1){%>
        <button class="creazione-button myBtnCreazione">Crea nuova categoria</button>
        <%}%>
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
                <td data-head="Azione">
                    <%if(u.getKsRuolo()==1){%>
                    <a class="fas fa-edit tooltip myBtn" onclick='iconModificaCategoria(<%=c.getId()%>,"<%=c.getNome()%>")'>
                        <span class="tooltip-text">Modifica categoria</span>
                    </a>
                    <%}%>
                </td>

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
<!-- creazione categoria -->
<div id="myModalCreazione" class="modal">

    <div class="modal-content">
        <div class="modal-header">
            <span class="cl closeCreazione">&times;</span>
            <h2>Crea categoria</h2>
        </div>
        <div class="modal-body">
            <div class="div-container">
                <form action="CreazioneCategoria" method="post" class="form-tag">
                    <div class="container-input">
                        <div>
                            <label for="nomeIdCreazione">Nome</label>
                        </div>
                        <div>
                            <input name="nome" id="nomeIdCreazione" type="text">
                        </div>
                    </div>
                    <button type="submit" name="sub">Crea categoria</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Modal modifica categoria -->
<div id="myModal" class="modal">

    <div class="modal-content">
        <div class="modal-header">
            <span class="cl close">&times;</span>
            <h2>Modifica categoria</h2>
        </div>
        <div class="modal-body">
            <div class="div-container">
                <form action="ModificaCategoria" method="post" class="form-tag">
                    <div class="container-input">
                        <div>
                            <label for="nomeIdModifica">Nome</label>
                        </div>
                        <div>
                            <input name="nome" id="nomeIdModifica" type="text">
                        </div>
                    </div>
                    <input type="hidden" id="idCategoriaModifica" name="categoriaId">
                    <button type="submit" name="sub">Modifica categoria</button>
                </form>
            </div>
        </div>
    </div>
</div>