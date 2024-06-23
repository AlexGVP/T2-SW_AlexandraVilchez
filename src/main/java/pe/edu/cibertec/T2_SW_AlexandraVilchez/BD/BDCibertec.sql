CREATE DATABASE BDCibertec;
USE BDCibertec;

CREATE TABLE Personaje
(
 IdPersonaje 		INT NOT NULL AUTO_INCREMENT,
 NomPersonaje		VARCHAR(50) NOT NULL,
 ApePersonaje 		VARCHAR(50) NOT NULL,
 FechNacPersonaje	DATE NOT NULL,
 PRIMARY KEY (IdPersonaje)
);

CREATE TABLE ProgramaTv
(
 IdProgramaTv 		INT NOT NULL AUTO_INCREMENT,
 Titulo 			VARCHAR(250) NOT NULL,
 Resumen 			VARCHAR(250) NOT NULL,
 FechaInicio	DATE NOT NULL,
 IdPersonaje 			INT NOT NULL,
 PRIMARY KEY (IdProgramaTv),
 FOREIGN KEY (IdPersonaje) REFERENCES Personaje(IdPersonaje)
 );
 
INSERT INTO Personaje (NomPersonaje, ApePersonaje, FechNacPersonaje)
VALUES 
('Naruto', 'Uzumaki', '1987-10-10'),
('Monkey D.', 'Luffy', '1997-05-05'),
('Ichigo', 'Kurosaki', '1988-07-15'),
('Goku', 'Son', '1976-04-16'),
('Edward', 'Elric', '1999-02-03'),
('Light', 'Yagami', '1986-02-28'),
('Eren', 'Yeager', '2000-03-30'),
('Saitama', 'Héroe', '1990-01-01');

INSERT INTO ProgramaTv (Titulo, Resumen, FechaInicio, IdPersonaje)
VALUES 
('Naruto', 'Un joven ninja busca reconocimiento y sueña con convertirse en el Hokage.', '2002-10-03', 1),
('One Piece', 'Un chico con poderes de goma busca el legendario tesoro One Piece.', '1999-10-20', 2),
('Bleach', 'Un adolescente obtiene los poderes de un Segador de Almas para proteger a los vivos y a los muertos.', '2004-10-05', 3),
('Dragon Ball Z', 'Las aventuras de Goku mientras defiende la Tierra contra poderosos enemigos.', '1989-04-26', 4),
('Fullmetal Alchemist', 'Dos hermanos usan la alquimia para buscar la Piedra Filosofal.', '2003-10-04', 5),
('Death Note', 'Un estudiante de secundaria descubre un cuaderno que le permite matar a cualquiera.', '2006-10-03', 6),
('Attack on Titan', 'La humanidad lucha por sobrevivir contra gigantes humanoides conocidos como Titanes.', '2013-04-07', 7),
('One Punch Man', 'Un héroe puede derrotar a cualquier oponente con un solo golpe pero busca un verdadero desafío.', '2015-10-05', 8);