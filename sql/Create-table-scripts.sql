CREATE TABLE ARTICULO (
       COD_ARTICULO INT(5) NOT NULL UNIQUE,
       NOM_ARTICULO VARCHAR(50) NOT NULL UNIQUE,
       SUPERMERCADO VARCHAR(50) NOT NULL UNIQUE,
       PRECIO INT(3) NOT NULL UNIQUE,
       FEC_CAD_ART DATE NOT NULL UNIQUE,
       PRIMARY KEY (COD_ARTICULO)
);

CREATE TABLE LISTA(
       COD_LISTA VARCHAR(50) NOT NULL UNIQUE,
       NOM_US VARCHAR(50) NOT NULL UNIQUE,
       COD_ARTICULO INT(50) NOT NULL UNIQUE,
       NOM_ARTICULO VARCHAR(50)  NOT NULL UNIQUE,
       SUPERMERCADO VARCHAR(50) NOT NULL UNIQUE,
       PRECIO INT(3) NOT NULL UNIQUE,
       CANTIDAD INT(3) ,
       PRIMARY KEY (COD_LISTA)
);

CREATE TABLE USUARIO (
       NOM_US VARCHAR(50) NOT NULL UNIQUE,
       ID_DESPEN VARCHAR(50) NOT NULL UNIQUE,
       COD_LISTA VARCHAR(50) NOT NULL UNIQUE,
       PASS_US VARCHAR(50) NOT NULL UNIQUE,
       EMAIL_US VARCHAR(50),
       PRIMARY KEY (NOM_US)
);

CREATE TABLE DESPENSA(
       ID_DESPEN VARCHAR(50) NOT NULL UNIQUE,
       NOM_US VARCHAR(50) NOT NULL UNIQUE,
       COD_ARTICULO INT(50) NOT NULL UNIQUE,
       NOM_ARTICULO VARCHAR(50) NOT NULL UNIQUE,
       NUM_ARTICULOS INT(3) ,
       FEC_CAD_ART DATE NOT NULL UNIQUE,
       PRIMARY KEY (ID_DESPEN)
);

CREATE TABLE DESPENSA_ARTICULO(
       COD_ARTICULO INT(5) NOT NULL UNIQUE,
       ID_DESPEN VARCHAR(50) NOT NULL UNIQUE,
       PRIMARY KEY (COD_ARTICULO,ID_DESPEN)
);

CREATE TABLE LISTA_ARTICULO(
       COD_LISTA VARCHAR(50) NOT NULL UNIQUE,
       COD_ARTICULO INT(5) NOT NULL UNIQUE,
       PRIMARY KEY (COD_LISTA,COD_ARTICULO)
);

ALTER TABLE LISTA ADD FOREIGN KEY (NOM_US) REFERENCES USUARIO (NOM_US);
ALTER TABLE LISTA ADD FOREIGN KEY (COD_ARTICULO) REFERENCES ARTICULO (COD_ARTICULO);
ALTER TABLE LISTA ADD FOREIGN KEY (NOM_ARTICULO) REFERENCES ARTICULO (NOM_ARTICULO);
ALTER TABLE LISTA ADD FOREIGN KEY (SUPERMERCADO) REFERENCES ARTICULO (SUPERMERCADO);
ALTER TABLE LISTA ADD FOREIGN KEY (PRECIO) REFERENCES ARTICULO (PRECIO);

ALTER TABLE USUARIO ADD FOREIGN KEY (ID_DESPEN) REFERENCES DESPENSA (ID_DESPEN);
ALTER TABLE USUARIO ADD FOREIGN KEY (COD_LISTA) REFERENCES LISTA (COD_LISTA);

ALTER TABLE DESPENSA ADD FOREIGN KEY (COD_ARTICULO) REFERENCES ARTICULO (COD_ARTICULO);
ALTER TABLE DESPENSA ADD FOREIGN KEY (NOM_US) REFERENCES USUARIO (NOM_US);
ALTER TABLE DESPENSA ADD FOREIGN KEY (NOM_ARTICULO) REFERENCES ARTICULO (NOM_ARTICULO);
ALTER TABLE DESPENSA ADD FOREIGN KEY (FEC_CAD_ART) REFERENCES ARTICULO (FEC_CAD_ART);