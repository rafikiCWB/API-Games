package io.apijogos.services;

import io.apijogos.dto.GameDTO;
import io.apijogos.dto.GameMinDTO;
import io.apijogos.modal.entities.Game;
import io.apijogos.projections.GameMinProjection;
import io.apijogos.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service // service é um component dentro do Spring
public class GameService {

  @Autowired
  private GameRepository gameRepository;

  @Transactional(readOnly = true)
  public Game findById(@PathVariable Long listId) {
    return gameRepository.findById(listId).get();
  }

  @Transactional(readOnly = true)
  public List<Game> all() {
    List<Game> result = gameRepository.findAll();
    return result;
  }

  @Transactional(readOnly = true)
  public Page<Game> pageGamesService(Pageable pageable) {
    return gameRepository.findAll(pageable);
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> minDTO() {
    List<Game> result = gameRepository.findAll();
    return result.stream().map(GameMinDTO::new).toList(); //"Map" transforma objetos de uma coisa para outra. ->
  }

  @Transactional(readOnly = true)
  public List<GameDTO> allDTO() {
    List<Game> dto = gameRepository.findAll();
    return dto.stream().map(GameDTO::new).toList();
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findByGameList(Long listId) {
    List<GameMinProjection> games = gameRepository.searchByList(listId);
    return games.stream().map(GameMinDTO::new).toList();
  }



}