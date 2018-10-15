package io.codenetics.ann.domain

data class NeuronConnection(var from: Neuron, var to: Neuron, var weight: Double) {

    fun getInput(): Double {
        return from.getOutput()
    }

    fun getWeightedInput(): Double {
        return from.getOutput() * weight
    }
}