package com.ecommerce.clothing.service;

import java.util.Optional;

import com.ecommerce.clothing.dto.ClothingDTO;
import com.ecommerce.clothing.model.Clothing;

public interface ClothingService {

  ClothingDTO findById(int id);

  ClothingDTO registerProducts(ClothingDTO clothing);

  Optional<Clothing> updateClothing(ClothingDTO product);

}
