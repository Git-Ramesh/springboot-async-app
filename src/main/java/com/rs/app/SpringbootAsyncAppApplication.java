package com.rs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
public class SpringbootAsyncAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAsyncAppApplication.class, args);
	}

}
