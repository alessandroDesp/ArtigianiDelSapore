<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 05/03/2022
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%
    Utente ute = (Utente) session.getAttribute(utility.Utilita.SESSION_USER);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="css/areaUtenteBar.css">
<nav class="areaUtente-nav">
    <div class="areaUtente">
        <div class="displayWindow displayWindow__ruolo<%=ute.getKsRuolo()%>">
            <a href="Anagrafica">Anagrafica</a>
            <a href="ListaDesideri">Lista desideri</a>
            <%if(ute.getKsRuolo()==1){%>
                 <a href="GestioneUtenti">Gestione utenti</a>
            <%}%>
                <a href="GestioneOrdini">Gestione ordini</a>
            <%if(ute.getKsRuolo()==1||ute.getKsRuolo()==2){%>
                <a href="GestioneProdotti">Gestione prodotti</a>
                <a href="GestioneCategorie">Gestione categorie</a>
            <%}%>
        </div>
        <div class="displayMobile displayMobile__ruolo<%=ute.getKsRuolo()%>">

            <div class="nav-link px-2 link-dark dropdown no-decoration">
                <a href="#" class="nav-link d-block link-dark cursor_a"><i class="fa-solid fa-person-half-dress icon__areaUtente"></i></a>
                <ul class="dropdown-content text-small">
                    <li><a class="dropdown-item" href="Anagrafica">Anagrafica</a></li>
                    <li><a class="dropdown-item" href="ListaDesideri">Lista desideri</a></li>
                    <%if(ute.getKsRuolo()==1){%>
                    <li><a class="dropdown-item" href="GestioneUtenti">Gestione utenti</a></li>
                    <%}%>
                    <li><a class="dropdown-item" href="GestioneOrdini">Gestione ordini</a></li>
                    <%if(ute.getKsRuolo()==1||ute.getKsRuolo()==2){%>
                    <li><a class="dropdown-item" href="GestioneProdotti">Gestione prodotti</a></li>
                    <li><a class="dropdown-item" href="GestioneCategorie">Gestione categorie</a></li>
                    <%}%>
                </ul>
            </div>
        </div>
    </div>
</nav>