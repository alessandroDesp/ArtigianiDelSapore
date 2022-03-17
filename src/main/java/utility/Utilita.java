package utility;

import model.ruolo.Ruolo;
import model.statoOrdini.StatoOrdini;

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
     * API Key di Stripe
     */
    public static final String stripeKey="sk_test_51KLDXkBGMwZsdNHVNexZB0QYRKoufGyY1XkvZqIvRUncWZIrTwuxFmWA2v9mfWkRHkrdzHmeQfFHsQGKHWu7SYvO00PAVrndqP";
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

}