package org.jollivetc.test1.authors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class AuthorRouter {

    @Bean
    public RouterFunction<ServerResponse> route(AuthorHandler authorHandler){
        return RouterFunctions.route(RequestPredicates.GET("/authors").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), authorHandler::findAll);
    }

    @Bean
    public RouterFunction<ServerResponse> routeById(AuthorHandler authorHandler){
        return RouterFunctions.route(RequestPredicates.GET("/authors/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), authorHandler::findById);
    }
}
