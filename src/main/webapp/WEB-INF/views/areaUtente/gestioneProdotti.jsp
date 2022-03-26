<%@ page import="model.prodotti.Prodotti" %>
<%@ page import="java.util.List" %>
<%@ page import="model.categoria.Categoria" %><%--
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
    <link rel="stylesheet" href="css/tooltipStyle.css">
    <link rel="stylesheet" href="css/modal.css">
    <script src="script/modal.js"></script>
    <script src="script/gestioneProdotti.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<%@ include file="/WEB-INF/views/partials/areaUtenteBar.jsp" %>
<%
    List<Prodotti> prodotti = (List<Prodotti>) request.getAttribute("listaProdotti");
    List<Categoria> categoria =(List<Categoria>) request.getAttribute("listaCategorie");
    int tipoChiamata = (Integer) request.getAttribute("Tipo");
%>
<section>
    <div class="vhPage">
        <%if(u.getKsRuolo()==1){%>
        <button class="creazione-button myBtnCreazione">Crea nuovo Prodotto</button>
        <%}%>
        <table id="dataTable" class="display" style="width:100%">
            <thead>
            <tr>
                <th>Nome</th>
                <th>Descrizione</th>
                <th>Prezzo</th>
                <th>Sconto</th>
                <th>Quantità attuale</th>
                <th>Quantità venduta</th>
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
                <td data-head="Quantita Attuale"><%=p.getQuantitaAttuale()%></td>
                <td data-head="Quantita Venduta"><%=p.getQuantitaVenduta()%></td>
                <td data-head="Azione">
                    <%if(u.getKsRuolo()==1){%>
                    <a class="fas fa-edit tooltip myBtn" onclick='iconModificaProdotti(<%=p.getIdProdotti()%>,"<%=p.getNome()%>",<%=p.getPrezzo()%>,<%=p.getSconto()%>,<%=p.getQuantitaAttuale()%>,<%=p.getQuantitaVenduta()%>,"<%=p.getDescrizione()%>")'>
                        <span class="tooltip-text">Modifica Prodotto</span>
                    </a>
                    <%}else if(u.getKsRuolo()==2){%>
                    <a class="fas fa-edit tooltip myBtnQuantitaProdotto" onclick='iconAggiungiQuantitaProdotto(<%=p.getIdProdotti()%>,"<%=p.getNome()%>",<%=p.getQuantitaAttuale()%>)'>
                        <span class="tooltip-text">Aggiungi quantita Prodotto</span>
                    </a>
                    <%}%>
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
                <th>Quantità venduta</th>
                <th>Azione</th>
            </tr>
            </tfoot>
        </table>
    </div>
</section>
<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
<!-- The Modal -->
    <!-- Modal creazione prodotto -->
<div id="myModalCreazione" class="modal">

    <div class="modal-content">
        <div class="modal-header">
            <span class="cl closeCreazione">&times;</span>
            <h2>Nuovo prodotto</h2>
        </div>
        <div class="modal-body">
            <div class="div-container">
                <form action="CreaProdotto" method="post" class="form-tag">
                    <div class="column-prodotto">
                        <div class="container-input">
                            <div>
                                <label>Nome</label>
                            </div>
                            <div>
                                <input name="nome" type="text">
                            </div>
                        </div>
                        <div class="container-input">
                            <div>
                                <label>Prezzo</label>
                            </div>
                            <div>
                                <input name="prezzo" type="number" min="0" value="0" step=".01">
                            </div>
                        </div>
                    </div>
                    <div class="column-prodotto">
                        <div class="container-input">
                            <div>
                                <label>Quantità attuale</label>
                            </div>
                            <div>
                                <input name="quantitaAttuale" type="number" min="0" value="0">
                            </div>
                        </div>
                        <div class="container-input">
                            <div>
                                <label>Sconto</label>
                            </div>
                            <div>
                                <input name="sconto" type="number" min="0" value="0" step=".01">
                            </div>
                        </div>
                    </div>
                    <div class="column-prodotto">
                        <div class="container-input">
                            <div>
                                <label>Categoria</label>
                            </div>
                            <div>
                                <select id="categoriaId" name="categoria" onchange="addCategoria()">
                                    <option value="">--Scegli una categoria--</option>
                                    <%for(Categoria c:categoria){%>
                                    <option value="<%=c.getId()%>"><%=c.getNome()%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="container-input">
                            <div>
                                <label>Categorie aggiunte</label>
                            </div>
                            <div>
                                <input id="categorieAggiunte" name="categorieAggiunte" type="text" disabled>
                                <input id="categorieAggiunteId" name="categorieAggiunteId" type="hidden">
                            </div>
                        </div>
                    </div>
                    <div class="container-input">
                        <div>
                            <label>Descrizione</label>
                        </div>
                        <div>
                            <textarea name="descrizione"></textarea>
                        </div>
                    </div>
                    <button type="submit" name="sub">Crea</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Modal modifica prodotto -->
<div id="myModal" class="modal">

    <div class="modal-content">
        <div class="modal-header">
            <span class="cl close">&times;</span>
            <h2>Dettagli prodotto</h2>
        </div>
        <div class="modal-body">
            <div class="div-container">
                <form action="ModificaProdotto" method="post" class="form-tag">
                    <div class="column-prodotto">
                        <div class="container-input">
                            <div>
                                <label>Nome</label>
                            </div>
                            <div>
                                <input id="nomeId" name="nome" type="text">
                            </div>
                        </div>
                        <div class="container-input">
                            <div>
                                <label>Prezzo</label>
                            </div>
                            <div>
                                <input id="prezzoId" name="prezzo" type="number" min="0" step=".01">
                            </div>
                        </div>
                    </div>
                    <div class="column-prodotto">
                        <div class="container-input">
                            <div>
                                <label>Quantità attuale</label>
                            </div>
                            <div>
                                <input id="quantitaAttualeId" name="quantitaAttuale" type="number" min="0">
                            </div>
                        </div>
                        <div class="container-input">
                            <div>
                                <label>Quantità venduta</label>
                            </div>
                            <div>
                                <input id="quantitaVendutaId" name="quantitaVenduta" type="number" min="0" >
                            </div>
                        </div>
                    </div>

                    <div class="container-input">
                        <div>
                            <label>Sconto</label>
                        </div>
                        <div>
                            <input id="scontoId" name="sconto" type="number" min="0"  step=".01">
                        </div>
                    </div>

                    <div class="container-input">
                        <div>
                            <label>Descrizione</label>
                        </div>
                        <div>
                            <textarea id="descrizioneId" name="descrizione"></textarea>
                        </div>
                    </div>
                    <input type="hidden" id="idProdotto" name="prodottoId">
                    <button type="submit" name="sub">Modifica</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Modal aggiungi quantita -->
<div id="myModalAggiungiQuantita" class="modal">

    <div class="modal-content">
        <div class="modal-header">
            <span class="cl closeQuantitaProdotto">&times;</span>
            <h2>Aggiungi quantita prodotto</h2>
        </div>
        <div class="modal-body">
            <div class="div-container">
                <form action="AggiungiQuantitaProdotto" method="post" class="form-tag">
                    <div class="column-prodotto">
                        <div class="container-input">
                            <div>
                                <label>Nome</label>
                            </div>
                            <div>
                                <input id="nomeIdQuantita" type="text" disabled>
                            </div>
                        </div>
                        <div class="container-input">
                            <div>
                                <label>Quantità attuale</label>
                            </div>
                            <div>
                                <input id="quantitaAttualeIdQuantita" type="number" disabled>
                            </div>
                        </div>
                    </div>
                    <div class="column-prodotto-oneRow">

                        <div class="container-input">
                            <div>
                                <label>Aggiungi</label>
                            </div>
                            <div>
                                <input name="quantitaAggiunta" type="number" min="0" value="0">
                            </div>
                        </div>
                    </div>
                    <input type="hidden" id="idProdottoQuantita" name="prodottoId">
                    <button type="submit" name="sub">Aggiungi quantita</button>
                </form>
            </div>
        </div>
    </div>
</div>
</html>