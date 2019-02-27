package com.rs.app.service.impl;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.rs.app.AsyncConfig;
import com.rs.app.SpringbootAsyncAppApplication;
import com.rs.app.service.UserService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { SpringbootAsyncAppApplication.class,
		AsyncConfig.class }, loader = AnnotationConfigContextLoader.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserServiceTests {
	@Autowired
	private UserService userService;

	@Test
	public void printAuthorTest() {
		System.out.println("Start - printAuthorTest: " + Thread.currentThread());
		this.userService.printAuthor(false);
		System.out.println("End - printAuthorTest: " + Thread.currentThread());
		
		sleep(3, TimeUnit.SECONDS);
	}
	
	private static void sleep(long timeout, TimeUnit timeUnit) {
		try {
			timeUnit.sleep(timeout);
		} catch (InterruptedException e) {
			// Ignore
		}
	}
}
 