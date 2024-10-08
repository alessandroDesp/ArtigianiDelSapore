<%@ page import="model.utente.Utente" %>
<%@ page import="utility.Utilita" %>
<%@ page import="model.prodotti.Prodotti" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 17/02/2022
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%
    Utente u = (Utente) session.getAttribute(utility.Utilita.SESSION_USER);
    int numProdotti = 0;
    if(session.getAttribute(Utilita.SESSION_CARRELLO)!=null) {
        numProdotti = ((List<Prodotti>) session.getAttribute(Utilita.SESSION_CARRELLO)).size();
    }
%>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">

<header class="p-3 border-bottom">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="./" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none icon-home">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" width="1.5rem" class="bi me-2">
                    <!--! Font Awesome Pro 6.0.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. --><path d="M221.6 148.7C224.7 161.3 224.8 174.5 222.1 187.2C219.3 199.1 213.6 211.9 205.6 222.1C191.1 238.6 173 249.1 151.1 254.1V472C151.1 482.6 147.8 492.8 140.3 500.3C132.8 507.8 122.6 512 111.1 512C101.4 512 91.22 507.8 83.71 500.3C76.21 492.8 71.1 482.6 71.1 472V254.1C50.96 250.1 31.96 238.9 18.3 222.4C10.19 212.2 4.529 200.3 1.755 187.5C-1.019 174.7-.8315 161.5 2.303 148.8L32.51 12.45C33.36 8.598 35.61 5.197 38.82 2.9C42.02 .602 45.97-.4297 49.89 .0026C53.82 .4302 57.46 2.303 60.1 5.259C62.74 8.214 64.18 12.04 64.16 16V160H81.53L98.62 11.91C99.02 8.635 100.6 5.621 103.1 3.434C105.5 1.248 108.7 .0401 111.1 .0401C115.3 .0401 118.5 1.248 120.9 3.434C123.4 5.621 124.1 8.635 125.4 11.91L142.5 160H159.1V16C159.1 12.07 161.4 8.268 163.1 5.317C166.6 2.366 170.2 .474 174.1 .0026C178-.4262 181.1 .619 185.2 2.936C188.4 5.253 190.6 8.677 191.5 12.55L221.6 148.7zM448 472C448 482.6 443.8 492.8 436.3 500.3C428.8 507.8 418.6 512 408 512C397.4 512 387.2 507.8 379.7 500.3C372.2 492.8 368 482.6 368 472V352H351.2C342.8 352 334.4 350.3 326.6 347.1C318.9 343.8 311.8 339.1 305.8 333.1C299.9 327.1 295.2 320 291.1 312.2C288.8 304.4 287.2 296 287.2 287.6L287.1 173.8C288 136.9 299.1 100.8 319.8 70.28C340.5 39.71 369.8 16.05 404.1 2.339C408.1 .401 414.2-.3202 419.4 .2391C424.6 .7982 429.6 2.62 433.9 5.546C438.2 8.472 441.8 12.41 444.2 17.03C446.7 21.64 447.1 26.78 448 32V472z"/>
                </svg>
            </a>

            <ul class="nav-header col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0 header-navigation">
                <li>
                    <div class="nav-link px-2 link-dark">
                        <a href="./" class="nav-link d-block link-dark">Home</a>
                    </div>
                </li>
                <li>
                    <div class="nav-link px-2 link-dark dropdown no-decoration">
                        <a class="nav-link d-block link-dark cursor_a">Cibo</a>
                        <ul class="dropdown-content text-small">
                            <li><a class="dropdown-item" href="Prodotti?categoria=Pasta&numeroPagina=1">Pasta</a></li>
                            <li><a class="dropdown-item" href="Prodotti?categoria=Riso&numeroPagina=1">Riso</a></li>
                            <li><a class="dropdown-item" href="Prodotti?categoria=Pesce&numeroPagina=1">Pesce</a></li>
                            <li><a class="dropdown-item" href="Prodotti?categoria=GlutenFree&numeroPagina=1">GlutenFree</a></li>
                        </ul>
                    </div>

                </li>

                <li>
                    <div class="nav-link px-2 link-dark dropdown no-decoration">
                        <a href="#" class="nav-link d-block link-dark cursor_a">Bevande</a>
                        <ul class="dropdown-content text-small">
                            <li><a href="Prodotti?categoria=Vino&numeroPagina=1">Vino</a></li>
                            <li><a href="Prodotti?categoria=Succhi&numeroPagina=1">Succhi</a></li>
                            <li><a href="Prodotti?categoria=Birre&numeroPagina=1">Birre</a></li>
                        </ul>
                    </div>
                </li>

                <li>
                    <a href="Offerte?numeroPagina=1" class="nav-link d-block link-dark cursor_a">Offerte</a>
                </li>


            </ul>
            <div class="nav-link px-2 link-dark dropdown no-decoration settings-icon">
                <a href="#" class="nav-link d-block link-dark cursor_a"><i class="nav-link cursor_a fa-solid fa-bars"></i></a>
                <ul class="dropdown-content">
                    <li><a class="dropdown-item" href="./">Home</a></li>
                    <li>
                        <div class="nav-link px-2 link-dark dropdown no-decoration">
                            <a href="#" class="nav-link d-block link-dark cursor_a">Cibo</a>
                            <ul class="dropdown-content dropdown-subcontent text-small">
                                <li><a class="dropdown-item" href="Prodotti?categoria=Pasta&numeroPagina=1">Pasta</a></li>
                                <li><a class="dropdown-item" href="Prodotti?categoria=Riso&numeroPagina=1">Riso</a></li>
                                <li><a class="dropdown-item" href="Prodotti?categoria=Pesce&numeroPagina=1">Pesce</a></li>
                                <li><a class="dropdown-item" href="Prodotti?categoria=Sughi&numeroPagina=1">Pesce</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="nav-link px-2 link-dark dropdown no-decoration">
                            <a href="#" class="nav-link d-block link-dark cursor_a">Bevande</a>
                            <ul class="dropdown-content dropdown-subcontent text-small">
                                <li><a class="dropdown-item" href="Prodotti?categoria=Vino&numeroPagina=1">Vino</a></li>
                                <li><a class="dropdown-item" href="Prodotti?categoria=Acqua&numeroPagina=1">Acqua</a></li>
                                <li><a class="dropdown-item" href="Prodotti?categoria=Succhi&numeroPagina=1">Succhi</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="Offerte?numeroPagina=1" class="nav-link d-block link-dark cursor_a">Offerte</a>
                    </li>
                </ul>
            </div>
            <a class="fa-solid fa-magnifying-glass icon__search" onclick="showSearch()"></a>
            <form class="col-12 col-lg-auto mb-lg-0 me-lg-3" action="Search" method="post">
                <input type="hidden" name="numeroPagina" value="1">
                <input type="search"  id="searchForm" class="form-control" placeholder="Cerca sul sito..." aria-label="Search" name="sValue">
            </form>

            <%if(u==null){%>
            <span class="container-button">
                <a class="autenticazione" href="Login"><button class="autenticazione-button">Login</button></a>
                <a class="autenticazione" href="Registrazione"><button class="autenticazione-button">Registrati</button></a>
            </span>
            <%}else{%>
            <ul class="nav-header col-3">

                <li style="padding-top: 0.5rem;">
                    <div class="nav-link px-2 link-dark dropdown no-decoration">
                        <a href="#" class="nav-link d-block link-dark">
                            <img src="images/img2.jpg" alt="mdo" width="32" height="32" class="rounded-circle">
                        </a>
                        <ul class="dropdown-content">
                            <li><a href="Anagrafica">Profilo</a></li>
                            <li><a href="Logout">Logout</a></li>
                        </ul>
                    </div>
                </li>
                <li style="padding-top: 1rem;">
                    <div class="nav-link px-2 link-dark">
                        <a href="Carrello" class="bi">
                            <i class="fa badge fa-lg" id="iconCarrello" value="<%=numProdotti%>">&#xf07a;</i>
                        </a>
                    </div>
                </li>
            </ul>
            <%}%>

        </div>
    </div>

</header>

<script>
    function showSearch(){
        $("#searchForm").toggleClass('search__show');
    }
</script>


