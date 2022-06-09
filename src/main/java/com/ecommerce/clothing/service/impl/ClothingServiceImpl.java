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
  public ClothingDTO deleteClothing(final ClothingDTO clothingDeleteDTO) {
    clothingRepository.deleteById(clothingDeleteDTO.getId());
    return clothingDeleteDTO;
  }

  @Override
  public ClothingDTO updateClothing(final ClothingDTO clothingDTO) {

    final Optional<Clothing> clothingToUpdate = clothingRepository.findById(clothingDTO.getId());

    final Clothing clothing = new Clothing();
    clothing.setId(clothingDTO.getId());
    clothing.setClothingName(clothingDTO.getClothingName());
    clothing.setClothingSizeId(clothingToUpdate.get().getClothingSizeId());

    clothingRepository.save(clothing);

    return clothingDTO;

  }

}
