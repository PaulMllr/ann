package io.codenetics.ann.dao

import io.codenetics.ann.domain.Neuron

/**
 *  Created by Pavel Laktiushkin on 15.03.2019
 */
interface NeuronDao {

    fun save(neuron: Neuron): Neuron

    fun findByIdsIn(ids: List<String>): List<Neuron>
}