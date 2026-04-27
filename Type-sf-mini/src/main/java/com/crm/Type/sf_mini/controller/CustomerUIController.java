package com.crm.Type.sf_mini.controller;

import com.crm.Type.sf_mini.model.Customer;
import com.crm.Type.sf_mini.service.CustomerService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerUIController {

  private final CustomerService customerService;

  public CustomerUIController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("customers", customerService.getAllCustomers(Pageable.unpaged()).getContent());
    model.addAttribute("customer", Customer.builder().status(Customer.Status.LEAD).build());
    return "index";
  }

  @PostMapping("/ui/customers/add")
  public String addCustomer(@ModelAttribute Customer customer) {
    customerService.createCustomer(customer);
    return "redirect:/";
  }

  @GetMapping("/ui/customers/delete/{id}")
  public String deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
    return "redirect:/";
  }
}

