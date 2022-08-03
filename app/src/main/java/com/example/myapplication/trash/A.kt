package com.example.myapplication.trash

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

//иеррархия: com.example.myapplication.trash.I -> com.example.myapplication.trash.O -> com.example.myapplication.trash.P -> com.example.myapplication.trash.A <- com.example.myapplication.trash.B. C -> com.example.myapplication.trash.A. com.example.myapplication.trash.A <-> MAIN