package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route("USERSERVICE", r-> r.path("/user/**" , "/public/**" , "/email/**")
						.filters(f -> f.stripPrefix(0))
						.uri("lb://USERSERVICE"))
				.route("PESTSERVICE", r-> r.path("/pests/**")
						.filters(f -> f.stripPrefix(0))
						.uri("lb://PESTSERVICE"))
				.route("BOOKINGSERVICE", r-> r.path("/booking/**")
						.filters(f -> f.stripPrefix(0))
						.uri("lb://BOOKINGSERVICE"))
				.build();
	}

}
