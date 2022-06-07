package com.ecommerce.clothing.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.clothing.dto.ClothingDTO;
import com.ecommerce.clothing.dto.EnumClothingSizes;
import com.ecommerce.clothing.model.Clothing;
import com.ecommerce.clothing.repository.ClothingRepository;
import com.ecommerce.clothing.service.ClothingService;

@Service
public class ClothingServiceImpl implements ClothingService {

  @Autowired
  private ClothingRepository clothingRepository;

  @Override
  public ClothingDTO findById(final int id) {

    final Optional<Clothing> clothing = clothingRepository.findById(id);

    final ClothingDTO clothingDTO = new ClothingDTO();
    clothingDTO.setId(clothing.get().getId());
    clothingDTO.setClothingName(clothing.get().getClothingName());
    clothingDTO.setClothingSizeDescription(
      EnumClothingSizes.getDescriptionByCode(clothing.get().getClothingSizeId()).getDescription());

    return clothingDTO;
  }

  @Override
  public ClothingDTO registerProducts(final ClothingDTO clothingDTO) {

    final Clothing clothing = new Clothing();
    clothing.setClothingName(clothingDTO.getClothingName());
    clothing.setClothingSizeId(
      EnumClothingSizes.getCodeByDescription(clothingDTO.getClothingSizeDescription()).getCode());

    final Clothing newClothing = clothingRepository.save(clothing);
    clothingDTO.setId(newClothing.getId());

    return clothingDTO;
  }

  @Override
  public Optional<Clothing> updateClothing(final ClothingDTO product) {

    final Optional<Clothing> clothingToUpdate = clothingRepository.findById(product.getId());

    clothingToUpdate.get().setClothingName(product.getClothingName());

    clothingRepository.save(clothingToUpdate.get());

    return clothingToUpdate;

  }

  /*
   * @Override public Clothing deleteClothing(final Clothing clothing) {
   * clothingRepository.delete(clothing); return clothing; }
   */

}
