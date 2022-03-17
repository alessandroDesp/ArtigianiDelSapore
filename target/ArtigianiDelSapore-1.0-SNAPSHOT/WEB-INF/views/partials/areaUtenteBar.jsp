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

        <a href="Anagrafica">Anagrafica</a>
        <a href="ListaDesideri">Lista desideri</a>
        <%if(ute.getKsRuolo()==1){%>
             <a href="GestioneUtenti">Gestione utenti</a>
        <%}%>
        <%if(ute.getKsRuolo()==1||ute.getKsRuolo()==2){%>
            <a href="GestioneOrdini">Gestione ordini</a>
            <a href="GestioneProdotti">Gestione prodotti</a>
            <a href="GestioneCategorie">Gestione categorie</a>
        <%}%>
    </div>
</nav>