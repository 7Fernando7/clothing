package com.ecommerce.clothing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    final ClothingDTO clothingToUpdateDTO = clothingService.findById(clothing.getId());

    if (clothingToUpdateDTO == null) {
      return new ResponseEntity<ClothingDTO>(clothingToUpdateDTO, HttpStatus.NOT_FOUND);
    } else {
      final ClothingDTO clothingToUpdateDTO1 = clothingService.findById(clothing.getId());
      return new ResponseEntity<ClothingDTO>(clothingToUpdateDTO1, HttpStatus.OK);

    }
  }

  /*
   * @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
   * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<Clothing>
   * deleteClhothing(@PathVariable final int id) { final Clothing clothing =
   * clothingService.findById(id);
   *
   * if (clothing == null) {
   *
   * return new ResponseEntity<Clothing>(clothing, HttpStatus.NOT_FOUND);
   *
   * } else {
   *
   * clothingService.deleteClothing(clothing);
   *
   * return new ResponseEntity<Clothing>(clothing, HttpStatus.OK); }
   *
   * }
   */

}
