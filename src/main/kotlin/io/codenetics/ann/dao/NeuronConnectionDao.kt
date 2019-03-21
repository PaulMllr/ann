package io.codenetics.ann.dao

import io.codenetics.ann.domain.Neuron
import io.codenetics.ann.domain.NeuronConnection

/**
 *  Created by Pavel Laktiushkin on 15.03.2019
 */
interface NeuronConnectionDao {

    fun save(connection: NeuronConnection): NeuronConnection

    fun findAllByFromNeuron(neuron: Neuron): List<NeuronConnection>

    fun findAllByFromNeuron(neuronId: String): List<NeuronConnection>
}