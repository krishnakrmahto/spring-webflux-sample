package com.demoprojects.springwebflux.router;

import com.demoprojects.springwebflux.handler.CustomerHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@AllArgsConstructor
public class RouterConfig {

  private final CustomerHandler customerHandler;
  @Bean
  public RouterFunction<ServerResponse> routerFunction() {
    return RouterFunctions.route()
        .GET("/routes/customers", customerHandler::loadCustomersWithoutForcedDelay)
        .GET("/routes/customers/stream", customerHandler::loadCustomersWithForcedDelay)
        .build();
  }
}
