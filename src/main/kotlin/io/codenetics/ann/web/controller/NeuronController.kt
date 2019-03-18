package io.codenetics.ann.web.controller

import io.codenetics.ann.service.NeuronService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.servlet.http.HttpServletRequest

@RestController()
@RequestMapping("/neurons")
class NeuronController {

    @Autowired
    lateinit var neuronService: NeuronService


    @GetMapping
    fun getAllNeurons(request: HttpServletRequest): ResponseEntity<Map<String, Any>> {
        val map = HashMap<String, Any>()
        // Just a mock implementation since we have no persistence unit at the moment
        map["neurons"] = listOf("neuron1", "neuron2")
        return ResponseEntity(map, HttpStatus.OK)
    }

}