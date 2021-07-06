package com.demoprojects.springwebflux.handler;

import com.demoprojects.springwebflux.dto.Customer;
import com.demoprojects.springwebflux.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CustomerHandler {

  private final CustomerRepository repository;

  public Mono<ServerResponse> loadCustomersWithoutForcedDelay(ServerRequest request) {
    Flux<Customer> customers = repository.getCustomerStreamWithoutForcedDelay();

    return ServerResponse.ok().body(customers, Customer.class);
  }

  public Mono<ServerResponse> loadCustomersWithForcedDelay(ServerRequest request) {
    Flux<Customer> customers = repository.getCustomerStreamWithForcedDelay();

    return ServerResponse.ok()
        .contentType(MediaType.TEXT_EVENT_STREAM)
        .body(customers, Customer.class);
  }
}
