package org.jollivetc.test1.notes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class NoteRouter {

    @Bean
    public RouterFunction<ServerResponse> notes(NoteHandler noteHandler){
        return RouterFunctions.route(RequestPredicates.GET("notes").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), noteHandler::findAll);
    }
}
