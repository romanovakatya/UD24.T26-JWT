DROP TABLE IF EXISTS ventas;
DROP TABLE IF EXISTS maquinas;
DROP TABLE IF EXISTS cajeros;
DROP TABLE IF EXISTS productos; 

CREATE table productos(
id INT AUTO_INCREMENT NOT NULL,
nombre VARCHAR(100) DEFAULT NULL,
precio INT DEFAULT NULL,
PRIMARY KEY (id)
);


CREATE TABLE cajeros(
id INT AUTO_INCREMENT NOT NULL,
nom_apels VARCHAR(255) DEFAULT NULL,
PRIMARY KEY (id)
);


CREATE TABLE maquinas(
id INT AUTO_INCREMENT NOT NULL,
piso INT DEFAULT NULL,
PRIMARY KEY (id)
);


CREATE TABLE ventas(
id INT AUTO_INCREMENT NOT NULL,
id_producto INT NOT NULL,
id_cajero INT NOT NULL,
id_maquina INT NOT NULL,
PRIMARY KEY (id),

FOREIGN KEY (id_producto)
REFERENCES productos(id)
ON DELETE CASCADE
ON UPDATE CASCADE,

FOREIGN KEY (id_cajero)
REFERENCES cajeros(id)
ON DELETE CASCADE
ON UPDATE CASCADE,

FOREIGN KEY (id_maquina)
REFERENCES maquinas(id)
ON DELETE CASCADE
ON UPDATE CASCADE
);

INSERT INTO productos (nombre, precio) VALUES 
('leche', 11), ('pan', 2), ('vino', 18), ('salsa', 3), ('sandia', 90), ('jamon', 120),
('tomate', 8), ('agua', 1), ('pizza', 3), ('almendra', 5);

INSERT INTO cajeros (nom_apels) VALUES
('Laya Belen'), ('Alba Yema'), ('Jack Nikolson'), ('Fred Aster'), ('Isabel Martínez'), ('María Jusrez'), ('Lidia Agilar'), ('Andry Lind'), ('Petr Ivanov'), ('Sergi Lobo');

INSERT INTO maquinas (piso) VALUES
(1), (2), (3), (4), (5), (6), (11), (9), (34), (0);

INSERT INTO ventas (id_producto, id_cajero, id_maquina) VALUES
(1, 1, 1), (1, 2, 4), (10, 2, 5), (2, 2, 10), (5, 5, 9), (4, 8, 3), (6, 1, 7), (4, 3, 7), (10, 10, 2), (3, 4, 8);





