package utility;

import model.prodotti.Prodotti;
import model.ruolo.Ruolo;
import model.statoOrdini.StatoOrdini;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Utilita
{
    /**
     * Pattern per la password degli utenti
     */
    public static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    /**
     * Lunghezza token autenticazione
     */
    public static final int lenghtAuth=64;
    /**
     * Nome dell'attributo utente all'interno della sessione
     */
    public static final String SESSION_USER="idUsSe";
    /**
     * Nome dell'attributo listaDesideri all'interno della sessione
     */
    public static final String SESSION_LISTADESIDERI="idLsDs";
    /**
     * Nome dell'attributo carrello all'interno della sessione
     */
    public static final String SESSION_CARRELLO="idCa";
    /**
     * Nome dell'attributo pagamento all'interno della sessione
     */
    public static final String SESSION_PAGAMENTO="idPa";
    /**
     * Nome del ID dell'utente per il cookie
     */
    public static final String COOKIE_ID="idUsCo";
    /**
     * Nome del tokenAuth dell'utente per il cookie
     */
    public static final String COOKIE_TOKEN="toUsCo";
    /**
     * Lista con i vari ruoli
     */
    public static List<Ruolo> listRuoli=new ArrayList<>();
    /**
     * Lista con i vari stati
     */
    public static List<StatoOrdini> listStato=new ArrayList<>();

    /**
     * Ritorna una data dando una stringa come parametro
     * @param dataStr Stringa in formato YYYY-mm-dd
     * @return Data convertita
     */
    public static Date dataConverter(String dataStr) throws ParseException
    {
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dataUtil = in.parse(dataStr);
        return new Date(dataUtil.getTime());
    }

    /**
     * restituisce una data formattata in standard italiano
     * @param date data non formattata YYYY-mm-dd
     * @return date formattato
     */
    public static String convertDateToView(Date date)
    {
        final DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }

    public static String getRuoloString(int ruolo){
        for (Ruolo r:listRuoli){
            if(ruolo == r.getIdRuolo())
                return r.getNome();
        }
        return "problem";
    }

    public static String getStatoString(int stato){
        for (StatoOrdini r:listStato){
            if(stato == r.getIdStatoOrdini())
                return r.getStato();
        }
        return "problem";
    }

    public static String getUploadPath(){
        return System.getenv("CATALINA_HOME") + File.separator + "uploads" + File.separator;
    }

    public static float getPrezzoTotale(List<Prodotti> prodottiList){
        float prezzoTotale = 0;
        for (Prodotti p : prodottiList){
            if(p.getSconto()>0){
                prezzoTotale += ((p.getPrezzo() - (p.getPrezzo() * (p.getSconto()/100))) * p.getQuantitaDaAcquistare());
                prezzoTotale = Math.round(prezzoTotale*100);
                prezzoTotale = prezzoTotale/100;
            }else{
                prezzoTotale += (p.getPrezzo() * p.getQuantitaDaAcquistare());
            }

        }
        return prezzoTotale;
    }

    public static boolean contieneParametro(HttpServletRequest request, String nome)
    {
        return request.getParameter(nome)!=null && request.getParameter(nome)!="";
    }

    public static boolean contieneFile(HttpServletRequest request, String nome) throws ServletException, IOException {
        if(request.getPart(nome).getSize()>0){
            return true;
        }else{
            return false;
        }
    }

}