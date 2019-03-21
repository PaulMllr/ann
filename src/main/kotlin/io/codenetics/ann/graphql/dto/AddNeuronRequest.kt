package io.codenetics.ann.graphql.dto

/**
 *  Created by Pavel Laktiushkin on 20.03.2019
 */
data class AddNeuronRequest(
        val description: String?,
        val connections: List<String>?)