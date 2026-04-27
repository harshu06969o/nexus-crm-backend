package com.crm.Type.sf_mini.service;

import com.crm.Type.sf_mini.model.Customer;
import com.crm.Type.sf_mini.model.SupportTicket;
import com.crm.Type.sf_mini.repository.CustomerRepository;
import com.crm.Type.sf_mini.repository.SupportTicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupportTicketService {

  private final CustomerRepository customerRepository;
  private final SupportTicketRepository supportTicketRepository;

  public SupportTicketService(
      CustomerRepository customerRepository, SupportTicketRepository supportTicketRepository) {
    this.customerRepository = customerRepository;
    this.supportTicketRepository = supportTicketRepository;
  }

  @Transactional
  public SupportTicket createTicketForCustomer(Long customerId, SupportTicket ticket) {
    Customer customer =
        customerRepository
            .findById(customerId)
            .orElseThrow(
                () -> new CustomerService.CustomerNotFoundException("Customer not found: " + customerId));

    if ("CHURNED".equalsIgnoreCase(String.valueOf(customer.getStatus()))) {
      throw new IllegalStateException(
          "Business Rule Violation: Cannot create a support ticket for a CHURNED customer.");
    }

    ticket.setId(null);
    ticket.setCustomer(customer);
    return supportTicketRepository.save(ticket);
  }
}

