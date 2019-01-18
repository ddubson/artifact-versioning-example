package com.ddubson.versioning

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application: ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        println("Hello World!")
        println("Another thing!")
        println("Woah!")
        println("Gahh!")
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}