/*
 *  com.rs.app.controller.UserController.java  Feb 27, 2019
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
package com.rs.app.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.app.model.User;
import com.rs.app.service.UserService;

/**
 * @author Ramesh
 * @version 1.0
 * @since 2019-02-27 12:30:47.373
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public User getUser(@PathVariable long id) throws Exception {
		return this.userService.getUserById(id);
	}

	@GetMapping("/async/{id}")
	public CompletableFuture<User> getUserById(@PathVariable long id) throws Exception {
		CompletableFuture<User> future = this.userService.getUser(id);
		System.out.println("Other op..");
		System.out.println("Other op..");
		System.out.println("Other op..");
		System.out.println("Other op..");
		return future;
	}

	@GetMapping("/auth")
	public String getAuthor() {
		String printAuthor = this.userService.printAuthor(false);
		String printCompany = this.userService.printCompany(false);
		System.out.println("Wating..");
		sleep(12, TimeUnit.SECONDS);
		return printAuthor + " - " + printCompany;
	}

	private static void sleep(long timeout, TimeUnit timeUnit) {
		try {
			timeUnit.sleep(timeout);
		} catch (InterruptedException e) {
			// Ignore
		}
	}

	@PostMapping("/{error}")
	@Transactional(propagation = Propagation.REQUIRED)
	public CompletableFuture<User> saveUser(@RequestBody User newUser, @PathVariable boolean error) {
		int i = 0;
		CompletableFuture<User> saveUser = this.userService.saveUser(newUser, error);
		while (i++ < 10) {
			System.out.println("Doing other operations..");
		}
		saveUser.join();
		if(error) {
			throw new RuntimeException("Exception thrown by DEV!");
		}
		return saveUser;
	}

}
