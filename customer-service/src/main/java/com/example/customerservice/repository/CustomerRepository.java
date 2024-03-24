package com.example.customerservice.repository;

import com.example.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Optional<Customer> findByEmail(String email);
    public List<Customer> findByFirstNameContainsIgnoreCase(String keyword);
}
