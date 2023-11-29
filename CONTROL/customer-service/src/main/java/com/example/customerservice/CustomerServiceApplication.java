package com.example.customerservice;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repositories.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder().name("othman abid").email("othmanabid@gmail.com").build(),
					Customer.builder().name("anas anasri").email("anas@gmail.com").build(),
					Customer.builder().name("cristiano ronaldo").email("cristianoronaldo@gmail.com").build()
			));
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
