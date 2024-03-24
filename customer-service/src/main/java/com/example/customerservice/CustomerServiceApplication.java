package com.example.customerservice;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	@Profile("!test") // so in when we are in the test profile ir will not create this bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder().firstName("Ayoub")
					.lastName("Khatouri").email("ayoub.khatouri@gmail.com").build());
			customerRepository.save(Customer.builder().firstName("Mohamed")
					.lastName("Khatouri1").email("Mohamed.khatouri1@gmail.com").build());
			customerRepository.save(Customer.builder().firstName("Ali")
					.lastName("Khatouri2").email("Ali.khatouri2@gmail.com").build());
		};
	}

}
