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
<%--<div class="card" id="containerCardId">--%>
<%--    <div class="card-body">--%>
<%--        <div class="cardClick">--%>
<%--            <h3 class="card-title">${param.nome}</h3>--%>
<%--            <input type="checkbox" id="checkVisibili" hidden>--%>
<%--            <div class="image-box">--%>
<%--                 <img id="imageId" class="card-image" src="images/img1.jpg" alt="...">--%>
<%--            </div>--%>
<%--            <div id="cardId" class="card-text">--%>
<%--                <ul>--%>
<%--                    <div><label>Prezzo:</label>${param.prezzo}</div>--%>
<%--                    <div><label>Quantita' disponibile:</label>${param.quantita_att}</div>--%>
<%--                    <div><label>Descrizione:</label>${param.descrizione}</div>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="card-button">--%>
<%--            <a href="DettagliProdotti?id=${param.id}"><button>Dettagli</button></a>--%>
<%--            <%if(!(ut==null)){%>--%>
<%--            <button onclick="aggiungiCarrello(${param.id})">Aggiungi al carrello</button>--%>
<%--            <button onclick="aggiungiPreferiti(${param.id})">Aggiungi ai preferiti</button>--%>
<%--            <%}%>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<li class="card">
    <div>
        <img src="covers/${param.fotoPath}" class="card__image" alt="" />
        <div class="card__overlay">
            <div class="card__header">
                <div class="card__header-text">
                    <h3 class="card__title">${param.nome}</h3>
                </div>
                <%
                Float sconto = Float.parseFloat(request.getParameter("sconto"));
                Float prezzo = Float.parseFloat(request.getParameter("prezzo"));
                if (sconto>0){%>
                  <h3 id="sconto" class="card__sconto sconto__color">Sconto del ${param.sconto}%</h3>
                <%}%>
            </div>
            <div class="card__description">
                <%if (sconto>0){%>
                     <p><text style="text-decoration: line-through;">Prezzo :${param.prezzo}</text> Prezzo :<%=Math.round((prezzo - (prezzo*sconto/100))*100.0)/100.0%></p>

                <%}else{%>
                    <p>Prezzo :${param.prezzo}</p>
                <%}%>
                <p>Quantita' disponibile:${param.quantita_att}</p>
                <%if(ut!=null){%>
                <div>
                    <label for="quantitaDaAcquistare${param.id}">Quantita:</label>
                    <input type="number" min="1" value="1" onchange="if(!(this.value>1)){this.value = 1}else{this.value = parseInt(this.value);}" id="quantitaDaAcquistare${param.id}">
                </div>
                <%}%>
                <a class="fa-solid fa-circle-info tooltip" href="DettagliProdotto?id=${param.id}">
                    <span class="tooltip-text-prodotti">Dettagli prodotti</span>
                </a>
                <%if(ut!=null){%>
                <a class="fa-solid fa-cart-plus tooltip" onClick="aggiungiCarrello(${param.id})">
                    <span class="tooltip-text-prodotti">Aggiungi al carrello</span>
                </a>
                <a class="fa-solid fa-star tooltip" onClick="aggiungiPreferiti(${param.id})">
                    <span class="tooltip-text-prodotti">Aggiungi ai preferiti</span>
                </a>
                <%}%>
            </div>
        </div>
    </div>
</li>
