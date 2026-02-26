package com.example.resourceserver;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/test")
    public String hello(Authentication authentication) {
        return authentication.getName();
    }

    @PreAuthorize("hasAuthority('SCOPE_profile')")
    @GetMapping("/test-scope-profile")
    public String helloProfile() {
        return "'profile' scope present";
    }
}
