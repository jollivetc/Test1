package org.jollivetc.test1.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class ThreadRouter {
    @Bean
    public RouterFunction<ServerResponse> thread(ThreadHandler threadHandler){
        return RouterFunctions.route(RequestPredicates.GET("/threads").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), threadHandler::listAll);
    }
}
