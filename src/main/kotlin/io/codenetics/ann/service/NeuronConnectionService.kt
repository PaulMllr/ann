package io.codenetics.ann.service

import io.codenetics.ann.dao.NeuronConnectionDao
import io.codenetics.ann.domain.Neuron
import io.codenetics.ann.domain.NeuronConnection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 15.03.2019
 */

@Service
class NeuronConnectionService {

    @Autowired
    @Qualifier("InMemory")
    protected lateinit var connectionDao: NeuronConnectionDao


    fun save(connection: NeuronConnection) = connectionDao.save(connection)

    fun getAllConnectionsFromNeuron(neuron: Neuron) = connectionDao.findAllByFromNeuron(neuron)

    fun getAllConnectionsFromNeuron(neuronId: String) = connectionDao.findAllByFromNeuron(neuronId)


}