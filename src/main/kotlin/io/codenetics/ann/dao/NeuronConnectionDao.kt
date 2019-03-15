package io.codenetics.ann.dao

import io.codenetics.ann.domain.NeuronConnection

/**
 *  Created by Pavel Laktiushkin on 15.03.2019
 */
interface NeuronConnectionDao {

    fun save(connection: NeuronConnection): NeuronConnection

    fun findAllByFromNeuronId(id: String): List<NeuronConnection>
}