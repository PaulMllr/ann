package io.codenetics.ann

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("io.codenetics.ann")
class AnnApplication

fun main(args: Array<String>) {
    runApplication<AnnApplication>(*args)
}
