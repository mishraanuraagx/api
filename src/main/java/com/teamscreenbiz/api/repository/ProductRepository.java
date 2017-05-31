package com.teamscreenbiz.api.repository;

import com.teamscreenbiz.api.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface ProductRepository extends CrudRepository<Product,Long> {
  Product findByName(String name);
  Product findById(Long id);
  List<Product> findAll();
}
