package io.codenetics.ann.dao

import io.codenetics.ann.domain.Neuron
import io.codenetics.ann.domain.NeuronConnection
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import java.util.*

@Component
@Qualifier("Mock")
class NeuronConnectionDaoMockImpl : NeuronConnectionDao {
    override fun save(connection: NeuronConnection): NeuronConnection {
        TODO("not implemented")
    }

    override fun findAllByFromNeuron(neuron: Neuron): List<NeuronConnection> {

        val mockNeuron1 = Neuron( { 1.0 }, { 1.0 })
        val mockNeuron2 = Neuron( { 1.0 }, { 1.0 })
        return listOf(
                NeuronConnection(neuron, mockNeuron1, 0.2),
                NeuronConnection(neuron, mockNeuron2, 0.7))
    }

    override fun findAllByFromNeuron(neuronId: String): List<NeuronConnection> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}