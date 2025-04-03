package com.pharma.reference.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReferenceResponse(
    @JsonProperty("companyName") 
    String companyName,
    
    @JsonProperty("referenceCode") 
    String referenceCode
) {}
