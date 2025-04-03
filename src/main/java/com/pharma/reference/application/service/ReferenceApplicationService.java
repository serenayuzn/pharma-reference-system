package com.pharma.reference.application.service;

import com.pharma.reference.application.command.GenerateReferenceCommand;
import com.pharma.reference.application.dtos.ReferenceResponse;
import com.pharma.reference.domain.model.Company;
import com.pharma.reference.domain.repostiory.CompanyRepository;
import com.pharma.reference.domain.service.ReferenceGenerationService;
import com.pharma.reference.infrastructure.lock.CompanyLockManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReferenceApplicationService {
    private final CompanyRepository companyRepository;
    private final ReferenceGenerationService referenceService;
    private final CompanyLockManager lockManager;

    public ReferenceApplicationService(CompanyRepository companyRepository,
                                    ReferenceGenerationService referenceService,
                                    CompanyLockManager lockManager) {
        this.companyRepository = companyRepository;
        this.referenceService = referenceService;
        this.lockManager = lockManager;
    }

    @Transactional
    public ReferenceResponse generateReference(GenerateReferenceCommand command) {
        return lockManager.withLock(command.companyName(), () -> {
            Company company = companyRepository.findByName(command.companyName())
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));
            
            String referenceCode = referenceService.generateReference(company).value();
            companyRepository.save(company);
            
            return new ReferenceResponse(company.getName(), referenceCode);
        });
    }
}
