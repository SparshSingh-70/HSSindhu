package com.cdac.hss.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/verifier")
public class VerifierController {

    @GetMapping("/dashboard")
    public String getVerifierDashboard() {
        return "Verifier Dashboard";
    }
}
