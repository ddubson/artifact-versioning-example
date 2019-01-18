package com.ddubson.versioning

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.context.ApplicationContext
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
internal class RouterTest {
    @LocalServerPort
    var port = 0

    @Autowired
    lateinit var applicationContext: ApplicationContext

    lateinit var webTestClient: WebTestClient

    @BeforeEach
    fun setup() {
        this.webTestClient = WebTestClient.bindToApplicationContext(applicationContext)
                .configureClient()
                .baseUrl("http://localhost:$port")
                .build()
    }

    @Test
    fun getIndex_onRequest_returnsOk() {
        this.webTestClient.get().uri("/").exchange().expectStatus()
                .isOk.expectBody(String::class.java).isEqualTo<Nothing>("Hello World!")
    }
}