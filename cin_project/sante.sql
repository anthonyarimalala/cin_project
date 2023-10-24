CREATE DATABASE cin_sante;
USE cin_sante;

CREATE TABLE unite(
    symbole VARCHAR(10) PRIMARY KEY,
    unite VARCHAR(255)
);
CREATE TABLE cours(
    id_cours INTEGER PRIMARY KEY AUTO_INCREMENT,
    symbole VARCHAR(10) REFERENCES unite(symbole),
    valeur_ariary FLOAT,
    date_cours DATE
);
ALTER TABLE cours
ADD COLUMN taux_vente FLOAT DEFAULT 3000.0;

CREATE TABLE transaction(
    id_transaction INTEGER PRIMARY KEY AUTO_INCREMENT,
    cin_envoi VARCHAR(12) REFERENCES personne(cin),
    cin_recu VARCHAR(12) REFERENCES personne(cin),
    id_cours INTEGER REFERENCES cours(id_cours),
    montant FLOAT
);

INSERT INTO unite (symbole, unite)
VALUES ('MGA', 'Ariary malgache');

INSERT INTO unite (symbole, unite)
VALUES ('USD', 'Dollar américain');

INSERT INTO unite (symbole, unite)
VALUES ('EUR', 'Euro');

INSERT INTO unite (symbole, unite)
VALUES ('GBP', 'Livre sterling');

-- Insérer des valeurs de cours pour différentes unités et dates
INSERT INTO cours (symbole, valeur_ariary, date_cours)
VALUES ('MGA', 1, '2023-10-15');

INSERT INTO cours (symbole, valeur_ariary, date_cours)
VALUES ('USD', 3700.50, '2023-10-15');

INSERT INTO cours (symbole, valeur_ariary, date_cours)
VALUES ('USD', 3710.25, '2023-10-14');

INSERT INTO cours (symbole, valeur_ariary, date_cours)
VALUES ('EUR', 4300.75, '2023-10-15');

INSERT INTO cours (symbole, valeur_ariary, date_cours)
VALUES ('EUR', 4310.20, '2023-10-14');

INSERT INTO cours (symbole, valeur_ariary, date_cours)
VALUES ('GBP', 5200.30, '2023-10-15');

UPDATE cours SET valeur_ariary=4930, taux_vente=4450 WHERE symbole='USD';
UPDATE cours SET valeur_ariary=5150, taux_vente=4890 WHERE symbole='EUR';


CREATE TABLE personne(
    cin VARCHAR(12) PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    date_naissance DATE
);
INSERT INTO personne (cin, nom, prenom, date_naissance)
VALUES ('PERS0001', 'Doe', 'John', '1990-01-01');

INSERT INTO personne (cin, nom, prenom, date_naissance)
VALUES ('PERS0002', 'Smith', 'Jane', '1985-05-15');

INSERT INTO personne (cin, nom, prenom, date_naissance)
VALUES ('PERS0003', 'Johnson', 'Robert', '1978-12-10');

INSERT INTO personne (cin, nom, prenom, date_naissance)
VALUES ('PERS0004', 'Anthony', 'Johary', '2003-10-14');


CREATE TABLE antecedant(
    id_antecedant SERIAL PRIMARY KEY,
    cin VARCHAR(12) REFERENCES personne(cin),
    antecedant VARCHAR(255)
);
INSERT INTO antecedant (cin, antecedant)
VALUES ('PERS0001', 'Hypertension artérielle');

INSERT INTO antecedant (cin, antecedant)
VALUES ('PERS0001', 'Tapa-tongotra');

INSERT INTO antecedant (cin, antecedant)
VALUES ('PERS0002', 'Diabète');

INSERT INTO antecedant (cin, antecedant)
VALUES ('PERS0003', 'Asthme');


CREATE TABLE info(
    id_info SERIAL PRIMARY KEY,
    cin VARCHAR(12) REFERENCES personne(cin),
    allergie VARCHAR(255)
);
INSERT INTO info (cin, allergie)
VALUES ('PERS0001', 'Araignées');

INSERT INTO info (cin, allergie)
VALUES ('PERS0002', 'Arachides');

INSERT INTO info (cin, allergie)
VALUES ('PERS0003', 'Pollen');


CREATE VIEW v_info AS
SELECT p.cin, p.nom, p.prenom, p.date_naissance, i.allergie FROM personne p
    JOIN info i ON p.cin = i.cin;


CREATE VIEW v_antecedant AS
SELECT p.cin, p.nom, p.prenom, p.date_naissance, a.antecedant FROM personne p
    JOIN antecedant a ON p.cin = a.cin;



DROP VIEW v_antecedant;
DROP VIEW v_info;
DROP TABLE info;
DROP TABLE antecedant;
DROP TABLE personne;
