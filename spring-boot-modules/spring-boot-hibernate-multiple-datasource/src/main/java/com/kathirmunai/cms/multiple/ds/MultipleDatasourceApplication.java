package com.kathirmunai.cms.multiple.ds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MultipleDatasourceApplication {

	public static void main(String[] args) {	
		SpringApplication.run(MultipleDatasourceApplication.class, args);
	}

}
