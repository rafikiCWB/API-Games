package io.apijogos.dto;

import io.apijogos.modal.entities.Game;

public class GameDTO {

  private Long id;
  private String title;

  public GameDTO(Game entity) {
    id = entity.getId();
    title = entity.getTitle();

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
