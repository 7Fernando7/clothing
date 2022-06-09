package com.ecommerce.clothing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.clothing.dto.ClothingDTO;
import com.ecommerce.clothing.service.ClothingService;

@RestController
@RequestMapping(value = "/clothing")
public class ClothingController {

  @Autowired
  private ClothingService clothingService;

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<ClothingDTO> getClothing(@PathVariable final int id) {

    final ClothingDTO clothingOptionalDTO = clothingService.findById(id);

    return new ResponseEntity<ClothingDTO>(clothingOptionalDTO, HttpStatus.OK);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ClothingDTO> insertClothing(@RequestBody final ClothingDTO clothing) {

    final ClothingDTO clothingOptionalDTO = clothingService.registerProducts(clothing);

    return new ResponseEntity<ClothingDTO>(clothingOptionalDTO, HttpStatus.CREATED);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ClothingDTO> updateClothing(@RequestBody final ClothingDTO clothing) {

    final ClothingDTO clothingToUpdateDTO = clothingService.updateClothing(clothing);

    return new ResponseEntity<ClothingDTO>(clothingToUpdateDTO, HttpStatus.OK);

  }

  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ClothingDTO> deleteClhothing(@PathVariable final int id) {

    final ClothingDTO clothingDeleteDTO = clothingService.findById(id);

    clothingService.deleteClothing(clothingDeleteDTO);

    return new ResponseEntity<ClothingDTO>(clothingDeleteDTO, HttpStatus.OK);
  }

}
