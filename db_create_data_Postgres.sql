-- ---------------------------------------------------------------------------------------
--  DROP Tables   a decommenter  si les tables existent deja !
-- --------------------------------------------------------------------------------------- 
 
DROP TABLE commande;
DROP TABLE produit;
DROP TABLE categorie;
DROP TABLE "CLIENT";
DROP TABLE ville;
 

-- ---------------------------------------------------------------------------------------
--  DROP sequences a decommenter  si les sequences existent deja !
-- ---------------------------------------------------------------------------------------
 
DROP SEQUENCE client_seq;
DROP SEQUENCE commande_seq;
DROP SEQUENCE produit_seq;
DROP SEQUENCE categorie_seq; 
 

-- ----------------------------
-- Table structure for "categorie"
-- ---------------------------- 
CREATE TABLE categorie(
id_categ NUMERIC(19,0) NOT NULL ,
code_categ VARCHAR(10) NULL,
libelle_categ VARCHAR(50) NULL,
PRIMARY KEY (id_categ)
);
-- ----------------------------
-- Table structure for client
-- ----------------------------
CREATE TABLE client (
id_client NUMERIC(19,0) NOT NULL ,
login_client VARCHAR(20) NULL,
mot_passe_client VARCHAR(20) NULL,
nom_client VARCHAR(70) NULL,
prenom_client VARCHAR(70) NULL,
civilite_client VARCHAR(7) NULL,
date_naissance_client VARCHAR(20) NULL,
numero_adr_client VARCHAR(5) NULL,
rue_adr_client VARCHAR(100) NULL,
commune_adr_client VARCHAR(50) NULL,
ville_adr_client VARCHAR(50) NULL,
cp_adr_client VARCHAR(10) NULL,
tel_client VARCHAR(20) NULL,
fax_client VARCHAR(20) NULL,
gsm_client VARCHAR(20) NULL,
email_client VARCHAR(50) NULL,
PRIMARY KEY (id_client)
);
-- ----------------------------
-- Table structure for "produit"
-- ----------------------------
CREATE TABLE produit(
id_produit NUMERIC(19,0) NOT NULL ,
id_categ NUMERIC(19,0) NOT NULL ,
desig_produit VARCHAR(100) NULL,
pu_produit NUMERIC (9, 3)  NULL,
qte_produit INTEGER NULL,
config_produit VARCHAR(100) NULL,
marque_produit VARCHAR(50) NULL,
modele_produit VARCHAR(50) NULL,
PRIMARY KEY (id_produit)
);
-- ----------------------------
-- Table structure for "commande"
-- ----------------------------
CREATE TABLE commande(
id_commande NUMERIC(19,0) NOT NULL ,
id_client NUMERIC(19,0)  NOT NULL,
id_produit NUMERIC(19,0)  NOT NULL,
qte_commande INTEGER NULL,
date_commande DATE NULL,
etat_commande INTEGER NULL,
PRIMARY KEY (id_commande)

);

-- ----------------------------
-- Table structure for "ville"
-- ---------------------------- 
CREATE TABLE ville(
id_ville NUMERIC(19,0) NOT NULL ,
ville_id VARCHAR(3) NOT NULL,
ville_nom VARCHAR(45) NULL,
ville_nom_reel VARCHAR(45) NULL,
ville_code_postal  VARCHAR(5) DEFAULT NULL,
ville_commune VARCHAR(3) DEFAULT NULL,
ville_code_commune VARCHAR(5) NOT NULL,
ville_arrondissement VARCHAR(1) NULL,

PRIMARY KEY (id_ville)
);

ALTER TABLE commande ADD FOREIGN KEY (id_client) REFERENCES client (id_client);

ALTER TABLE commande ADD FOREIGN KEY (id_produit) REFERENCES produit (id_produit);

ALTER TABLE produit ADD FOREIGN KEY (id_categ) REFERENCES categorie (id_categ);


-- ----------------------------
-- Sequence structure for "client_seq"
-- ----------------------------
CREATE SEQUENCE client_seq
minvalue 1
maxvalue 999999999999999999
start with 4 -- Dernier ID des insertions 
increment by 1;

 -- ----------------------------
-- Sequence structure for "commande_seq"
-- ----------------------------
CREATE SEQUENCE commande_seq
minvalue 1
maxvalue 999999999999999999
start with 15 -- Dernier ID des insertions 
increment by 1;
 
 
 -- ----------------------------
-- Sequence structure for "produit_seq"
-- ----------------------------
CREATE SEQUENCE produit_seq
minvalue 1
maxvalue 999999999999999999
start with 24 -- Dernier ID des insertions 
increment by 1;

 
 -- ----------------------------
-- Sequence structure for "categorie_seq"
-- ----------------------------
CREATE SEQUENCE categorie_seq
minvalue 1
maxvalue 999999999999999999
start with 21 -- Dernier ID des insertions 
increment by 1;


 -- ----------------------------
-- Insertions des donnes
-- ----------------------------
INSERT INTO categorie VALUES ('1', '1', 'LabTops');
INSERT INTO categorie VALUES ('2', '2', 'Ordinateurs');
INSERT INTO categorie VALUES ('3', '3', 'CD et DVD Drives');
INSERT INTO categorie VALUES ('4', '4', 'Hard Drives');
INSERT INTO categorie VALUES ('5', '5', 'Inkjet Printers');
INSERT INTO categorie VALUES ('6', '6', 'Internet Routers');
INSERT INTO categorie VALUES ('7', '7', 'Keyboards');
INSERT INTO categorie VALUES ('8', '8', 'Laser Printers');
INSERT INTO categorie VALUES ('9', '9', 'Netbooks');
INSERT INTO categorie VALUES ('10', '10', 'Network Adapters');
INSERT INTO categorie VALUES ('11', '11', 'Network Switches');
INSERT INTO categorie VALUES ('12', '12', 'Processors (CPUs)');
INSERT INTO categorie VALUES ('13', '13', 'Scanners');
INSERT INTO categorie VALUES ('14', '14', 'SD Secure Digital');
INSERT INTO categorie VALUES ('15', '15', 'Sound Cards');
INSERT INTO categorie VALUES ('16', '16', 'Speakers et Audio');
INSERT INTO categorie VALUES ('17', '17', 'USB Flash Drives');
INSERT INTO categorie VALUES ('18', '18', 'Video Cards');
INSERT INTO categorie VALUES ('19', '19', 'Webcams');
INSERT INTO categorie VALUES ('20', '20', 'Wireless Accessories');




INSERT INTO client VALUES ('2', 'Didier', 'Didier', 'TRIZIG', 'Didier', 'Mr.', '13/09/1977', '5', 'RUE DES MARTYRS', 'CENTRE', 'NICE', '70250', '05214587', '02125478', '06215487', 'did.mar@gmail.com');
INSERT INTO client VALUES ('3', 'Fabricia', 'Fabricia', 'ZARRA', 'Fabricia', 'Mme.', '06/11/1988', '6', 'RUE DES AGHLABITES', 'ZONE URBAIN', 'LE HAVRE', '04125441', '02724223', '', '0698222222', 'fab.z@gmail.com');
INSERT INTO client VALUES ('1', 'chaima', 'chaima', 'Ben Ghozzi', 'Chaima', 'Mme.', '07/07/1998', '42', 'RUE 25 JANVIER 1952', 'Hammem Laghzez', 'Tunis', '8025', '95405958', '', '0698464641', 'chaima.benghozzi@etudiant-isi.utm.tn');
INSERT INTO client VALUES ('2', 'chiraz', 'chiraz', 'Gharsallah', 'Chiraz', 'Mme.', '07/07/1998', '5', 'RUE 25 JANVIER 1952', 'Hammem Laghzez', 'Tunis', '8025', '95405958', '', '0698464641', 'chaima.benghozzi@etudiant-isi.utm.tn');


INSERT INTO produit VALUES ('1', '1', 'Acer', '480', '12', 'Acer Aspire AX3300-ED2215A AMD Athlon II X2 215 4GB 640GB GeForce 9200 Winndows 7 Home Desktop ', 'Acer', 'Aspire AX3300');
INSERT INTO produit VALUES ('2', '1', 'Samsung', '849.99', '15', 'Samsung R530L Intel Core 2 Duo T6600 4GB 500GB 15.6IN HD WLAN Webcam Windows 7 Premium Notebook Red ', 'Samsung', 'R530L ');
INSERT INTO produit VALUES ('3', '1', 'Samsung', '370', '24', 'Samsung R480-I5 Intel Core i5 430M 4GB 500GB 14IN HD WLAN Webcam Windows 7 Premium Notebook Red ', 'Samsung', 'R480-I5');
INSERT INTO produit VALUES ('4', '1', 'MSI', '500', '30', 'MSI GX640-098US Intel Core i5 430M 4GB 500GB 15.4IN WSXGA+ Radeon HD5850 Windows 7 Premium Notebook ', 'MSI', 'GX640-098US');
INSERT INTO produit VALUES ('5', '1', 'Toshiba', '670.99', '18', 'Toshiba Satellite L450-01M Intel T4300 4GB 250GB 15.6IN HD DVDRW Windows 7 Home Premium Notebook ', 'Toshiba', 'Satellite L450-01M');
INSERT INTO produit VALUES ('6', '1', 'Acer', '589', '60', 'Acer R3610 Revo Intel Atom 330 4GB 500GB NVIDIA ION HDMI eSATA WLAN GbE Windows 7 Home Premium ', 'Acer', 'R3610');
INSERT INTO produit VALUES ('7', '1', 'Acer', '599.99', '38', 'Acer M3620 Revo Intel Atom 330 2GB 160GB NVIDIA ION HDMI eSATA 802.11N GbE Windows 7 Home Premium ', 'Acer', 'M3620');
INSERT INTO produit VALUES ('8', '1', 'HP Compaq', '75', '56', 'HP Compaq CQ5210F AMD Athlon II X2 215 3GB 500GB DVDRW Windows 7 Premium X64 Desktop PC ', 'HP Compaq', 'CQ5210F');
INSERT INTO produit VALUES ('9', '1', 'Lenovo', '47', '70', 'Lenovo Ideapad S12 Intel Atom N270 1.6GHZ 1GB 160GB 12.1IN WXGA Webcam Windows XP Home Netbook 6CELL', 'Lenovo', 'Ideapad S12');
INSERT INTO produit VALUES ('10', '1', 'Dell', '599', '47', 'Dell Inspiron 15 Nb Dual Core T4200 2.0GHZ 3GB 250GB 15.6IN DVDRW Vista Basic 1 Yr Depot Warranty ', 'Dell', 'Inspiron 15 Nb');
INSERT INTO produit VALUES ('11', '1', 'Toshiba', '789', '29', 'Toshiba NB305-01E Intel Atom N450 1GB 250GB 10.1IN WSVGA Windows 7 Starter Netbook Blue 6 Cell ', 'Toshiba', 'NB305-01E');
INSERT INTO produit VALUES ('12', '1', 'HP Compaq', '840', '19', 'HP Pavilion DV7 Intel Core 2 Duo T6600 4GB 250GB DVDRW Windows 7 Premium X64 Desktop PC ', 'HP Compaq', 'Pavilion DV7');
INSERT INTO produit VALUES ('13', '1', 'Toshiba', '569', '78', 'Toshiba Satellite P500-00T Intel i7 720QM 4GB 640GB 18.4IN HD+ GeForce GT330M Bluray Win 7 Notebook ', 'Toshiba', 'Satellite P500');
INSERT INTO produit VALUES ('14', '1', 'ASUS', '489', '120', 'ASUS Eee PC 1201N Black Atom N330 NVIDIA ION 2GB 250G 12.1IN 1366X768 Draft N WIN7 Premium Netbook ', 'ASUS', 'Eee PC 1201N');
INSERT INTO produit VALUES ('15', '3', 'MicroLux', '1', '3000', 'CD VERBATIM 700 MO 80 MINUTES', 'MicroLux', 'MicroLux');
INSERT INTO produit VALUES ('16', '16', 'Patriot', '35', '400', 'Patriot Box Office Network Media Player 2.5IN HDD Support USB HDMI LAN MKV RMVB ISO DTS P2P', 'Patriot', 'Box Office');
INSERT INTO produit VALUES ('17', '12', 'Intel', '120', '500', 'Intel Core i5 750 Quad Core Processor Lynnfield LGA1156 2.66GHZ 8MB Cache Retail Box', 'Intel', 'Core i5');
INSERT INTO produit VALUES ('18', '18', 'Powercolor', '45', '100', 'Powercolor Radeon HD 5870 1GB GDDR5 2XDVI HDMI Display Port DIRECTX11 PCI-E Video Card W/ DIRT2', 'Powercolor', 'Radeon HD');
INSERT INTO produit VALUES ('19', '18', 'XFX', '34', '120', 'XFX Radeon HD 5770 850MHZ 1GB 4.8GHZ GDDR5 2XDVI HDMI Display Port DIRECTX11 PCI-E Video CARD-', 'XFX', 'Radeon');
INSERT INTO produit VALUES ('20', '17', 'Kingston', '10', '5000', 'Kingston SSDNow V Series Gen II 64GB 2.5IN SATA2 Solid State Disk Flash Drive ', 'Kingston', 'SSDNow');
INSERT INTO produit VALUES ('21', '20', 'Warpia', '2', '450', 'Warpia Lifecam Cinema 720P 16:9 HD Webcam Retail Box Auto Focus Noise Cancelling Microphone ', 'Warpia', 'Lifecam');
INSERT INTO produit VALUES ('22', '2', 'Toshiba', '560', '59', 'Toshiba Corsair Obsidian Series 800D Full Tower Case EATX 5X5.25 4X3.5 ', 'Toshiba', 'Obsidian ');
INSERT INTO produit VALUES ('23', '4', 'Western', '4000', '100', 'Western Digital My Passport Essential 500GB External Hard Drive USB 2.0 Black ', 'Western', 'Essential');

INSERT INTO commande VALUES ('1', '1', '10', '56', TO_DATE('22/11/2016', 'dd/mm/yyyy'), '1');
INSERT INTO commande VALUES ('2', '1', '1', '1', TO_DATE('23/11/2016', 'dd/mm/yyyy'), '1');
INSERT INTO commande VALUES ('3', '1', '20', '6544', TO_DATE('22/11/2016', 'dd/mm/yyyy'), '1');
INSERT INTO commande VALUES ('4', '1', '1', '1', TO_DATE('23/11/2016', 'dd/mm/yyyy'), '1');
INSERT INTO commande VALUES ('5', '2', '3', '1', TO_DATE('20/11/2016', 'dd/mm/yyyy'), '1');
INSERT INTO commande VALUES ('6', '3', '14', '1', TO_DATE('24/11/2016', 'dd/mm/yyyy'), '1');
INSERT INTO commande VALUES ('7', '3', '20', '2', TO_DATE('24/11/2016', 'dd/mm/yyyy'), '1');
INSERT INTO commande VALUES ('8', '2', '3', '1', TO_DATE('25/11/2016', 'dd/mm/yyyy'), '1');
INSERT INTO commande VALUES ('9', '2', '1', '1', TO_DATE('25/11/2016', 'dd/mm/yyyy'), '1');
INSERT INTO commande VALUES ('10', '3', '5', '1', TO_DATE('25/11/2016', 'dd/mm/yyyy'), '1');
INSERT INTO commande VALUES ('11', '3', '8', '1', TO_DATE('24/11/2016', 'dd/mm/yyyy'), '1');
INSERT INTO commande VALUES ('12', '3', '4', '1', TO_DATE('25/11/2016', 'dd/mm/yyyy'), '1');
INSERT INTO commande VALUES ('13', '2', '20', '1', TO_DATE('23/11/2016', 'dd/mm/yyyy'), '1');
INSERT INTO commande VALUES ('14', '2', '16', '1', TO_DATE('21/11/2016', 'dd/mm/yyyy'), '1');
