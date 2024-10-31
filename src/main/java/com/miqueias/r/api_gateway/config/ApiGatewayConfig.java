package com.miqueias.r.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/usuario-servico/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://usuario-servico"))
                .route(p -> p.path("/autenticacao-servico/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://autenticacao-servico"))
                .build();
    }
}
