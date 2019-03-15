package io.codenetics.ann.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import io.codenetics.ann.graphql.dto.ConnectionDto
import io.codenetics.ann.graphql.dto.NeuronDto
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class QueryResolver : GraphQLQueryResolver {

    fun getNeuronsInfo(ids: List<String>): List<NeuronDto> {
        return ids.map { NeuronDto(it) }
    }

    fun getConnectionsFromNeuron(neuronId: String): List<ConnectionDto> {
        return listOf(ConnectionDto(neuronId, "1234", 0.0), ConnectionDto(neuronId, "1235", 1.0))
    }
}