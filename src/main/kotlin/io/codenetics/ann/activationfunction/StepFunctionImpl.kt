package io.codenetics.ann.activationfunction

/**
 *  Created by Pavel Laktiushkin on 20.01.2019
 */
class StepFunctionImpl(private val threshold: Double) : ActivationFunction {

    override fun calculate(input: Double) =
            if (input >= threshold)
                1.0
            else
                0.0

}