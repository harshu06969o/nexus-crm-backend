package com.crm.Type.sf_mini.repository;

import com.crm.Type.sf_mini.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}

