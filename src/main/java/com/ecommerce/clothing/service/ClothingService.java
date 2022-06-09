package com.ecommerce.clothing.service;

import com.ecommerce.clothing.dto.ClothingDTO;

public interface ClothingService {

  ClothingDTO findById(int id);

  ClothingDTO registerProducts(ClothingDTO clothing);

  ClothingDTO updateClothing(ClothingDTO clothingDTO);

  ClothingDTO deleteClothing(ClothingDTO clothingDeleteDTO);

}
