package io.codenetics.ann.domain

import java.util.*

class Neuron(var description: String?,
             var sumFunction: ((List<NeuronConnection>) -> Double),
             var activationFunction: ((Double) -> Double)) {

    constructor(sumFunction: ((List<NeuronConnection>) -> Double),
                activationFunction: ((Double) -> Double)) :
            this(null, sumFunction, activationFunction)

    var id: String = UUID.randomUUID().toString()
    var inConnections = mutableListOf<NeuronConnection>()
    var outConnections = mutableListOf<NeuronConnection>()


    fun getOutput(): Double {
        val totalInput = sumFunction(inConnections)
        return activationFunction(totalInput)
    }

    override fun equals(other: Any?): Boolean {
        return other is Neuron && id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    companion object {
        fun createWithSumFunction(activationFunction: ((Double) -> Double)): Neuron {
            return Neuron({ connections -> connections.sumByDouble { conn -> conn.getWeightedInput() } },
                    activationFunction)
        }
    }
}