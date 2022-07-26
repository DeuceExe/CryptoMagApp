package com.example.myapplication

open class B {

    private var rate = 15
    var _rate = rate

    open fun printInfo(person: I, profit: Int) {
        println("Name: ${person.name} \nAge: ${person.age} \nSalary: ${person.salary} \nYour bonus: ${profit}$\n")
    }
}

//иеррархия: com.example.myapplication.I -> com.example.myapplication.O -> com.example.myapplication.P -> com.example.myapplication.A <- com.example.myapplication.B. C -> com.example.myapplication.A. com.example.myapplication.A <-> MAIN