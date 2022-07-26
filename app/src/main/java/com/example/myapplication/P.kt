package com.example.myapplication

class P constructor(
    printName: String,
    printAge: Int,
    printSalary: Double
) : O(printName, printAge, printSalary) {

    fun checkValue() = super.check()
}

//иеррархия: com.example.myapplication.I -> com.example.myapplication.O -> com.example.myapplication.P -> com.example.myapplication.A <- com.example.myapplication.B. C -> com.example.myapplication.A. com.example.myapplication.A <-> MAIN