package io.apijogos.modal.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

  @EmbeddedId
  private BelongingPK id = new BelongingPK();
  private Integer position;

  public BelongingPK getId() {
    return id;
  }

  public void setId(BelongingPK id) {
    this.id = id;
  }

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Belonging belonging)) return false;
    return Objects.equals(id, belonging.id) && Objects.equals(position, belonging.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, position);
  }

}