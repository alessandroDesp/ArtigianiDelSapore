<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 02/04/2022
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Offerte"/>
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
%>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<section>
    <section class="title-Prodotti">
        <h1 class="">Prodotti in offerta</h1>
    </section>
    <div class="numero-pagina">
        <%if(numeroProdottiTotali>0){%>
            <%if(numeroPagina>1){%>
                <div class="numero-pagina__div"><a href="Offerte?numeroPagina=<%=numeroPagina-1%>"><i class="fa-solid fa-arrow-left"></i></a></div>
                <div class="numero-pagina__div"><a href="Offerte?numeroPagina=1"><button>1</button></a></div>
                <%}%>
                <div class="numero-pagina__div"><button pagina-active><%=numeroPagina%></button></div>
                <%if(numeroPagina < (int)Math.floor(numeroProdottiTotali / 12)+1){%>
                <div class="numero-pagina__div"><a href="Offerte?numeroPagina=<%=(int)Math.floor(numeroProdottiTotali / 12)+1%>"><button><%=(int)Math.floor(numeroProdottiTotali / 12)+1%></button></a></div>
                <div class="numero-pagina__div"><a href="Offerte?numeroPagina=<%=numeroPagina+1%>"><i class="fa-solid fa-arrow-right"></i></a></div>
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
                    <jsp:param name="fotoPath" value="<%=pd.getFotoPath()%>"/>
                </jsp:include>
                <%}%>
            </ul>
        </div>

    </section>
</section>
<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
</html>
