CREATE TABLE IF NOT EXISTS Card(
    idCard INT PRIMARY KEY AUTO_INCREMENT,
    cardName VARCHAR(80) NOT NULL,
    cardCode VARCHAR(15) NOT NULL,
    cardEdition VARCHAR(30) NOT NULL,
    cardQuantity INT NOT NULL,
    cardHighPrice FLOAT NOT NULL,
    cardLowPrice FLOAT NOT NULL,
    cardAveragePrice FLOAT NOT NULL,
    lastPriceUpdate timestamp NULL
)ENGINE=INNODB;

INSERT INTO Card (idCard, cardName, cardCode, cardEdition, cardQuantity, cardHighPrice, cardLowPrice, cardAveragePrice, lastPriceUpdate)
VALUES (1, 'Right arm of the forbidden one', 'YGLD-ENA20', 'Normal', 1, 0.0, 0.0, 0.0, null);