package com.teamscreenbiz.api.repository;

import com.teamscreenbiz.api.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProductRepository extends CrudRepository<Product,Long> {
  Product findByName(String name);
  Product findById(Long id);
  List<Product> findAll();
}
