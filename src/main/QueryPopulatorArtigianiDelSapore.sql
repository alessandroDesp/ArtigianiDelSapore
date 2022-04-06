-- Popolazione DB

-- Popolazione Ruolo
INSERT INTO Ruolo(ruolo) VALUES("Admin");
INSERT INTO Ruolo(ruolo) VALUES("Assistente");
INSERT INTO Ruolo(ruolo) VALUES("Utente");

-- Popolazione Stato Prenotazione
INSERT INTO StatoOrdini(stato) VALUES("IN ATTESA DI PAGAMENTO");
INSERT INTO StatoOrdini(stato) VALUES("CONFERMATA");
INSERT INTO StatoOrdini(stato) VALUES("CONSEGNATO");

INSERT INTO ListaDesideri() VALUES();
INSERT INTO ListaDesideri() VALUES();
INSERT INTO ListaDesideri() VALUES();


-- Popolazione Utente SHA-256
-- Password: Password1!
INSERT INTO Utente(ksRuolo, ksListaDesideri, cf, nome, cognome, email, password, dataNascita, tokenAuth)
VALUES(1,1,"admamm98b16i823a","Admin","Amministratore","admin@gmail.com",
"0cef1fb10f60529028a71f58e54ed07b",
"1998-04-16", "YWRtaW5AZ21haWwuY29tOlBhc3N3b3JkMSE");
INSERT INTO Utente(ksRuolo, ksListaDesideri, cf, nome, cognome, email, password, dataNascita, tokenAuth)
VALUES(2,2,"opropt99f22u653d","Operator","Operatore","operator@gmail.com",
"0cef1fb10f60529028a71f58e54ed07b",
"1999-06-22", "b3BlcmF0b3JAZ21haWwuY29tOlBhc3N3b3JkMSE");
INSERT INTO Utente(ksRuolo, ksListaDesideri, cf, nome, cognome, email, password, dataNascita, tokenAuth)
VALUES(3,3,"tststr00b09i982u","Test","Tester","test@gmail.com",
"0cef1fb10f60529028a71f58e54ed07b",
"2000-02-09", "dGVzdEBnbWFpbC5jb206UGFzc3dvcmQxIQ");

INSERT INTO Ordini(ksUtente, ksStatoOrdini, prezzoTotale, data)
VALUES(1,1,200,'2022-05-04');
INSERT INTO Ordini(ksUtente, ksStatoOrdini, prezzoTotale, data)
VALUES(2,1,300,'2022-06-08');

INSERT INTO Prodotti(nome, prezzo, sconto, quantitaAttuale,quantitaVenduta,descrizione)
VALUES("Rigatoni",8,0,200,35,"bella");
INSERT INTO Prodotti(nome, prezzo, sconto, quantitaAttuale,quantitaVenduta,descrizione)
VALUES("Falanghina",14,1,55,70,"bel vino");

INSERT INTO OrdiniProdotti(ksOrdini, ksProdotti, quantita)
VALUES(1,1,3);
INSERT INTO OrdiniProdotti(ksOrdini, ksProdotti, quantita)
VALUES(1,2,1);
INSERT INTO OrdiniProdotti(ksOrdini, ksProdotti, quantita)
VALUES(2,1,2);

INSERT INTO Categoria(nome)
VALUES("Pasta");
INSERT INTO Categoria(nome)
VALUES("Riso");
INSERT INTO Categoria(nome)
VALUES("Vino");

INSERT INTO ProdottiCategoria(ksProdotti, ksCategoria)
VALUES(1,1);
INSERT INTO ProdottiCategoria(ksProdotti, ksCategoria)
VALUES(2,3);


INSERT INTO ListaDesideriProdotti(ksListaDesideri, ksProdotti)
VALUES(1,2);
INSERT INTO ListaDesideriProdotti(ksListaDesideri, ksProdotti)
VALUES(1,1);
INSERT INTO ListaDesideriProdotti(ksListaDesideri, ksProdotti)
VALUES(2,2);

-- Popolazione Foto Prodotti
INSERT INTO Foto(ksProdotti, percorso) VALUES(1,"Prodotto/1.jpeg");
INSERT INTO Foto(ksProdotti, percorso) VALUES(1,"Prodotto/2.jpeg");

INSERT INTO Foto(ksProdotti, percorso) VALUES(2,"Prodotto/3.jpeg");
INSERT INTO Foto(ksProdotti, percorso) VALUES(2,"Prodotto/1.jpeg");
