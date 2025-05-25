package io.apijogos.services;

import io.apijogos.dto.GameDTO;
import io.apijogos.dto.GameMinDTO;
import io.apijogos.modal.entities.Game;
import io.apijogos.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service // service é um component dentro do Spring
public class GameService {

  @Autowired
  private GameRepository gameRepository;

//  @Autowired
//  private GameDTORepository gameDTORepository;

  //findById
  @Transactional(readOnly = true)
  public Game findById(@PathVariable Long listId) {
    return gameRepository.findById(listId).get();
  }

  @Transactional(readOnly = true)
  public List<Game> all() {
    List<Game> result = gameRepository.findAll();
    return result;
  }

  //findAll
  @Transactional(readOnly = true)
  public List<GameMinDTO> minDTO() {
    List<Game> result = gameRepository.findAll();
    return result.stream().map(GameMinDTO::new).toList();
  }

  @Transactional(readOnly = true)
  public List<GameDTO> allDTO() {
    List<Game> dto = gameRepository.findAll();
    return dto.stream().map(GameDTO::new).toList();
  }

}
