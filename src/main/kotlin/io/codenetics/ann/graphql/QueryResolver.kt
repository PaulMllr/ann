package io.codenetics.ann.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import io.codenetics.ann.graphql.dto.ConnectionDto
import io.codenetics.ann.graphql.dto.NeuronDto
import io.codenetics.ann.service.NeuronService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class QueryResolver : GraphQLQueryResolver {

    @Autowired
    lateinit var neuronService: NeuronService

    fun getNeuronsInfo(ids: List<String>) = neuronService.findNeuronsByIdIn(ids).map { NeuronDto(it.id) }

    fun getConnectionsFromNeuron(neuronId: String) = listOf(
            ConnectionDto(neuronId, "1234", 0.0),
            ConnectionDto(neuronId, "1235", 1.0))
}