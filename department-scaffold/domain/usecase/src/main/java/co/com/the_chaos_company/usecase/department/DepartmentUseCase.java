package co.com.the_chaos_company.usecase.department;

import co.com.the_chaos_company.model.department.Department;
import co.com.the_chaos_company.model.department.gateways.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import reactor.core.publisher.Mono;

@Log
@RequiredArgsConstructor
public class DepartmentUseCase {
    private final DepartmentRepository departmentRepository;

    public Mono<Department> getDepartmentById(Integer id) {
        Mono<Department> department = departmentRepository.getDepartmentById(id);
        department.subscribe(department1 -> log.info("Department: " + department1.toString()));
        return department;
    }
}
