package com.actiatrip.coreservices;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = {"classpath:application-test.properties"})
class CoreservicesApplicationTests {

	@Test
	void contextLoads() {
	}

}
