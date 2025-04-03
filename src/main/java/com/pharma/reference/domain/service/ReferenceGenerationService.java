package com.pharma.reference.domain.service;

import com.pharma.reference.domain.model.Company;
import com.pharma.reference.domain.valeobjects.ReferenceCode;

public interface ReferenceGenerationService {
    ReferenceCode generateReference(Company company);
}