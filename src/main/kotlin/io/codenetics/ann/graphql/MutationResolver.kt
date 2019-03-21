package io.codenetics.ann.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import io.codenetics.ann.graphql.dto.AddNeuronRequest
import io.codenetics.ann.graphql.dto.NeuronDto
import io.codenetics.ann.service.NeuronService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class MutationResolver : GraphQLMutationResolver {

    @Autowired
    lateinit var neuronService: NeuronService

    fun addNeuron(request: AddNeuronRequest): NeuronDto {
        val neuron = neuronService.createNewNeuron(request.description)
        return NeuronDto(neuron.id, neuron.description)
    }
}