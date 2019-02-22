 package com.cts.tpin.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.cts.*"})
@EntityScan({"com.cts.*"})
@EnableJpaRepositories("com.cts.tpin.repository")
public class TpinApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpinApplication.class, args);
	}

}

