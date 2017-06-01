package com.teamscreenbiz.api.repository;

import com.teamscreenbiz.api.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long> {

  Company findByCompanyName(String companyName);

  List<Company> findAll();

  Company findById(Long id);

}
