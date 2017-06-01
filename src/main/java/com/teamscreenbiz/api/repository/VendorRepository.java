package com.teamscreenbiz.api.repository;


import com.teamscreenbiz.api.model.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "Hotels" , collectionResourceRel = "Hotels")
public interface VendorRepository extends CrudRepository<Vendor,Long> {
  Vendor findById(Long id);
}
