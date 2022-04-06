package controller.api;

import model.categoria.CategoriaDao;
import model.categoria.SqlCategoriaDao;
import model.foto.FotoDao;
import model.foto.SqlFotoDao;
import model.prodotti.Prodotti;
import model.prodotti.ProdottiDao;
import model.prodotti.SqlProdottiDao;
import model.prodottiCategoria.ProdottiCategoriaDao;
import model.prodottiCategoria.SqlProdottiCategoriaDao;
import model.utente.Utente;
import org.json.JSONObject;
import utility.UtenteService;
import utility.Utilita;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet(name = "CreaProdotto", value = "/CreaProdotto")
@MultipartConfig
public class CreaProdotto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(Utilita.contieneParametro(request,"nome") && Utilita.contieneParametro(request,"prezzo") &&
        Utilita.contieneParametro(request,"sconto") && Utilita.contieneParametro(request,"quantitaAttuale")&&
        Utilita.contieneFile(request,"cover")) {

            Part filePart = request.getPart("cover");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();


            String nome = request.getParameter("nome");
            Float prezzo = Float.parseFloat(request.getParameter("prezzo"));
            Float sconto = Float.parseFloat(request.getParameter("sconto"));
            int quantitaAttuale = Integer.parseInt(request.getParameter("quantitaAttuale"));
            String descrizione = request.getParameter("descrizione");
            String categoriaStringa = request.getParameter("categorieAggiunteId");
            ArrayList<Integer> listIdCategoria = new ArrayList<>();
            if(categoriaStringa != "") {
                String[] splittedCategoria = categoriaStringa.split("-");
                for (int i = 0; i < splittedCategoria.length; i++) {
                    listIdCategoria.add(Integer.parseInt(splittedCategoria[i]));
                }
            }
            FotoDao daoFoto = new SqlFotoDao();
            ProdottiDao dao = new SqlProdottiDao();
            ProdottiCategoriaDao daoCategoriaProdotti = new SqlProdottiCategoriaDao();
            Optional<Utente> us = UtenteService.getUtente(request);
            if (us.get().getKsRuolo() == 1 || us.get().getKsRuolo() == 2) {
                try {
                    Prodotti p = dao.insertProdotto(nome, prezzo, sconto, quantitaAttuale, 0, descrizione);
                    for (Integer c : listIdCategoria) {
                        daoCategoriaProdotti.addProdottiCategoria(c.intValue(), p.getIdProdotti());
                    }
                    String uploadRoot = Utilita.getUploadPath();
                    try(InputStream fileStream = filePart.getInputStream()){
                        File file = new File(uploadRoot + fileName);
                        Files.copy(fileStream,file.toPath());
                    }
                    daoFoto.creaFoto(fileName,p.getIdProdotti());
                    response.sendRedirect("GestioneProdotti");
                } catch (SQLException e) {
                    e.printStackTrace();
                    response.sendRedirect("./");
                }
            }
        }else{
            response.sendRedirect("./");
        }
    }
}
