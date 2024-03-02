package co.com.the_chaos_company.api;

import co.com.the_chaos_company.model.department.Department;
import co.com.the_chaos_company.usecase.department.DepartmentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    //    private final MyUseCase useCase;
    private final DepartmentUseCase departmentUseCase;


    @GetMapping(path = "/path")
    public Mono<String> commandName() {
//      return useCase.doAction();
        return Mono.just("Hello World");
    }


    @GetMapping(path = "/department/{id}")
    public Mono<Department> getDepartmentById(@PathVariable("id") Integer id) {
        return departmentUseCase.getDepartmentById(id);
    }

    @GetMapping(path = "/department")
    public Flux<Department> getAllDepartments() {
        return departmentUseCase.getAllDepartments();
    }
}
