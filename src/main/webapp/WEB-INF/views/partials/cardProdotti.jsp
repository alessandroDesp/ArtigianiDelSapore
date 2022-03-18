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
        <img src="images/img1.jpg" class="card__image" alt="" />
        <div class="card__overlay">
            <div class="card__header">
                <div class="card__header-text">
                    <h3 class="card__title">${param.nome}</h3>
                </div>
                <%
                Float sconto = Float.parseFloat(request.getParameter("sconto"));
                Float prezzo = Float.parseFloat(request.getParameter("prezzo"));
                if (sconto>0){%>
                  <h3 id="sconto" class="card__sconto">Sconto del ${param.sconto}%</h3>
                <%}%>
            </div>
            <div class="card__description">
                <%if (sconto>0){%>
                     <p><text style="text-decoration: line-through;">Prezzo :${param.prezzo}</text> Prezzo :<%=Math.round((prezzo - (prezzo*sconto/100))*100.0)/100.0%></p>

                <%}else{%>
                    <p>Prezzo :${param.prezzo}</p>
                <%}%>
                <p>Quantita' disponibile:${param.quantita_att}</p>
                <p><label for="quantitaDaAcquistare${param.id}">Quantita:</label><input type="number" min="1" value="1" onchange="if(!(this.value>1)){this.value = 1}else{this.value = parseInt(this.value);}" id="quantitaDaAcquistare${param.id}"></p>
<%--                <a type="button" href="DettagliProdotti?id=${param.id}">Dettagli</a>--%>
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" width="1.5rem">
                    <a href="DettagliProdotti?id=${param.id}">
                        <!--! Font Awesome Pro 6.0.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. -->
                        <path d="M256 0C114.6 0 0 114.6 0 256s114.6 256 256 256s256-114.6 256-256S397.4 0 256 0zM256 128c17.67 0 32 14.33 32 32c0 17.67-14.33 32-32 32S224 177.7 224 160C224 142.3 238.3 128 256 128zM296 384h-80C202.8 384 192 373.3 192 360s10.75-24 24-24h16v-64H224c-13.25 0-24-10.75-24-24S210.8 224 224 224h32c13.25 0 24 10.75 24 24v88h16c13.25 0 24 10.75 24 24S309.3 384 296 384z"></path>
                    </a>
                </svg>
<%--                <button onclick="aggiungiCarrello(${param.id})">Aggiungi al carrello</button>--%>
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="1.5rem" style="cursor: pointer;">
                    <!--! Font Awesome Pro 6.0.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. -->
                    <path onClick="aggiungiCarrello(${param.id})" d="M96 0C107.5 0 117.4 8.19 119.6 19.51L121.1 32H541.8C562.1 32 578.3 52.25 572.6 72.66L518.6 264.7C514.7 278.5 502.1 288 487.8 288H170.7L179.9 336H488C501.3 336 512 346.7 512 360C512 373.3 501.3 384 488 384H159.1C148.5 384 138.6 375.8 136.4 364.5L76.14 48H24C10.75 48 0 37.25 0 24C0 10.75 10.75 0 24 0H96zM272 180H316V224C316 235 324.1 244 336 244C347 244 356 235 356 224V180H400C411 180 420 171 420 160C420 148.1 411 140 400 140H356V96C356 84.95 347 76 336 76C324.1 76 316 84.95 316 96V140H272C260.1 140 252 148.1 252 160C252 171 260.1 180 272 180zM128 464C128 437.5 149.5 416 176 416C202.5 416 224 437.5 224 464C224 490.5 202.5 512 176 512C149.5 512 128 490.5 128 464zM512 464C512 490.5 490.5 512 464 512C437.5 512 416 490.5 416 464C416 437.5 437.5 416 464 416C490.5 416 512 437.5 512 464z"></path>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="1.5rem" style="cursor: pointer;">
                    <!--! Font Awesome Pro 6.0.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. -->
                    <path onClick="aggiungiPreferiti(${param.id})" d="M381.2 150.3L524.9 171.5C536.8 173.2 546.8 181.6 550.6 193.1C554.4 204.7 551.3 217.3 542.7 225.9L438.5 328.1L463.1 474.7C465.1 486.7 460.2 498.9 450.2 506C440.3 513.1 427.2 514 416.5 508.3L288.1 439.8L159.8 508.3C149 514 135.9 513.1 126 506C116.1 498.9 111.1 486.7 113.2 474.7L137.8 328.1L33.58 225.9C24.97 217.3 21.91 204.7 25.69 193.1C29.46 181.6 39.43 173.2 51.42 171.5L195 150.3L259.4 17.97C264.7 6.954 275.9-.0391 288.1-.0391C300.4-.0391 311.6 6.954 316.9 17.97L381.2 150.3z"></path>
                </svg>
<%--                <button onclick="">Aggiungi ai preferiti</button>--%>
            </div>
        </div>
    </div>
</li>
