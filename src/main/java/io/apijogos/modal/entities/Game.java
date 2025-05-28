package io.apijogos.modal.entities;

import io.apijogos.dto.GameMinDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "tb_game")
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
  @SequenceGenerator(name = "game_seq", sequenceName = "game_seq", allocationSize = 1)
  private Long id;
  @Column(nullable = false, unique = true)
  private String title;
  @Column(name = "game_year")
  @Size(min = 4, max = 4, message = "O ano do jogo deve ter 4 digitos")
  private Integer year;
  private String genre;
  private String platforms;
  private Double score;
  private String imgUrl;
  @Column(columnDefinition = "TEXT")
  private String shortDescription;
  @Column(columnDefinition = "TEXT")
  private String longDescription;

  public Game() {
  }

  public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl, String shortDescription, String longDescription) {
    this.id = id;
    this.title = title;
    this.year = year;
    this.genre = genre;
    this.platforms = platforms;
    this.score = score;
    this.imgUrl = imgUrl;
    this.shortDescription = shortDescription;
    this.longDescription = longDescription;
  }

  public Game(GameMinDTO game) {
    BeanUtils.copyProperties(game, this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Game other = (Game) obj;
    return Objects.equals(id, other.id);
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

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getPlatforms() {
    return platforms;
  }

  public void setPlatforms(String platforms) {
    this.platforms = platforms;
  }

  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getLongDescription() {
    return longDescription;
  }

  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

}