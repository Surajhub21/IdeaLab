package com.pestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@SpringBootApplication
public class PestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PestServiceApplication.class, args);
	}

}
