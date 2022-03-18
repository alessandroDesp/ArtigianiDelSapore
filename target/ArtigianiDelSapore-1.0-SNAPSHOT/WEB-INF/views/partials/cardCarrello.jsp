<%@ page import="model.utente.Utente" %><%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 15/03/2022
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%
    Utente ut = (Utente) session.getAttribute(utility.Utilita.SESSION_USER);
%>

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
                <p><label for="quantitaDaAcquistare${param.id}">Quantita:</label><input type="number" min="1" value="${param.quantitaDaAcquistare}" onchange="if(!(this.value>1)){this.value = 1}else{this.value = parseInt(this.value);}" id="quantitaDaAcquistare${param.id}"></p>
            </div>

        </div>
    </div>
</li>
