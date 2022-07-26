package com.example.myapplication

fun main() {
    configPerson(I("Michail", 22, 2350.0))
    configPerson(I("Andrey", 44, 1200.0))
    configPerson(I("Evgeniy", 27, 9760.0))
}

fun configPerson(person: I) = A(person).calculating()

//иеррархия: com.example.myapplication.I -> com.example.myapplication.O -> com.example.myapplication.P -> com.example.myapplication.A <- com.example.myapplication.B. C -> com.example.myapplication.A. com.example.myapplication.A <-> MAIN