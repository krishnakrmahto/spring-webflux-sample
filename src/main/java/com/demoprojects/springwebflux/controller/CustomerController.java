package com.demoprojects.springwebflux.controller;

import com.demoprojects.springwebflux.dto.Customer;
import com.demoprojects.springwebflux.service.CustomerService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

  private final CustomerService service;

  @GetMapping
  public List<Customer> getCustomers() {
    return service.loadAllCustomers();
  }

  @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Customer> getCustomersStream() {
    return service.loadAllCustomersStream();
  }
}
