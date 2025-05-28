-- Migration V7: Criação da tabela GameList e inserção de dados iniciais
CREATE TABLE tb_game_list
(
    id   BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO tb_game_list (id, name)
VALUES (1, 'Favoritos'),
       (2, 'Jogos de Ação'),
       (3, 'RPGs'),
       (4, 'Indies'),
       (5, 'Clássicos');
