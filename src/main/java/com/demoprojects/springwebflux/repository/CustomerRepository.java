package com.demoprojects.springwebflux.repository;

import com.demoprojects.springwebflux.dto.Customer;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class CustomerRepository {

  public List<Customer> getCustomers() {
    return IntStream.rangeClosed(1, 10)
        .peek(i -> log.info("Current customer index: {}", i))
        .peek(i -> sleepThreadForDelay())
        .mapToObj(i -> new Customer(i, "customer" + 1))
        .collect(Collectors.toList());
  }

  public Flux<Customer> getCustomerStream() {
    return Flux.range(1, 10)
        .delayElements(Duration.ofSeconds(1))
        .doOnNext(i -> log.info("Current customer index: {}", i))
        .map(i -> new Customer(i, "customer" + i));

  }

  private void sleepThreadForDelay() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      log.error("error in Thread.sleep");
    }
  }
}
