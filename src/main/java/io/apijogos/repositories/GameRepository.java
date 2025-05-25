package io.apijogos.repositories;

import io.apijogos.modal.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<Game, Long> {

  //searchByList
}
