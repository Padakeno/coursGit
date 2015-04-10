\c template1

drop database if exists magasin_0_6;
create database magasin_0_6;


\c magasin_0_6

/************************/
drop table if exists client;
create table client (
	id int,
	nom varchar(30) not null,
	prenom varchar(30) not null,
	dateNaissance date,
	sexe char(1), -- h pour homme et f pour femme
	parrain int,
	
	primary key(id),
	foreign key(parrain) references client(id)
);


/************************/
drop table if exists adresse;
create table adresse (
	id int,
	idClient int,
	numero int,
	voie varchar(10) not null,
	libelleVoie varchar(30) not null,
	codePostal varchar(5) not null,
	ville varchar(30) not null,
	
	
	primary key(id, idClient),
	foreign key(idClient) references client(id)
);

/************************/
drop table if exists paiement;
create table paiement (
	id int,
	libelle varchar(20) not null,
	
	primary key(id)
);


/************************/
drop table if exists commande;
create table commande (
	id int,
	idClient int,
	laDate date not null,
	idAdrLivraison int,
	idPaiement int,

	
	primary key(id),
	foreign key(idClient) references client(id),
	foreign key(idAdrLivraison, idClient) references adresse(id, idClient),
	foreign key(idPaiement) references paiement(id)
);


/************************/
drop table if exists categorie;
create table categorie (
	id int,
	libelle varchar(30) not null,
	
	primary key(id)
);


/************************/
drop table if exists produit;
create table produit (
	ref int, -- référence du produit
        nom varchar(30),
	prix float,
	idCategorie int,
	
	primary key(ref),
	foreign key(idCategorie) references categorie(id)
);



/************************/
drop table if exists porter;
create table porter(
	idCommande int,
	refProduit int,
	quantite int,
	
	primary key(idCommande, refProduit),
	foreign key(idCommande) references commande(id),
	foreign key(refProduit) references produit(ref)
);


-- ajout de l'utilisateur "gerant" (mot de passe "gerant")
drop user if exists gerant;
create user gerant login password 'gerant';
grant select, insert, update, delete on table client, adresse, paiement, commande, categorie, produit, porter to gerant;

