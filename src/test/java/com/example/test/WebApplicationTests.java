package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ConfigurationProperties(prefix = "test")
class WebApplicationTests {

	@Test
	void contextLoads() {
	}

}
