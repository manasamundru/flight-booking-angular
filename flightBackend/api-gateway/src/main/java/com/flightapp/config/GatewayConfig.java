package com.flightapp.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.flightapp.filter.JwtAuthFilter;

@Configuration
public class GatewayConfig {

    private final JwtAuthFilter jwtAuthFilter;

    public GatewayConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("auth-service", r -> r
                .path("/api/auth/**")
                .uri("lb://AUTH-SERVICE")
            )
            .route("flight-service", r -> r
                .path("/api/flights/**")
                .filters(f -> f.filter(jwtAuthFilter.apply(new JwtAuthFilter.Config())))
                .uri("lb://FLIGHT-SERVICE")
            )

            .build();
    }
}




