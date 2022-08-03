package com.example.myapplication.trash

fun main() {
    configPerson(I("Michail", 22, 2350.0))
    configPerson(I("Andrey", 44, 1200.0))
    configPerson(I("Evgeniy", 27, 9760.0))
}

fun configPerson(person: I) = A(person).calculating()

//иеррархия: com.example.myapplication.trash.I -> com.example.myapplication.trash.O -> com.example.myapplication.trash.P -> com.example.myapplication.trash.A <- com.example.myapplication.trash.B. C -> com.example.myapplication.trash.A. com.example.myapplication.trash.A <-> MAIN