package io.codenetics.ann.service

import io.codenetics.ann.dao.NeuronDao
import io.codenetics.ann.domain.Neuron
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 15.03.2019
 */

@Service
class NeuronService {

    @Autowired
    lateinit var neuronDao: NeuronDao


    fun saveNeuron(): Neuron {
        return neuronDao.save(
                Neuron(mutableListOf(), mutableListOf(), { 1.0 }, { 1.0 }))
    }

    fun findNeuronById(id: String) = neuronDao.findByIdsIn(listOf(id)).firstOrNull()

    fun findNeuronsByIdIn(ids: List<String>) = neuronDao.findByIdsIn(ids)


}