/*CREATE TABLE tb_jogador
(
    id_jogador BIGINT       NOT NULL PRIMARY KEY,
    nome       VARCHAR(255) NOT NULL
);

INSERT INTO tb_jogador (id_jogador, nome)
VALUES (1, 'Rafael');

CREATE SEQUENCE game_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;*/

CREATE TABLE IF NOT EXISTS tb_game
(
    id                BIGINT       NOT NULL PRIMARY KEY,
    title             VARCHAR(255) NOT NULL UNIQUE,
    game_year         INTEGER,
    genre             VARCHAR(255),
    platforms         VARCHAR(255),
    score             DOUBLE PRECISION,
    img_url           VARCHAR(255),
    short_description TEXT,
    long_description  TEXT
);


INSERT INTO tb_game(id, title, game_year, genre, platforms, score, img_url, short_description, long_description)
values (1, 'DOTA', 2011, 'MOBA', 'PC', 4.5, 'https://wallpapercave.com/dota-2-wallpaper-hd-1920x1080',
        'Dota um jogo MOBA 5x5', 'Dota um jogo MOBA 5x5 para pc estilo RPG estratégico de ficção');