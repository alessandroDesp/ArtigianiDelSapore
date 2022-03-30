<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 30/03/2022
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.prodotti.Prodotti" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="ProdottiSearch"/>
    </jsp:include>
    <link rel="stylesheet" href="css/prodotti.css">
    <script src="script/cardProdotti.js"></script>
    <link rel="stylesheet" href="css/cardProdotti.css">
    <link rel="stylesheet" href="css/tooltipStyle.css">
</head>
<body>
<%
    List<Prodotti> prodotti=(List<Prodotti>) request.getAttribute("listaProdotti");
    int numeroPagina = (Integer) request.getAttribute("numeroPagina");
    int numeroProdottiTotali = (Integer) request.getAttribute("numeroProdottiTotali");
    String nomeRicerca = (String) request.getAttribute("nomeRicerca");
%>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<section>
    <section class="title-Prodotti">
        <h1 class="">Prodotti</h1>
    </section>
    <div class="numero-pagina">
        <%if(numeroProdottiTotali>0){%>
               <%if(numeroPagina>1){%>
                <form action="Search" method="post" class="numero-pagina__div">
                    <input type="hidden" name="numeroPagina" value="<%=numeroPagina-1%>">
                    <input type="hidden" name="sValue" value="<%=nomeRicerca%>">
                    <button type="submit"><i class="fa-solid fa-arrow-left"></i></button>
                </form>
                <form action="Search" method="post" class="numero-pagina__div">
                    <input type="hidden" name="numeroPagina" value="1">
                    <input type="hidden" name="sValue" value="<%=nomeRicerca%>">
                    <button type="submit">1</button>
                </form>
            <%}%>
             <div class="numero-pagina__div"><button pagina-active><%=numeroPagina%></button></div>
            <%if(numeroPagina < (int)Math.floor(numeroProdottiTotali / 12)+1){%>
                <form action="Search" method="post" class="numero-pagina__div">
                    <input type="hidden" name="numeroPagina" value="<%=(int)Math.floor(numeroProdottiTotali / 12)+1%>">
                    <input type="hidden" name="sValue" value="<%=nomeRicerca%>">
                    <button type="submit"><%=(int)Math.floor(numeroProdottiTotali / 12)+1%></button>
                </form>
                <form action="Search" method="post" class="numero-pagina__div">
                    <input type="hidden" name="numeroPagina" value="<%=numeroPagina+1%>">
                    <input type="hidden" name="sValue" value="<%=nomeRicerca%>">
                    <button type="submit"><i class="fa-solid fa-arrow-right"></i></button>
                </form>
            <%}%>
        <%}%>
    </div>
    <section id="product-list" class="vhPage75">
        <div class="container">
            <ul class="cards">
                <% for (Prodotti pd : prodotti) {%>
                <jsp:include page="/WEB-INF/views/partials/cardProdotti.jsp">
                    <jsp:param name="id" value="<%=pd.getIdProdotti()%>"/>
                    <jsp:param name="nome" value="<%=pd.getNome()%>"/>
                    <jsp:param name="prezzo" value="<%=pd.getPrezzo()%>"/>
                    <jsp:param name="sconto" value="<%=pd.getSconto()%>"/>
                    <jsp:param name="quantita_att" value="<%=pd.getQuantitaAttuale()%>"/>
                    <jsp:param name="descrizione" value="<%=pd.getDescrizione()%>"/>
                </jsp:include>
                <%}%>
            </ul>
        </div>

    </section>
</section>
<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
</html>
