package com.crm.Type.sf_mini.service;

import com.crm.Type.sf_mini.model.Customer;
import com.crm.Type.sf_mini.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Transactional(readOnly = true)
  public Page<Customer> getAllCustomers(Pageable pageable) {
    return customerRepository.findAll(pageable);
  }

  @Transactional(readOnly = true)
  public Customer getCustomerById(Long id) {
    return customerRepository
        .findById(id)
        .orElseThrow(() -> new CustomerNotFoundException("Customer not found: " + id));
  }

  @Transactional
  public Customer createCustomer(Customer customer) {
    customer.setId(null);
    return customerRepository.save(customer);
  }

  @Transactional
  public Customer updateCustomer(Long id, Customer updated) {
    Customer existing = getCustomerById(id);
    existing.setName(updated.getName());
    existing.setEmail(updated.getEmail());
    existing.setPhone(updated.getPhone());
    existing.setStatus(updated.getStatus());
    return customerRepository.save(existing);
  }

  @Transactional
  public void deleteCustomer(Long id) {
    if (!customerRepository.existsById(id)) {
      throw new CustomerNotFoundException("Customer not found: " + id);
    }
    customerRepository.deleteById(id);
  }

  public static class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
      super(message);
    }
  }
}

