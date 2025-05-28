package io.apijogos.services;

import io.apijogos.dto.GameListDTO;
import io.apijogos.modal.entities.GameList;
import io.apijogos.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameListService {

  @Autowired
  private GameListRepository gameListRepository;

  @Transactional(readOnly = true)
  public List<GameList> findAll() {
    return gameListRepository.findAll();
  }

  @Transactional(readOnly = true)
  public List<GameListDTO> findDTO() {
    List<GameList> dto = gameListRepository.findAll();
    return dto.stream().map(GameListDTO::new).toList();
  }

  @Transactional(readOnly = true)
  public Optional<GameList> findByListaGame(Long listId) {
    return gameListRepository.findById(listId);
  }

}