package com.demoprojects.springwebflux.controller;

import com.demoprojects.springwebflux.dto.Customer;
import com.demoprojects.springwebflux.service.CustomerService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

  private final CustomerService service;

  @GetMapping
  public List<Customer> getCustomers() {
    return service.loadAllCustomers();
  }
}
