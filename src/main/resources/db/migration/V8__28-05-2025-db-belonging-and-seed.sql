create table IF NOT EXISTS tb_belonging
(
    game_id  BIGSERIAL NOT NULL,
    list_id  BIGSERIAL NOT NULL,
    position INT,
    CONSTRAINT fk_belonging_game_id_list_id PRIMARY KEY (game_id,list_id)
);

/*INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 1, 0);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 2, 1);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 3, 2);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 4, 3);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 5, 4);

INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 6, 0);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 7, 1);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 8, 2);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 9, 3);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 10, 4);*/

INSERT INTO tb_belonging (list_id, game_id, position)
SELECT v.list_id, v.game_id, v.position
FROM (VALUES
          (1, 1, 0),
          (1, 2, 1),
          (1, 3, 2),
          (1, 4, 3),
          (1, 5, 4),
          (2, 6, 0),
          (2, 7, 1),
          (2, 8, 2),
          (2, 9, 3),
          (2, 10, 4)
     ) AS v(list_id, game_id, position)
WHERE NOT EXISTS (
    SELECT 1 FROM tb_belonging b
    WHERE b.list_id = v.list_id AND b.game_id = v.game_id
);