package io.codenetics.ann.domain

import java.util.*

class Neuron {
    var id: String = UUID.randomUUID().toString()
    var inConnections: List<NeuronConnection> = emptyList()
    var outConnections: List<NeuronConnection> = emptyList()

}