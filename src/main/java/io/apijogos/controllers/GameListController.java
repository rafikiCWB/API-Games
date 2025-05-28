package io.apijogos.controllers;

import io.apijogos.dto.GameMinDTO;
import io.apijogos.modal.entities.GameList;
import io.apijogos.services.GameListService;
import io.apijogos.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/game-list")
public class GameListController {

    @Autowired
    private  GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameList>> findAll() {
        List<GameList> result = gameListService.findAll();
        return ResponseEntity.ok(result);

    }

    @GetMapping("/{listId}")
    public ResponseEntity<GameList> findById(@PathVariable Long listId) {
        return gameListService.findByListaGame(listId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/v2/{listId}")
    public List<GameMinDTO> findDTO(@PathVariable Long listId) {
        List<GameMinDTO> byGameList = gameService.findByGameList(listId);
        return byGameList;
    }

}