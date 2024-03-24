package com.example.customerservice.repository;

import com.example.customerservice.entities.Customer;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest // pour demarer le contexte de spring data qui concernent uniquement la partie base de donee
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp(){
        System.out.println("---------------------");
        customerRepository.save(Customer.builder().firstName("Ayoub")
                .lastName("Khatouri").email("ayoub.khatouri@gmail.com").build());
        customerRepository.save(Customer.builder().firstName("Mohamed")
                .lastName("Khatouri1").email("Mohamed.khatouri1@gmail.com").build());
        customerRepository.save(Customer.builder().firstName("Ali")
                .lastName("Khatouri2").email("Ali.khatouri2@gmail.com").build());
        System.out.println("---------------------");
    }
    @Test
    public void shouldFindCustomerByEmail(){
        String givenEmail="ayoub.khatouri@gmail.com";
        Optional<Customer> result=customerRepository.findByEmail(givenEmail);
        AssertionsForClassTypes.assertThat(result).isPresent();
    }
    @Test
    public void shouldNotFindCustomerByEmail(){
        String givenEmail="xxxx.xxxxx@gmail.com";
        Optional<Customer> result=customerRepository.findByEmail(givenEmail);
        AssertionsForClassTypes.assertThat(result).isEmpty();
    }

    @Test
    public void shouldFindCustomersByFirstName(){
        String keyword="o";
        List<Customer> expected=List.of(
                Customer.builder().firstName("Ayoub")
                .lastName("Khatouri").email("ayoub.khatouri@gmail.com").build(),
                Customer.builder().firstName("Mohamed")
                        .lastName("Khatouri1").email("Mohamed.khatouri1@gmail.com").build()
        );
        List<Customer> result=customerRepository.findByFirstNameContainsIgnoreCase(keyword);
        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(result.size()).isEqualTo(expected.size());
         AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().ignoringFields("id").isEqualTo(expected);
    }
}