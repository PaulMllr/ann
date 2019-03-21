package io.codenetics.ann.dao

import io.codenetics.ann.domain.Neuron
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
@Qualifier("Mock")
class NeuronDaoMockImpl : NeuronDao {

    override fun save(neuron: Neuron) = neuron

    override fun findAll() = emptyList<Neuron>()

    override fun findByIdsIn(ids: List<String>) = ids.map {
        val neuron = Neuron( { 1.0 }, { 1.0 })
        neuron.id = it
        neuron
    }
}