package com.pharma.reference.domain.service.impl;

import com.pharma.reference.domain.model.Company;
import com.pharma.reference.domain.service.ReferenceGenerationService;
import com.pharma.reference.domain.valeobjects.ReferenceCode;

import org.springframework.stereotype.Service;

@Service
public class SequentialReferenceService implements ReferenceGenerationService {
    @Override
    public ReferenceCode generateReference(Company company) {
        return new ReferenceCode(company.generateNextReference());
    }
}
