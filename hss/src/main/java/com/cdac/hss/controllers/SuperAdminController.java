package com.cdac.hss.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/super_admin")
public class SuperAdminController {

    @GetMapping("/dashboard")
    public String getSuperAdminDashboard() {
        return "Super Admin Dashboard";
    }
}
