package io.codenetics.ann.service

import io.codenetics.ann.dao.NeuronDao
import io.codenetics.ann.domain.Neuron
import io.codenetics.ann.domain.NeuronConnection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 15.03.2019
 */

@Service
class NeuronService {

    @Autowired
    @Qualifier("InMemory")
    protected lateinit var neuronDao: NeuronDao

    @Autowired
    protected lateinit var connectionService: NeuronConnectionService

    fun createNewNeuron(description: String?, connectionIds: List<String>?): Neuron {
        val neuron = neuronDao.save(
                Neuron(description, { 1.0 }, { 1.0 }))

        val mockToNeuron = Neuron({ 1.0 }, { 1.0 })
        connectionIds?.forEach { connectionService.save(NeuronConnection(neuron, mockToNeuron, 0.75)) }

        return neuronDao.save(neuron)
    }

    fun saveNeuron(neuron: Neuron): Neuron {
        return neuronDao.save(neuron)
    }

    fun findNeuronById(id: String) = neuronDao.findByIdsIn(listOf(id)).firstOrNull()

    fun findAllNeurons() = neuronDao.findAll()

    fun findNeuronsByIdIn(ids: List<String>) = neuronDao.findByIdsIn(ids)


}