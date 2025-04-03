package com.pharma.reference.infrastructure.rest;

import com.pharma.reference.application.command.GenerateReferenceCommand;
import com.pharma.reference.application.dtos.ReferenceResponse;
import com.pharma.reference.application.service.ReferenceApplicationService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/references")
public class ReferenceController {
    private final ReferenceApplicationService applicationService;

    public ReferenceController(ReferenceApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/{companyName}")
    public ReferenceResponse generateReference(@PathVariable String companyName) {
        return applicationService.generateReference(new GenerateReferenceCommand(companyName));
    }
}