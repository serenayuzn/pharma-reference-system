package com.pharma.reference.config;

import com.pharma.reference.domain.repostiory.CompanyRepository;
import com.pharma.reference.infrastructure.lock.CompanyLockManager;
import com.pharma.reference.infrastructure.lock.impl.DefaultCompanyLockManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CompanyLockManager companyLockManager() {
        return new DefaultCompanyLockManager();
    }

    @Bean
    public StartupDataLoader startupDataLoader(CompanyRepository companyRepository) {
        return new StartupDataLoader(companyRepository);
    }
}
