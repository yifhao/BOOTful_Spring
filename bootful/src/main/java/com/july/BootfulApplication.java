package com.july;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BootfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootfulApplication.class, args);
	}
}
