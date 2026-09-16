package com.example.springsec.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @GetMapping("/")
    public String home() {
        return "Public home";
    }

    @PreAuthorize(
            "#username == authentication.name or hasRole('ADMIN')"
    )
    @GetMapping("/user/{username}")
    public String profileuser(@PathVariable String username) {
        return "profile user is "+ username;
    }


    @GetMapping("/profile")
    public String profile(Authentication auth) {
        return "profile " + auth.getName();
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin dashboard";
    }

    @GetMapping("/reports/monthly")
    public String reportsMonthly() {
        return "monthly reports" ;
    }

    @GetMapping("/reports/export")
    public String ReportsExpo() {
        return "reports exports" ;
    }

}
