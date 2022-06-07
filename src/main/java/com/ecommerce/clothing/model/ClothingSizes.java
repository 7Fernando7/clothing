package com.ecommerce.clothing.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "clothing_sizes")
public class ClothingSizes {

  @Id
  @Column(name = "clothing_size_id")
  private int id;

  @JsonIgnore
  @OneToMany(mappedBy = "clothingSizes")
  private List<Clothing> clothings;

}
