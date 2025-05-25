package io.apijogos.controllers;

import io.apijogos.dto.GameDTO;
import io.apijogos.dto.GameMinDTO;
import io.apijogos.modal.entities.Game;
import io.apijogos.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/games")
public class GameController {

  @Autowired
  private GameService gameService;

  @GetMapping(value = "/all")
  public List<Game> findAll() {
    List<Game> result = gameService.all();
    return result;
  }

  @GetMapping(value = "minDTO")
  public List<GameMinDTO> findAllMinDTO() {
    return gameService.minDTO();
  }

  @GetMapping(value = "/dto")
  public List<GameDTO> findAllDTO() {
    return gameService.allDTO();
  }

}
