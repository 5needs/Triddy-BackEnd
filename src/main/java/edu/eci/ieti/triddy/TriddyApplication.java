package edu.eci.ieti.triddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class TriddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriddyApplication.class, args);
	}

}
