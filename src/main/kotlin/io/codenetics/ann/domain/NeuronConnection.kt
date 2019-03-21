package io.codenetics.ann.domain

import java.util.*

data class NeuronConnection(var from: Neuron, var to: Neuron, var weight: Double) {

    init {
        from.outConnections.addIf(this) { !from.outConnections.contains(this) }
        to.inConnections.addIf(this) { !to.inConnections.contains(this) }
    }

    var id = UUID.randomUUID().toString()

    fun getInput(): Double {
        return from.getOutput()
    }

    fun getWeightedInput(): Double {
        return from.getOutput() * weight
    }


    fun MutableList<NeuronConnection>.addIf(connection: NeuronConnection, condition: (() -> Boolean)) {
        if (condition()) {
            this.add(connection)
        }
    }
}