
CREATE TABLE IF NOT EXISTS Usuari (
    usuari VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS Llibre (
    id_Llibre INT NOT NULL AUTO_INCREMENT,
    titol VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    editorial VARCHAR(255),
    datapublicacio DATE, 
    tematica VARCHAR(100),
    ISBN VARCHAR (25) NOT NULL,
    PRIMARY KEY (idLlibre)
);