package com.microservice.discovery_server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Disabled;

@SpringBootTest
@Disabled("Disable Eureka server context loading for tests")
class DiscoveryServerApplicationTests {

	@Test
	void contextLoads() {
	}

}
