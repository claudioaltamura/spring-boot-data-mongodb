package de.claudioaltamura.spring.boot.data.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class ProductMaterialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMaterialApplication.class, args);
	}

}
