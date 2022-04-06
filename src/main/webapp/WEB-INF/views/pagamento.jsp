<%@ page import="model.ordini.Ordini" %><%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 01/04/2022
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Pagamento"/>
    </jsp:include>
    <link rel="stylesheet" href="css/pagamento.css">
    <script src="script/pagamento.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<% Ordini ordine =(Ordini)request.getAttribute("ordine");%>
<section>
    <div class="vhPage pagamento">
        <h2 class="text-align-center">Ordine effettuato con successo!</h2>
        <h2 class="text-align-center">Prezzo totale: <%=ordine.getPrezzoTotale()%></h2>
        <div class="div-container">
            <form action="Pagamento" method="post" class="form-pagamento">
                <div class="pagamento__container">
                    <h3 class="text-align-center">Indirizzo di spedizione</h3>
                    <div class="column-pagamento">
                        <div class="container-input">
                            <div>
                                <label for="indirizzoId">Indirizzo*</label>
                            </div>
                            <div>
                                <input name="indirizzo" id="indirizzoId" type="text" required>
                            </div>
                        </div>
                        <div class="container-input">
                            <div>
                                <label for="cittaId">Citta*</label>
                            </div>
                            <div>
                                <input name="citta" id="cittaId" type="text" required>
                            </div>
                        </div>
                    </div>
                    <div class="column-pagamento">
                        <div class="container-input">
                            <div>
                                <label for="nazioneId">Nazione*</label>
                            </div>
                            <div>
                                <input name="nazione" id="nazioneId" type="text" required>
                            </div>
                        </div>
                        <div class="container-input">
                            <div>
                                <label for="codicePostaleId">Codice postale*</label>
                            </div>
                            <div>
                                <input name="codicePostale" id="codicePostaleId" type="number" required>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="pagamento__container">
                    <h3 class="text-align-center">Dati carta di credito</h3>
                    <div class="column-pagamento">
                        <div class="container-input">
                            <div>
                                <label for="nomeId">Nome</label>
                            </div>
                            <div>
                                <input name="nome" id="nomeId" type="text" required>
                            </div>
                        </div>
                        <div class="container-input">
                            <div>
                                <label for="cognomeId">Cognome*</label>
                            </div>
                            <div>
                                <input name="cognome" id="cognomeId" type="text" required>
                            </div>
                        </div>
                    </div>
                    <div class="column-pagamento">
                        <div class="container-input">
                            <div>
                                <label for="codiceFiscaleId">Codice fiscale*</label>
                            </div>
                            <div>
                                <input name="codiceFiscale" id="codiceFiscaleId" type="text" required>
                            </div>
                        </div>
                        <div class="container-input">
                            <div>
                                <label for="indirizzoEmailId">Indirizzo email*</label>
                            </div>
                            <div>
                                <input name="indirizzoEmail" id="indirizzoEmailId" type="text" required>
                            </div>
                        </div>

                    </div>
                    <div class="column-pagamento">
                        <div class="container-input">
                            <div>
                                <label for="numeroCartaCreditoId">Numero carta di credito*</label>
                            </div>
                            <div>
                                <input name="numeroCartaCredito" id="numeroCartaCreditoId" type="number" required>
                            </div>
                        </div>
                        <div class="container-input">
                            <div>
                                <label for="codiceSicurezzaId">Codice di sicurezza*</label>
                            </div>
                            <div>
                                <input name="codiceSicurezza" id="codiceSicurezzaId" type="number" required>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="button-paga">
                    <div>
                        <input type="hidden" name="idOrdine" value="<%=ordine.getIdOrdini()%>">
                        <input onclick="return validateFormPagamento()" type="submit" value="Paga">
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>



<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
</html>