package io.codenetics.ann.domain

import java.util.*

class NeuralNet(var inLayer: NeuralNetLayer, var outLayer: NeuralNetLayer, var hiddenLayers: MutableList<NeuralNetLayer>) {
    val id: String = UUID.randomUUID().toString()
}