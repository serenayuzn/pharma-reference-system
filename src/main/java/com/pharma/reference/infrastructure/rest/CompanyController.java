package com.pharma.reference.infrastructure.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.reference.application.dtos.CompanyResponse;
import com.pharma.reference.domain.repostiory.CompanyRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<CompanyResponse> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(company -> new CompanyResponse(
                    company.getName(),
                    company.getPrefix().value())) // Assuming prefix is a value object
                .collect(Collectors.toList());
    }
}