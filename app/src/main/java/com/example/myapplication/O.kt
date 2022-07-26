package com.example.myapplication

open class O constructor(
    validatorName: String,
    private val validatorAge: Int,
    private val validatorSalary: Double
) : I(validatorName, validatorAge, validatorSalary) {

    fun check(): Boolean {
        print("Potential sponsor - ")
        return validatorAge in MIN_AGE_RANGE..MAX_AGE_RANGE && validatorSalary > MIN_SALARY
    }

    companion object {
        const val MIN_AGE_RANGE = 21
        const val MAX_AGE_RANGE = 30
        const val MIN_SALARY = 2000
    }
}

//иеррархия: com.example.myapplication.I -> com.example.myapplication.O -> com.example.myapplication.P -> com.example.myapplication.A <- com.example.myapplication.B. C -> com.example.myapplication.A. com.example.myapplication.A <-> MAIN
