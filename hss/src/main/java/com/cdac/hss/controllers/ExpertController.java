package com.cdac.hss.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expert")
public class ExpertController {

    @GetMapping("/dashboard")
    public String getExpertDashboard() {
        return "Expert Dashboard";
    }
}
