package co.com.the_chaos_company.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(GET("/router/usecase/path"), handler::listenGETUseCase)
                .andRoute(POST("/router/usecase/otherpath"), handler::listenPOSTUseCase)
                .and(route(GET("/router/otherusercase/path"), handler::listenGETOtherUseCase))
                .and(route(GET("/router/department/{id}"), handler::getDepartmentById))
                .and(route(GET("/router/department"), handler::getAllDepartments));
    }
}
