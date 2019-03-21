package io.codenetics.ann.dao

import io.codenetics.ann.domain.Neuron
import io.codenetics.ann.domain.NeuronConnection
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
@Qualifier("InMemory")
class NeuronConnectionDaoInMemoryImpl : NeuronConnectionDao {
    private val log = LoggerFactory.getLogger(this::class.java)

    private val data = HashSet<NeuronConnection>()


    override fun save(connection: NeuronConnection): NeuronConnection {
        data.add(connection)
        log.info("Saved a new connection: ${connection.id}")
        return connection
    }

    override fun findAllByFromNeuron(neuron: Neuron) = data.filter { it.from == neuron }

}