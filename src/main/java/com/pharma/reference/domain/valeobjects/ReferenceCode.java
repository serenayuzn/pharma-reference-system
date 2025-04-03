package com.pharma.reference.domain.valeobjects;

public record ReferenceCode(String value) {
    public ReferenceCode {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Reference code cannot be empty");
        }
        // Validasyon kuralları eklenebilir
    }
}
