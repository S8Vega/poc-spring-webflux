package com.thechaoscompany.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeClientController {
    WebClient client = WebClient.create("http://localhost:8080");

    @GetMapping("/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable long id) {
        Mono<Employee> employeeMono = client.get()
                .uri("/employees/{id}", id)
                .retrieve()
                .bodyToMono(Employee.class);

        employeeMono.subscribe(System.out::println);
        return employeeMono;
    }

    @GetMapping
    public Flux<Employee> getAllEmployees() {
        Flux<Employee> employeeFlux = client.get()
                .uri("/employees")
                .retrieve()
                .bodyToFlux(Employee.class);

        employeeFlux.subscribe(System.out::println);
        return employeeFlux;
    }
}
