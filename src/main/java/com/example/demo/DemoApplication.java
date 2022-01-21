package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class DemoApplication {

	@Bean
	RouterFunction<ServerResponse> getAllEmployeesRoute() {
		return route(GET("/greeting/{name}"),
			req -> {
				System.out.println("Hello Phil!!");
			return ok().body(Flux.just("Hello " + req.pathVariable("name")), String.class);
			});
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
