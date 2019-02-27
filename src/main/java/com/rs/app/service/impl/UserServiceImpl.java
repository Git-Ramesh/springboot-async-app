/*
 *  com.rs.app.service.impl.UserServiceImpl.java  Feb 27, 2019
 *
 *  © Radiant Sage.
 *  Manjeera Trinity Corporate, Plot No. 912,K P H B Phase 3, Kukatpally, Hyderabad, Telangana 500072,INDIA.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of
 *  Radiant Sage . ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Radiant Sage.
 */
package com.rs.app.service.impl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.rs.app.exception.handler.RestResponseErrorHandler;
import com.rs.app.model.User;
import com.rs.app.repo.UserRepo;
import com.rs.app.service.UserService;

/**
 * @author Ramesh
 * @version 1.0
 * @since 2019-02-27 12:34:51.825
 */
@Service
public class UserServiceImpl implements UserService {
	private static final String GET_USER_URI = "http://127.0.01:4014/user/sync/%s";
	private static final String APPLICATION_JSON = "application/json";
	private RestTemplate restTemplate;
	@Autowired
	private UserRepo userRepo;

	public UserServiceImpl(RestTemplateBuilder restTemplateBuilder, RestResponseErrorHandler restResponseErrorHandler) {
		this.restTemplate = restTemplateBuilder.build();
		this.restTemplate.setErrorHandler(restResponseErrorHandler);
	}

	
	
	@Override
	@Async
	public CompletableFuture<User> getUser(long id) {
		System.out.println("getUser: Thread? " + Thread.currentThread());
//		return CompletableFuture.supplyAsync(() -> {
//			System.out.println("getUser: supplyAsync: Thread? " + Thread.currentThread());
//			final String URI = String.format(GET_USER_URI, id);
//			System.out.println("URI: " + URI);
//			HttpHeaders httpHeaders = new HttpHeaders();
//			httpHeaders.add("Content-Type", APPLICATION_JSON);
//			httpHeaders.add("Accept", APPLICATION_JSON);
//			HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
//			sleep(5, TimeUnit.SECONDS);
//			ResponseEntity<User> respE = this.restTemplate.exchange(URI, HttpMethod.GET, requestEntity, User.class);
//			System.out.println("Status Code: " + respE.getStatusCode());
//			return respE.getBody();
//		});
		final String URI = String.format(GET_USER_URI, id);
		System.out.println("URI: " + URI);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", APPLICATION_JSON);
		httpHeaders.add("Accept", APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
		sleep(5, TimeUnit.SECONDS);
		ResponseEntity<User> respE = this.restTemplate.exchange(URI, HttpMethod.GET, requestEntity, User.class);
		System.out.println("Status Code: " + respE.getStatusCode());
		return CompletableFuture.completedFuture(respE.getBody());
	}

	private static void sleep(long timeout, TimeUnit timeUnit) {
		try {
			timeUnit.sleep(timeout);
		} catch (InterruptedException e) {
			// Ignore
		}
	}

	@Override
	//@Async
	public User getUserById(long id) throws InterruptedException, ExecutionException {
		int i = 0;
		CompletableFuture<User> future = getUser(id);
		printAuthor(false);
		while (i++ < 10) {
			System.out.println("Executing other instructions.. Thread: " + Thread.currentThread());
		}
		return future.get();
	}

	@Async("workExecutor")
	public String printAuthor(boolean hasError) {
		System.out.println("printAuthor: Thread? " + Thread.currentThread());
		sleep(5, TimeUnit.SECONDS);
		if(hasError) {
			throw new RuntimeException("Failed to get author!");
		}
		return "Ramesh";
	}
	
	@Async("workExecutor")
	public String printCompany(boolean hasError) {
		System.out.println("printCompany: Thread? " + Thread.currentThread());
		sleep(5, TimeUnit.SECONDS);
		if(hasError) {
			throw new RuntimeException("Failed to get company!");
		}
		return "RadiantSage";
	}



	@Override
	@Async
	@Transactional(propagation = Propagation.REQUIRED)
	public CompletableFuture<User> saveUser(User user, boolean hasError) {
		System.out.println("saveUser: Thread? " + Thread.currentThread());
		User savedUser  = this.userRepo.save(user);
		return CompletableFuture.completedFuture(savedUser);
	}
	
}
