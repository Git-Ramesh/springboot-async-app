/*
 *  com.rs.app.service.UserService.java  Feb 27, 2019
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
package com.rs.app.service;

import java.util.concurrent.CompletableFuture;

import com.rs.model.User;

/**
 * @author Ramesh
 * @version 1.0
 * @since 2019-02-27 12:34:02.651
 */
public interface UserService {
	CompletableFuture<User> getUser(long id);

	User getUserById(long id) throws Exception;

	String printAuthor(boolean hasError);
	
	String printCompany(boolean hasError);
}
