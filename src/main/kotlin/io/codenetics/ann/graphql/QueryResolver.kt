package io.codenetics.ann.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import io.codenetics.ann.graphql.dto.ConnectionDto
import io.codenetics.ann.graphql.dto.NeuronDto
import io.codenetics.ann.service.NeuronConnectionService
import io.codenetics.ann.service.NeuronService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class QueryResolver : GraphQLQueryResolver {

    @Autowired
    protected lateinit var neuronService: NeuronService

    @Autowired
    protected lateinit var connectionService: NeuronConnectionService


    fun getNeuronsInfo(ids: List<String>?): List<NeuronDto> {
        val neurons = if (ids != null) {
            neuronService.findNeuronsByIdIn(ids)
        } else {
            neuronService.findAllNeurons()
        }

        return neurons.map { n ->
            NeuronDto(
                    n.id,
                    n.description)
        }
    }

    fun getConnectionsFromNeuron(neuronId: String): List<ConnectionDto> {
        val neuron = neuronService.findNeuronById(neuronId)
        // TODO: check if the neuron is null a throw an exception
        return if (neuron != null) {
            connectionService.getAllConnectionsFromNeuron(neuron)
                    .map { ConnectionDto(it.id, it.from.id, it.to.id, it.weight) }
        } else {
            emptyList()
        }
    }
}