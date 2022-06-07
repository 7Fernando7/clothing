package com.ecommerce.clothing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "clothing")
public class Clothing {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "clothing_id")
  private int id;

  @Column(name = "clothing_name")
  private String clothingName;

  @Column(name = "clothing_size_id")
  private Integer clothingSizeId;

  @ManyToOne()
  @JoinColumn(name = "clothing_size_id", updatable = false, insertable = false)
  private ClothingSizes clothingSizes;

}
