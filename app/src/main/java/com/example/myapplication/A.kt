package com.example.myapplication

class A(private var i: I) : B() {

    private val p: P = P(i.name, i.age, i.salary)

    fun calculating() {
        if (p.checkValue()) {
            super.printInfo(i, (i.salary / (_rate % PERCENT_VALUE)).toInt())
        } else {
            println("${i.name}, You are not eligible for sponsorship\n")
        }
    }

    companion object {
        const val PERCENT_VALUE = 100
    }
}

//иеррархия: com.example.myapplication.I -> com.example.myapplication.O -> com.example.myapplication.P -> com.example.myapplication.A <- com.example.myapplication.B. C -> com.example.myapplication.A. com.example.myapplication.A <-> MAIN