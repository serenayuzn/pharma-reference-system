package com.pharma.reference.domain.repostiory;

import com.pharma.reference.domain.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    Optional<Company> findByName(String name);
    Company save(Company company);
    List<Company> findAll();
}
