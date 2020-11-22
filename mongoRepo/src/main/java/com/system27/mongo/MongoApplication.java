package com.system27.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.system27.mongo.Model.Address;
import com.system27.mongo.Model.Person;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.system27")
public class MongoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

	@Bean
	public MongoClient mongoClient() {
		ConnectionString connectionString = new ConnectionString("mongodb://localhost:59904/test");
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(), "test");
	}

	@Autowired
	MongoTemplate mt;

	@Override
	public void run(String... args) {
		Person person = new Person();
		Address address = new Address();
		address.setStreetName("Autumn Woods Way");
		address.setCity("Fairfax");
		address.setZipCode(22033);
		address.setState("Virginia");
		person.setAge(26);
		LocalDate ld = LocalDate.of(1994,10,10);
		person.setBirthday(ld);
		person.setAddress(address);
		person.setName("Bob");
		person.setSalary(7000);
		mt.save(person);
	}
}
