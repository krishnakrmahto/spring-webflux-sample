package com.demoprojects.springwebflux.repository;

import com.demoprojects.springwebflux.dto.Customer;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerRepository {

  public List<Customer> getCustomers() {
    return IntStream.rangeClosed(1, 50)
        .peek(i -> log.info("Current customer index: {}", i))
        .mapToObj(i -> new Customer(i, "customer" + 1))
        .collect(Collectors.toList());
  }
}
