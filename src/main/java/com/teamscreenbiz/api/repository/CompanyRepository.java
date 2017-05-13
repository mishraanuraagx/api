package com.teamscreenbiz.api.repository;

import com.teamscreenbiz.api.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CompanyRepository extends JpaRepository<Company,Long> {

  Company findByCompanyName(String companyName);

  List<Company> findAll();

  Company findById(Long id);
}
