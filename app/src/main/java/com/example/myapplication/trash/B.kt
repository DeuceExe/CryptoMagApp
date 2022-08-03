package com.example.myapplication.trash

open class B {

    private var rate = 15
    var _rate = rate

    open fun printInfo(person: I, profit: Int) {
        println("Name: ${person.name} \nAge: ${person.age} \nSalary: ${person.salary} \nYour bonus: ${profit}$\n")
    }
}

//иеррархия: com.example.myapplication.trash.I -> com.example.myapplication.trash.O -> com.example.myapplication.trash.P -> com.example.myapplication.trash.A <- com.example.myapplication.trash.B. C -> com.example.myapplication.trash.A. com.example.myapplication.trash.A <-> MAIN