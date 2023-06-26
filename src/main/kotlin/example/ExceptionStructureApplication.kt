package example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExceptionStructureApplication

fun main(args: Array<String>) {
    runApplication<ExceptionStructureApplication>(*args)
}
