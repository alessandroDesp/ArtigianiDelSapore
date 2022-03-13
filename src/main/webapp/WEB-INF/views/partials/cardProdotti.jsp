<%@ page import="model.utente.Utente" %><%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 17/02/2022
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%
    Utente ut = (Utente) session.getAttribute(utility.Utilita.SESSION_USER);
%>
<div class="card" id="containerCardId">

    <div class="card-body">
        <div class="cardClick">
            <h3 class="card-title">${param.nome}</h3>
            <input type="checkbox" id="checkVisibili" hidden>
            <div class="image-box">
                 <img id="imageId" class="card-image" src="images/img1.jpg" alt="...">
            </div>
            <div id="cardId" class="card-text">
                <ul>
                    <div><label>Prezzo:</label>${param.prezzo}</div>
                    <div><label>Quantita' disponibile:</label>${param.quantita_att}</div>
                    <div><label>Descrizione:</label>${param.descrizione}</div>
                </ul>
            </div>
        </div>
        <div class="card-button">
            <a href="DettagliProdotti?id=${param.id}"><button>Dettagli</button></a>
            <%if(!(ut==null)){%>
            <button onclick="aggiungiCarrello(${param.id})">Aggiungi al carrello</button>
            <button onclick="aggiungiPreferiti(${param.id})">Aggiungi ai preferiti</button>
            <%}%>
        </div>
    </div>
</div>
