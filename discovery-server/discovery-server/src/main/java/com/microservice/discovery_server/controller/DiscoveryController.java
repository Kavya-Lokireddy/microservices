package com.microservice.discovery_server.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryController {

    @GetMapping("/status")
    public String status() {
        return "Discovery Server is running";
    }
}
