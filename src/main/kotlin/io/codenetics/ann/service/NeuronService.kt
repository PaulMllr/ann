package io.codenetics.ann.service

import io.codenetics.ann.dao.NeuronDao
import io.codenetics.ann.domain.Neuron
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
    lateinit var neuronDao: NeuronDao

    fun createNewNeuron(description: String?): Neuron {
        return neuronDao.save(
                Neuron(description, mutableListOf(), mutableListOf(), { 1.0 }, { 1.0 }))
    }

    fun saveNeuron(neuron: Neuron): Neuron {
        return neuronDao.save(neuron)
    }

    fun findNeuronById(id: String) = neuronDao.findByIdsIn(listOf(id)).firstOrNull()

    fun findAllNeurons() = neuronDao.findAll()

    fun findNeuronsByIdIn(ids: List<String>) = neuronDao.findByIdsIn(ids)


}