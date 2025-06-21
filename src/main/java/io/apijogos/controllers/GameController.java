package io.apijogos.controllers;

import io.apijogos.dto.GameDTO;
import io.apijogos.dto.GameMinDTO;
import io.apijogos.modal.entities.Game;
import io.apijogos.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  //add pagable to Game
  @GetMapping
  PagedModel<Game> findPageGamesController(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "20") int size){
    Pageable pageRequest = PageRequest.of(page, size);
    Page<Game> todos = gameService.pageGamesService(pageRequest);
    return new PagedModel<>(todos);
  }

}