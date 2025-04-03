package com.pharma.reference.config;

import com.pharma.reference.domain.model.Company;
import com.pharma.reference.domain.repostiory.CompanyRepository;
import com.pharma.reference.domain.valeobjects.CompanyPrefix;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class StartupDataLoader {
    private final CompanyRepository companyRepository;

    public StartupDataLoader(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PostConstruct
    public void loadInitialData() {
        createCompanyIfNotExists("sanofi", "z", 150150L);
        createCompanyIfNotExists("biomarin", "z", 200000L);
        createCompanyIfNotExists("takeda", "z", 300000L);
    }

    private void createCompanyIfNotExists(String name, String prefix, long initialNumber) {
        if (companyRepository.findByName(name).isEmpty()) {
            Company company = new Company(name, new CompanyPrefix(prefix), initialNumber);
            companyRepository.save(company);
        }
    }
}