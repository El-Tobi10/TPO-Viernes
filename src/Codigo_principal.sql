CREATE DATABASE TPO
go

USE TPO
go

BACKUP DATABASE TPO TO DISK = 'C:\Users\Urano\OneDrive\Escritorio\Toto\Backup DB'
go

--Creacion de las tablas
CREATE TABLE usuarios(
	id_usuario int PRIMARY KEY IDENTITY,
	usuario varchar(20) NOT NULL UNIQUE,
	email varchar(60) NOT NULL UNIQUE,
	creacion date,
	);

CREATE TABLE juegos (
    id_juego int PRIMARY KEY IDENTITY,
    titulo varchar(100) NOT NULL,
    lanzamiento DATE NOT NULL,
    desarrollador varchar(50) NOT NULL,
	);

CREATE TABLE generos(
	id_genero int PRIMARY KEY IDENTITY,
	genero varchar(50) NOT NUll
	);

CREATE TABLE plataformas(
	id_plataforma int PRIMARY KEY IDENTITY,
	plataforma varchar(50) NOT NULL
	);

go

-- Insertado de videojuegos en la tabla Juegos
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('The Legend of Zelda: Breath of the Wild', '2017-03-03', 'Nintendo');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Super Mario Odyssey', '2017-10-27', 'Nintendo');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Red Dead Redemption 2', '2018-10-26', 'Rockstar Games');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('The Witcher 3: Wild Hunt', '2015-05-19', 'CD Projekt Red');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('God of War', '2018-04-20', 'Santa Monica Studio');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Horizon Zero Dawn', '2017-02-28', 'Guerrilla Games');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Persona 5', '2016-09-15', 'Atlus');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Bloodborne', '2015-03-24', 'FromSoftware');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Sekiro: Shadows Die Twice', '2019-03-22', 'FromSoftware');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Spider-Man', '2018-09-07', 'Insomniac Games');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Minecraft', '2011-11-18', 'Mojang');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Fortnite', '2017-07-25', 'Epic Games');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Overwatch', '2016-05-24', 'Blizzard Entertainment');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Apex Legends', '2019-02-04', 'Respawn Entertainment');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Cyberpunk 2077', '2020-12-10', 'CD Projekt Red');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Animal Crossing: New Horizons', '2020-03-20', 'Nintendo');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Doom Eternal', '2020-03-20', 'id Software');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Half-Life: Alyx', '2020-03-23', 'Valve');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Ghost of Tsushima', '2020-07-17', 'Sucker Punch Productions');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Final Fantasy VII Remake', '2020-04-10', 'Square Enix');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Resident Evil 2', '2019-01-25', 'Capcom');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Monster Hunter: World', '2018-01-26', 'Capcom');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Nier: Automata', '2017-02-23', 'PlatinumGames');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Dark Souls III', '2016-03-24', 'FromSoftware');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Assassin\s Creed Valhalla', '2020-11-10', 'Ubisoft');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('The Last of Us Part II', '2020-06-19', 'Naughty Dog');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Among Us', '2018-06-15', 'InnerSloth');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Genshin Impact', '2020-09-28', 'miHoYo');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Hades', '2020-09-17', 'Supergiant Games');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Control', '2019-08-27', 'Remedy Entertainment');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Death Stranding', '2019-11-08', 'Kojima Productions');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Ori and the Will of the Wisps', '2020-03-11', 'Moon Studios');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Hollow Knight', '2017-02-24', 'Team Cherry');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Cuphead', '2017-09-29', 'Studio MDHR');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Celeste', '2018-01-25', 'Maddy Makes Games');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Dead Cells', '2018-08-07', 'Motion Twin');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Slay the Spire', '2019-01-23', 'MegaCrit');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Baba Is You', '2019-03-13', 'Hempuli');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Outer Wilds', '2019-05-28', 'Mobius Digital');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Firewatch', '2016-02-09', 'Campo Santo');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Stardew Valley', '2016-02-26', 'ConcernedApe');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Undertale', '2015-09-15', 'Toby Fox');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Rocket League', '2015-07-07', 'Psyonix');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('PUBG', '2017-12-20', 'PUBG Corporation');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('League of Legends', '2009-10-27', 'Riot Games');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Valorant', '2020-06-02', 'Riot Games');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Destiny 2', '2017-09-06', 'Bungie');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('FIFA 21', '2020-10-09', 'EA Sports');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('NBA 2K21', '2020-09-04', 'Visual Concepts');
INSERT INTO juegos (titulo, lanzamiento, desarrollador) VALUES ('Fallout 4', '2015-11-10', 'Bethesda Game Studios');
select * from juegos;
go

--Ingreso de los generos
INSERT INTO generos (genero) VALUES ('Acción');
INSERT INTO generos (genero) VALUES ('Aventura');
INSERT INTO generos (genero) VALUES ('Rol');
INSERT INTO generos (genero) VALUES ('Estrategia');
INSERT INTO generos (genero) VALUES ('Simulación');
INSERT INTO generos (genero) VALUES ('Deportes');
INSERT INTO generos (genero) VALUES ('Carreras');
INSERT INTO generos (genero) VALUES ('Pelea');
INSERT INTO generos (genero) VALUES ('Plataformas');
INSERT INTO generos (genero) VALUES ('Puzzle');
INSERT INTO generos (genero) VALUES ('Terror');
INSERT INTO generos (genero) VALUES ('Disparos en primera persona (FPS)');
INSERT INTO generos (genero) VALUES ('Disparos en tercera persona (TPS)');
INSERT INTO generos (genero) VALUES ('Mundo abierto');
INSERT INTO generos (genero) VALUES ('Survival horror');
INSERT INTO generos (genero) VALUES ('Battle Royale');
INSERT INTO generos (genero) VALUES ('MMORPG');
INSERT INTO generos (genero) VALUES ('MOBA');
INSERT INTO generos (genero) VALUES ('Juego de cartas');
INSERT INTO generos (genero) VALUES ('Roguelike');
INSERT INTO generos (genero) VALUES ('Roguelite');
INSERT INTO generos (genero) VALUES ('Metroidvania');
INSERT INTO generos (genero) VALUES ('JRPG');
INSERT INTO generos (genero) VALUES ('Dungeon Crawler');
INSERT INTO generos (genero) VALUES ('Stealth');
INSERT INTO generos (genero) VALUES ('Ciencia ficción');
INSERT INTO generos (genero) VALUES ('Fantástico');
INSERT INTO generos (genero) VALUES ('Western');
INSERT INTO generos (genero) VALUES ('Cyberpunk');
INSERT INTO generos (genero) VALUES ('Post-apocalíptico');
INSERT INTO generos (genero) VALUES ('Histórico');
INSERT INTO generos (genero) VALUES ('Educativo');
INSERT INTO generos (genero) VALUES ('Indie');
INSERT INTO generos (genero) VALUES ('Arcade');
INSERT INTO generos (genero) VALUES ('Realidad virtual');
INSERT INTO generos (genero) VALUES ('Realidad aumentada');
INSERT INTO generos (genero) VALUES ('Novela visual');
INSERT INTO generos (genero) VALUES ('Ritmo');
INSERT INTO generos (genero) VALUES ('Táctico');
INSERT INTO generos (genero) VALUES ('Sandbox');
INSERT INTO generos (genero) VALUES ('Party game');
INSERT INTO generos (genero) VALUES ('Horror psicológico');
INSERT INTO generos (genero) VALUES ('Pinball');
INSERT INTO generos (genero) VALUES ('Tycoon');
INSERT INTO generos (genero) VALUES ('Survival');
INSERT INTO generos (genero) VALUES ('JRPG por turnos');
INSERT INTO generos (genero) VALUES ('Puzzle-platformer');
select * from generos;
go 

--Ingreso las plataformas
INSERT INTO plataformas (plataforma) VALUES ('PlayStation');
INSERT INTO plataformas (plataforma) VALUES ('Xbox');
INSERT INTO plataformas (plataforma) VALUES ('Nintendo');
INSERT INTO plataformas (plataforma) VALUES ('PC');
select * from plataformas;
go
