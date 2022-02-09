CREATE TABLE Photo (
id INTEGER PRIMARY KEY,
size INTEGER NOT NULL,
url TEXT NOT NULL
);

CREATE TABLE Categorie (
id INTEGER PRIMARY KEY,
nom TEXT NOT NULL
);

CREATE TABLE Article (
id INTEGER PRIMARY KEY,
libelle TEXT NOT NULL,
marque TEXT NOT NULL,
prix REAL NOT NULL,
idPhoto INTEGER NOT NULL, 
idCategorie INTEGER NOT NULL,
FOREIGN KEY (idPhoto) REFERENCES Photo(id),
FOREIGN KEY (idCategorie) REFERENCES Categorie(id)
);

CREATE TABLE Role (
id INTEGER PRIMARY KEY,
nom TEXT NOT NULL
);

CREATE TABLE Utilisateur (
id INTEGER PRIMARY KEY,
nom TEXT NOT NULL,
prenom TEXT NOT NULL,
email TEXT NOT NULL,
idRole INTEGER NOT NULL,
FOREIGN KEY (idRole) REFERENCES Role(id)
);

CREATE TABLE Boutique (
id INTEGER UNSIGNED AUTO_INCREMENT PRIMARY KEY,
description TEXT NOT NULL,
adresse TEXT NOT NULL,
contact TEXT NOT NULL
);

CREATE TABLE Panier (
id INTEGER PRIMARY KEY,
confirme INTEGER NOT NULL
);

CREATE TABLE PanierArticle (
idPanier INTEGER,
idArticle INTEGER,
PRIMARY KEY (idPanier, idArticle),
FOREIGN KEY (idPanier) REFERENCES Panier(id),
FOREIGN KEY (idArticle) REFERENCES Article(id)
);