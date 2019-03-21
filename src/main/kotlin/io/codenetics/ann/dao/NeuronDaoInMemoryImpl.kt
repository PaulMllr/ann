package io.codenetics.ann.dao

import io.codenetics.ann.domain.Neuron
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
@Qualifier("InMemory")
class NeuronDaoInMemoryImpl : NeuronDao {
    private val log = LoggerFactory.getLogger(this::class.java)

    private val data = HashSet<Neuron>()

    override fun save(neuron: Neuron): Neuron {
        data.add(neuron)
        log.info("Saved a new neuron: ${neuron.id}; description: ${neuron.description}")
        return neuron
    }

    override fun findAll(): List<Neuron> = data.toList()

    override fun findByIdsIn(ids: List<String>) = data.filter { ids.contains(it.id) }

}