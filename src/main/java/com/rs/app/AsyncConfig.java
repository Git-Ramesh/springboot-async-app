/*
 *  com.rs.app.AsyncConfig.java  Feb 27, 2019
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
package com.rs.app;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.rs.app.exception.handler.AsyncExceptionHandler;

/**
 * @author <>
 * @version 1.0
 * @since 2019-02-27 14:49:57.416
 */
@Configuration
@ComponentScan(basePackages = { "com.rs.app.service", "com.rs.app.service.impl" })
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
	/*
	 * @Async has two limitations: 
	 * it must be applied to public methods only
	 * self-invocation – calling the async method from within the same class – won’t
	 * work
	 */
	@Bean(name = "workExecutor")
	public Executor workExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setThreadNamePrefix("WorkExecutor-");
		threadPoolTaskExecutor.setCorePoolSize(3);
		threadPoolTaskExecutor.setMaxPoolSize(3);
		threadPoolTaskExecutor.setQueueCapacity(600);
		threadPoolTaskExecutor.afterPropertiesSet();
		return threadPoolTaskExecutor;
	}

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setThreadNamePrefix("Async-");
		threadPoolTaskExecutor.setCorePoolSize(3);
		threadPoolTaskExecutor.setMaxPoolSize(3);
		threadPoolTaskExecutor.setQueueCapacity(600);
		threadPoolTaskExecutor.afterPropertiesSet();
		return threadPoolTaskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new AsyncExceptionHandler();
	}
}
