package com.demoprojects.springwebflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

  @Test
  void testMono() {
    // Mono publisher
    Mono<String> monoString = Mono.just("testString").log();

    // subscribe to the monoString publisher
    monoString.subscribe(System.out::println);
  }

  @Test
  void testFlux() {
    // Flux publisher
    Flux<String> fluxString = Flux.just("testString1", "testString2")
        .concatWithValues("testStringBeforeException")
        .concatWith(Flux.error(new RuntimeException("Exception aaya")))
        .concatWithValues("testStringAfterException")
        .log();

    // subscribe to the fluxString publisher
    fluxString.subscribe(System.out::println);
  }

}
