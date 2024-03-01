package co.com.the_chaos_company.model.department.gateways;

import co.com.the_chaos_company.model.department.Department;
import reactor.core.publisher.Mono;

public interface DepartmentRepository {
    Mono<Department> getDepartmentById(Integer id);
}
