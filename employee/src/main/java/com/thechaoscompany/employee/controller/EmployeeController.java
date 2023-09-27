package com.thechaoscompany.employee.controller;

import com.thechaoscompany.employee.entity.EmployeeEntity;
import com.thechaoscompany.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeRepository repository;

    @GetMapping("/{id}")
    public Mono<EmployeeEntity> getEmployeeById(@PathVariable long id) {
        return Mono.just(repository.findById(id).orElseThrow());
    }

    @GetMapping
    public Flux<EmployeeEntity> getAllEmployees() {
        return Flux.fromIterable(repository.findAll());
    }
}
