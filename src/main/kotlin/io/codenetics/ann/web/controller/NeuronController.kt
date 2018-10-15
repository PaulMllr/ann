package io.codenetics.ann.web.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.servlet.http.HttpServletRequest

@RestController()
@RequestMapping("/neurons")
class NeuronController {

    @RequestMapping(path = ["/ping"])
    fun handlePing(request: HttpServletRequest): ResponseEntity<Map<String, Any>> {
        val map = HashMap<String, Any>()
        map["status"] = 200
        map["reason"] = "Got your ping"
        return ResponseEntity(map, HttpStatus.OK)
    }

}