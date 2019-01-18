package com.ddubson.versioning

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@Configuration
class Router {
    @Bean
    fun routes(): RouterFunction<ServerResponse> = router {
        GET("/") {
            ok().body(Mono.just("Hello World!"))
        }
    }
}