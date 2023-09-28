package com.thechaoscompany.employee.controller;

import com.thechaoscompany.employee.entity.EmployeeEntity;
import com.thechaoscompany.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Log4j2
public class EmployeeController {
    private final EmployeeRepository repository;

    @GetMapping("/{id}")
    public Mono<EmployeeEntity> getEmployeeById(@PathVariable long id) {
        log.info("getEmployeeById: {}", id);
        EmployeeEntity employee = repository.findById(id).orElseThrow();
        return Mono.just(employee);
    }

    @GetMapping
    public Flux<EmployeeEntity> getAllEmployees() {
        log.info("getAllEmployees");
        List<EmployeeEntity> employees = StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return Flux.fromIterable(employees);
    }
}
