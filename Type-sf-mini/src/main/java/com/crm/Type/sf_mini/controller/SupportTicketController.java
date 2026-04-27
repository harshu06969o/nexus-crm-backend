package com.crm.Type.sf_mini.controller;

import com.crm.Type.sf_mini.model.SupportTicket;
import com.crm.Type.sf_mini.service.SupportTicketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
public class SupportTicketController {

  private final SupportTicketService supportTicketService;

  public SupportTicketController(SupportTicketService supportTicketService) {
    this.supportTicketService = supportTicketService;
  }

  @PostMapping("/customer/{customerId}")
  public ResponseEntity<SupportTicket> createForCustomer(
      @PathVariable Long customerId, @Valid @RequestBody SupportTicket ticket) {
    SupportTicket created = supportTicketService.createTicketForCustomer(customerId, ticket);
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
  }
}

