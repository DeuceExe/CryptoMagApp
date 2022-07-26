package com.example.myapplication

open class I constructor(
    personName: String,
    personAge: Int,
    personSalary: Double
) {

    var name = personName
    var age = personAge
    var salary = personSalary
}

//иеррархия: I -> O -> P -> A <- B. C -> A. A <-> MAIN