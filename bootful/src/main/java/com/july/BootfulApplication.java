package com.july;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import(RepositoryRestMvcConfiguration.class)
public class BootfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootfulApplication.class, args);
	}
}
