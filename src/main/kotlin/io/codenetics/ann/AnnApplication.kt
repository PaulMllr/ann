package io.codenetics.ann

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["io.codenetics.ann"])
class AnnApplication

fun main(args: Array<String>) {
    runApplication<AnnApplication>(*args)
}
