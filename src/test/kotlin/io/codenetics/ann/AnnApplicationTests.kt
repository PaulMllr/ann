package io.codenetics.ann

import io.codenetics.ann.domain.Neuron
import io.codenetics.ann.domain.NeuronConnection
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class AnnApplicationTests {

    @Test
    fun contextLoads() {
    }

    @Test
    fun checkBasicSum() {
        val neuron1 = Neuron.createWithSumFunction({ input -> input * 2 })
        val neuron2 = Neuron.createWithSumFunction({ input -> input * 3 })

        val conn1 = NeuronConnection(neuron1, neuron2, 0.9)

        neuron1.outConnections.add(conn1)
        neuron2.inConnections.add(conn1)

        println("Neuron 2 output : ${neuron2.getOutput()}")
    }
}
