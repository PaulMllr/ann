package io.codenetics.ann.domain

import java.util.*

class Neuron {
    var id: String = UUID.randomUUID().toString()
    var inConnections: List<NeuronConnection> = emptyList()
    var outConnections: List<NeuronConnection> = emptyList()
    var sumFunction: ((List<NeuronConnection>) -> Double) = { 0.0 }
    var activationFunction: ((Double) -> Double) = { 0.0 }


    fun getOutput(): Double {
        val totalInput = sumFunction(inConnections)
        return activationFunction(totalInput)
    }

}