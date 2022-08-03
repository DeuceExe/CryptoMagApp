package com.example.myapplication.trash

class P constructor(
    printName: String,
    printAge: Int,
    printSalary: Double
) : O(printName, printAge, printSalary) {

    fun checkValue() = super.check()
}

//иеррархия: com.example.myapplication.trash.I -> com.example.myapplication.trash.O -> com.example.myapplication.trash.P -> com.example.myapplication.trash.A <- com.example.myapplication.trash.B. C -> com.example.myapplication.trash.A. com.example.myapplication.trash.A <-> MAIN