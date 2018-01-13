package com.ddubson.versioning

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application: ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        println("Hello World!")
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}