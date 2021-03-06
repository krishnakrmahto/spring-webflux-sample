package com.demoprojects.springwebflux.service;

import com.demoprojects.springwebflux.dto.Customer;
import com.demoprojects.springwebflux.repository.CustomerRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

  private final CustomerRepository repository;

  public List<Customer> loadAllCustomers() {
    long startTimeMs = System.currentTimeMillis();
    List<Customer> customers = repository.getCustomersWithForcedDelay();
    long endTimeMs = System.currentTimeMillis();
    log.info("Total time taken to fetch all customers: {}", endTimeMs - startTimeMs);
    return customers;
  }

  public Flux<Customer> loadAllCustomersStream() {
    long startTimeMs = System.currentTimeMillis();
    Flux<Customer> customers = repository.getCustomerStreamWithForcedDelay();
    long endTimeMs = System.currentTimeMillis();
    log.info("Total time taken to fetch all customers: {}", endTimeMs - startTimeMs);
    return customers;
  }
}
