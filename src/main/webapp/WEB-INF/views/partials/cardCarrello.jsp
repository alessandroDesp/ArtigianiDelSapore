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
            </div>
            <div class="card__description">

            </div>
        </div>
    </div>
</li>
