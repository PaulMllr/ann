package io.codenetics.ann.graphql.entityresolver

import com.coxautodev.graphql.tools.GraphQLResolver
import io.codenetics.ann.graphql.dto.ConnectionDto
import io.codenetics.ann.graphql.dto.NeuronDto
import io.codenetics.ann.service.NeuronConnectionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 20.03.2019
 */

@Service
class NeuronResolver : GraphQLResolver<NeuronDto> {

    @Autowired
    protected lateinit var connectionService: NeuronConnectionService


    fun getDescription(neuron: NeuronDto, makeUpperCase: Boolean): String? {
        return if (neuron.description != null) {
            if (makeUpperCase) {
                neuron.description.toUpperCase()
            } else {
                neuron.description
            }
        } else {
            null
        }
    }

    fun getConnections(neuron: NeuronDto): List<ConnectionDto> {
        return connectionService.getAllConnectionsFromNeuron(neuron.id)
                .map { ConnectionDto(it.id, it.from.id, it.to.id, it.weight) }
    }

}