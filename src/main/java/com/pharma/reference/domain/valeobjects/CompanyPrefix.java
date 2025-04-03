package com.pharma.reference.domain.valeobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record CompanyPrefix(String value) {
    public CompanyPrefix {
        if (value == null || value.length() != 1) {
            throw new IllegalArgumentException("Company prefix must be a single character");
        }
    }
}
