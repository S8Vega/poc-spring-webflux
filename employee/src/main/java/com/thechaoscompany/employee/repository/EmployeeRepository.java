package com.thechaoscompany.employee.repository;

import com.thechaoscompany.employee.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
}
