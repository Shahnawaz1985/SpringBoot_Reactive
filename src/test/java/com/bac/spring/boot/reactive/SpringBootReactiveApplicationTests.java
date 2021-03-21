package com.bac.spring.boot.reactive;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 
 * @author Shahnawaz
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {com.eric.spring.boot.reactive.test.config.ApplicationConfiguration.class})
public class SpringBootReactiveApplicationTests {

	@Test
	public void contextLoads() {

	}

}
