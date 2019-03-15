package io.codenetics.ann.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import io.codenetics.ann.graphql.dto.NeuronDto
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class MutationResolver : GraphQLMutationResolver {

    fun addNeuron(id: String): NeuronDto {
        return NeuronDto(id)
    }
}