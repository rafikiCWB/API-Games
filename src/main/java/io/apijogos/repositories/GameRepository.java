package io.apijogos.repositories;

import io.apijogos.modal.entities.Game;
import io.apijogos.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

//  @Query(nativeQuery = true, value = """
//		SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
//		tb_game.short_description AS shortDescription, tb_belonging.position
//		FROM tb_game
//		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
//		WHERE tb_belonging.list_id = :listId
//		ORDER BY tb_belonging.position
//			""")
  @Query(value = """
           SELECT g.id AS id, g.title AS title, g.year AS gameYear, g.imgUrl AS imgUrl,
           g.shortDescription AS shortDescription, b.position
           FROM Game g
           INNER JOIN Belonging b ON g = b.id.game
           WHERE b.id.list.id = :listId
           ORDER BY b.position
          """)
  List<GameMinProjection> searchByList(Long listId);

//  @Query("SELECT g FROM Game g WHERE g.id IN (:listId)") // For IDs
//  List<GameMinProjection> searchByList(long listId);

}