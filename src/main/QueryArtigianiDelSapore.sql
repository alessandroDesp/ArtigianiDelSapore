DROP DATABASE IF EXISTS ArtigianiDelSapore;
CREATE DATABASE ArtigianiDelSapore;
use ArtigianiDelSapore;

CREATE TABLE Ruolo
(
	idRuolo INT NOT NULL AUTO_INCREMENT,
	ruolo VARCHAR(45) NOT NULL,
	PRIMARY KEY (idRuolo)
);

CREATE TABLE ListaDesideri
(
	idListaDesideri INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (idListaDesideri)
);

CREATE TABLE Utente
(
	idUtente INT NOT NULL AUTO_INCREMENT,
	ksRuolo INT NOT NULL,
    ksListaDesideri INT NOT NULL,
	cf CHAR(16) NOT NULL,
	nome VARCHAR(65) NOT NULL,
	cognome VARCHAR(65) NOT NULL,
	email VARCHAR(65) NOT NULL UNIQUE,
	password VARCHAR(255) NOT NULL,
	dataNascita DATE NOT NULL,
	tokenAuth CHAR(64) NOT NULL,
	PRIMARY KEY (idUtente),
	FOREIGN KEY (ksRuolo) REFERENCES Ruolo(idRuolo),
    FOREIGN KEY (ksListaDesideri) REFERENCES ListaDesideri(idListaDesideri)
);

CREATE TABLE StatoOrdini
(
	idStatoOrdini INT NOT NULL AUTO_INCREMENT,
	stato VARCHAR(45) NOT NULL,
	PRIMARY KEY (idStatoOrdini)
);

CREATE TABLE Ordini
(
	idOrdini INT NOT NULL AUTO_INCREMENT,
    ksUtente INT NOT NULL,
    ksStatoOrdini INT NOT NULL,
	prezzoTotale float NOT NULL,
	data DATE NOT NULL,
	PRIMARY KEY (idOrdini),
	FOREIGN KEY (ksUtente) REFERENCES Utente(idUtente),
    FOREIGN KEY (ksStatoOrdini) REFERENCES StatoOrdini(idStatoOrdini)
);

CREATE TABLE Prodotti
(
	idProdotti INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(65) NOT NULL,
	prezzo Float NOT NULL,
    sconto Float NOT NULL,
	quantitaAttuale INT NOT NULL,
    quantitaVenduta INT NOT NULL,
	descrizione VARCHAR(128) NOT NULL,
	PRIMARY KEY (idProdotti)
);

CREATE TABLE OrdiniProdotti
(
	idOrdiniProdotti INT NOT NULL AUTO_INCREMENT,
    ksOrdini INT NOT NULL,
    ksProdotti INT NOT NULL,
	quantita INT NOT NULL,
	PRIMARY KEY (idOrdiniProdotti),
    FOREIGN KEY (ksOrdini) REFERENCES Ordini(idOrdini),
    FOREIGN KEY (ksProdotti) REFERENCES Prodotti(idProdotti)
);

CREATE TABLE Foto
(
	idFoto INT NOT NULL AUTO_INCREMENT,
	ksProdotti INT NOT NULL,
	percorso VARCHAR(128) NOT NULL,
	PRIMARY KEY (idFoto),
	FOREIGN KEY (ksProdotti) REFERENCES Prodotti(idProdotti)
);

CREATE TABLE Categoria
(
	idCategoria INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(65) NOT NULL,
	PRIMARY KEY (idCategoria)
);

CREATE TABLE ProdottiCategoria
(
	idProdottiCategoria INT NOT NULL AUTO_INCREMENT,
    ksProdotti INT NOT NULL,
    ksCategoria INT NOT NULL,
	PRIMARY KEY (idProdottiCategoria),
    FOREIGN KEY (ksProdotti) REFERENCES Prodotti(idProdotti),
    FOREIGN KEY (ksCategoria) REFERENCES Categoria(idCategoria)
    
);

CREATE TABLE ListaDesideriProdotti
(
	idListaDesideriProdotti INT NOT NULL AUTO_INCREMENT,
	ksListaDesideri INT NOT NULL,
	ksProdotti INT NOT NULL,
	PRIMARY KEY (idListaDesideriProdotti),
	FOREIGN KEY (ksListaDesideri) REFERENCES ListaDesideri(idListaDesideri),
	FOREIGN KEY (ksProdotti) REFERENCES Prodotti(idProdotti)
);

CREATE TABLE pagamentoOrdini
(
    idPagamentoOrdini INT NOT NULL AUTO_INCREMENT,
    ksOrdini INT NOT NULL,
    indirizzoEmail VARCHAR(65) NOT NULL,
    indirizzo VARCHAR(65) NOT NULL,
    citta VARCHAR(65) NOT NULL,
    nazione VARCHAR(65) NOT NULL,
    codicePostale VARCHAR(65) NOT NULL,
    PRIMARY KEY (idPagamentoOrdini),
    FOREIGN KEY (ksOrdini) REFERENCES Ordini(idOrdini),
);


