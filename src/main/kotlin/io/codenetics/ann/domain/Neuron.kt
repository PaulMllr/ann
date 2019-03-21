package io.codenetics.ann.domain

import java.util.*

class Neuron(var description: String?,
             var inConnections: MutableList<NeuronConnection>,
             var outConnections: MutableList<NeuronConnection>,
             var sumFunction: ((List<NeuronConnection>) -> Double),
             var activationFunction: ((Double) -> Double)) {

    constructor(inConnections: MutableList<NeuronConnection>,
                outConnections: MutableList<NeuronConnection>,
                sumFunction: ((List<NeuronConnection>) -> Double),
                activationFunction: ((Double) -> Double)) :
            this(null, inConnections, outConnections, sumFunction, activationFunction)

    var id: String = UUID.randomUUID().toString()


    fun getOutput(): Double {
        val totalInput = sumFunction(inConnections)
        return activationFunction(totalInput)
    }

    companion object {
        fun createWithSumFunction(activationFunction: ((Double) -> Double),
                                  inConnections: MutableList<NeuronConnection> = mutableListOf(),
                                  outConnections: MutableList<NeuronConnection> = mutableListOf()): Neuron {
            return Neuron(inConnections, outConnections, { connections -> connections.sumByDouble { conn -> conn.getWeightedInput() } }, activationFunction)
        }
    }
}