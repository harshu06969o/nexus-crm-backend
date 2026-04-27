package com.crm.Type.sf_mini.controller;

import com.crm.Type.sf_mini.model.Customer;
import com.crm.Type.sf_mini.service.CustomerService;
import com.crm.Type.sf_mini.service.CustomerService.CustomerNotFoundException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  public ResponseEntity<Page<Customer>> getAllCustomers(Pageable pageable) {
    return ResponseEntity.ok(customerService.getAllCustomers(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Customer> getById(@PathVariable Long id) {
    return ResponseEntity.ok(customerService.getCustomerById(id));
  }

  @PostMapping
  public ResponseEntity<Customer> create(@Valid @RequestBody Customer customer) {
    Customer created = customerService.createCustomer(customer);
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Customer> update(
      @PathVariable Long id, @Valid @RequestBody Customer updated) {
    return ResponseEntity.ok(customerService.updateCustomer(id, updated));
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    customerService.deleteCustomer(id);
    return ResponseEntity.noContent().build();
  }

  @ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<String> handleNotFound(CustomerNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }
}

