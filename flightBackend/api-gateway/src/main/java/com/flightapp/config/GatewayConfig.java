package com.flightapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.flightapp.filter.JwtAuthFilter;

@Configuration
public class GatewayConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    public RouteLocator configure(RouteLocatorBuilder builder) {
        return builder.routes()

            .route("auth-service", r -> r.path("/api/auth/**")
                    .uri("lb://auth-service"))
            .route("flight-service", r -> r.path("/api/flights/**")
                    .uri("lb://flight-service"))
            .build();
    }
}



