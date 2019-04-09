package io.codenetics.ann

import io.codenetics.ann.domain.Neuron
import io.codenetics.ann.domain.NeuronConnection
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AnnApplicationTests {


    @Test
    fun checkBasicSum() {
        val inputNeuron = Neuron.createWithSumFunction { 100.0 }
        val neuron2 = Neuron.createWithSumFunction { input -> input * 1 }
        val neuron3 = Neuron.createWithSumFunction { input -> input * 1 }

        NeuronConnection(inputNeuron, neuron2, 1.0)
        NeuronConnection(neuron2, neuron3, 1.0)



        assert(neuron3.getOutput() == 100.0)
    }
}
