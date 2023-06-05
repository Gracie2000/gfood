package com.example.HappyWeb.repository;

import com.example.HappyWeb.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
