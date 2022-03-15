//Inserisce nel modal i valori in campi hidden e nel campo ruolo
function iconModificaPermessi(idUtente,idRuolo) {
    $("#idUtenteInput").val(idUtente);
    $("#selectPermessi").val(idRuolo);
}
//Esegue la chiamata ajax e restituisce un oggetto json dove Ris=1 nel caso la Modifica va a buon fine
//0 se la Modifica non va a buon fine
function modificaPermessi(){
    let idUtente = $("#idUtenteInput").val();
    let tipoPersmessi = $("#selectPermessi").val();
    var data = {
        idUtente : idUtente,
        idRuolo : tipoPersmessi
    }
    $.ajax({
        url: 'api/ModificaPermessi',
        dataType: "json",
        type: "post",
        data: data,
        success: function (result) {
            if(result.Ris == 1) {
                alert(result.Mess)
            }else {
                alert(result.Mess)
            }
        }
    });
}