package com.trilogyed.glossaryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GlossaryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlossaryServiceApplication.class, args);
	}

}
