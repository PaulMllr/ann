package io.codenetics.ann.activationfunction

/**
 *  Created by Pavel Laktiushkin on 20.01.2019
 */
class LinearCombinationFunctionImpl(private val bias: Double) : ActivationFunction {

    override fun calculate(input: Double) = input + bias

}