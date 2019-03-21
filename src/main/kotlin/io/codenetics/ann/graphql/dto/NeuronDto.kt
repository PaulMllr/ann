package io.codenetics.ann.graphql.dto

/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
data class NeuronDto(
        val id: String,
        val description: String?) {

    fun getDescription(makeUpperCase: Boolean): String? {
        return if (description != null) {
            if (makeUpperCase) {
                description.toUpperCase()
            } else {
                description
            }
        } else {
            null
        }
    }
}