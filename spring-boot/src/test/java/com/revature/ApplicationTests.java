package com.revature;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.services.PlayerService;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private PlayerService playerService;

	@Test
	void contextLoads() {
	}

}
