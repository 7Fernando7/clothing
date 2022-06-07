package com.ecommerce.clothing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.clothing.model.Clothing;

public interface ClothingRepository extends JpaRepository<Clothing, Integer> {

}
