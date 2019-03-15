package io.codenetics.ann.dao

import io.codenetics.ann.domain.Neuron
import org.springframework.stereotype.Component

@Component
class NeuronDaoMockImpl : NeuronDao {
    override fun save(neuron: Neuron) = neuron

    override fun findByIdsIn(ids: List<String>) = ids.map {
        val neuron = Neuron(mutableListOf(), mutableListOf(), { 1.0 }, { 1.0 })
        neuron.id = it
        neuron
    }
}