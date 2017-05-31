package com.teamscreenbiz.api.repository;


import com.teamscreenbiz.api.model.MobileModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(exported = false)
public interface MobileModelRepository extends CrudRepository<MobileModel,Long> {
  MobileModel findByName(String name);

  List<MobileModel> findAll();

  MobileModel findById(Long id);

}
