package com.pharma.reference.infrastructure.persistence;

import com.pharma.reference.domain.model.Company;
import com.pharma.reference.domain.repostiory.CompanyRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCompanyRepository extends JpaRepository<Company, Long>, CompanyRepository {
    @Override
    default Optional<Company> findByName(String name) {
        return findOneByName(name);
    }

    Optional<Company> findOneByName(String name);
}