package com.pharma.reference.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CompanyResponse(
    @JsonProperty("name") 
    String name,
    
    @JsonProperty("prefix") 
    String prefix
) {
    // Static factory method if needed
    public static CompanyResponse fromDomain(String name, String prefix) {
        return new CompanyResponse(name, prefix);
    }
}
