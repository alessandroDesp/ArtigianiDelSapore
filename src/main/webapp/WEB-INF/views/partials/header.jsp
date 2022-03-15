<%@ page import="model.utente.Utente" %><%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 17/02/2022
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%
    Utente u = (Utente) session.getAttribute(utility.Utilita.SESSION_USER);
%>
<link rel="stylesheet" href="css/header.css">
<nav class="header-nav">
    <div class="header">
        <a href="./">Home</a>
        <span class="dropdown">
            <div>Mangiare</div>
            <div class="dropdown-content">
                <a href="Prodotti?categoria=Pasta">Pasta</a>
                <a href="Prodotti?categoria=Riso">Riso</a>
                <a href="Prodotti?categoria=Pesce">Pesce</a>
                <a href="Prodotti?categoria=Sughi">Sughi</a>
            </div>
        </span>
        <span class="dropdown">
            <div>Bere</div>
            <div class="dropdown-content">
                <a href="Prodotti?categoria=Vino">Vino</a>
                <a href="Prodotti?categoria=Acqua">Acqua</a>
                <a href="Prodotti?categoria=Succhi">Succhi</a>
            </div>
        </span>
        <span class="dropdown">
            <div>Ricette</div>
            <div class="dropdown-content">
                <a href="#">boh</a>
                <a href="#">Boh</a>
                <a href="#">bobo</a>
            </div>
        </span>
        <a href="#">Provenienza</a>
        <a href="#">Offerte</a>
        <form action="Search" method="post" style="display: contents;">
            <input type="text" placeholder="Cerca sul sito" name="sValue">
            <button type="submit" name="sub">Cerca</button>
        </form>
        <%if(u==null){%>
            <span class="container-button">
                <a class="autenticazione" href="Login"><button class="autenticazione-button">Login</button></a>
                <a class="autenticazione" href="Registrazione"><button class="autenticazione-button">Registrati</button></a>
            </span>
        <%}else{%>
            <span class="dropdown">
                <div><%=u.getNome()%></div>
                <div class="dropdown-content">
                    <a href="Anagrafica">Area utente</a>
                    <a href="Logout">Logout</a>
                </div>
            </span>
        <%}%>
    </div>
</nav>


