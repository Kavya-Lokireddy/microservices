package com.microservice.discovery_server.service;

import org.springframework.stereotype.Service;

@Service
public class DiscoveryService {

    public String getServerInfo() {
        return "Eureka Discovery Server";
    }
}
