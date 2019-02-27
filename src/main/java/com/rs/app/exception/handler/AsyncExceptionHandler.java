/*
 *  com.rs.app.exception.handler.AsyncExceptionHandler.java  Feb 27, 2019
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
package com.rs.app.exception.handler;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

/**
 * @author Ramesh
 * @version 1.0
 * @since 2019-02-27 14:54:16.849
 */
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... params) {
		System.out.println("Exception Message: " + ex.getMessage());
		System.out.println("Method Name: " + method.getName());
		for (Object param : params) {
			System.out.println("Param - " + param);
		}
	}

}
