package io.pivotal.pal.tracker.eurekaserver

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
open class App

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}