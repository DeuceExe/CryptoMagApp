package com.example.myapplication.trash

fun main() {
    configPerson(Person("Michail", 22, 2350.0))
    configPerson(Person("Andrey", 44, 1200.0))
    configPerson(Person("Evgeniy", 27, 9760.0))
}

fun configPerson(person: Person) {
    val commission = Commission(person.salary)

    PrintInfo(person.name, person.age, person.salary, commission.profit).printInfo()
    commission.calculating()
}

class Commission(commissionSalary: Double) : Profit() {

    private var bonus = commissionSalary
    var profit: Int = (bonus / (rate % 100)).toInt()

    fun calculating() {
        super.calculating(profit)
    }
}

open class Profit {

    var rate = 15

    open fun calculating(_result: Int) {

    }
}

class PrintInfo constructor(
    private val printName: String,
    private val printAge: Int,
    private val printSalary: Double,
    private val printProfit: Int
) : СompatibilityСheck(printName, printAge, printSalary) {

    fun printInfo() {
        if (super.check()) {
            println("Name: $name \nAge: $age \nSalary: $salary$ \nYour bonus: ${printProfit}\n")
        } else {
            println("$name, You are not eligible for sponsorship\n")
        }
    }
}

open class СompatibilityСheck constructor(
    private val compatibilityName: String,
    private val compatibilityAge: Int,
    private val compatibilitySalary: Double
) : Person(compatibilityName, compatibilityAge, compatibilitySalary) {

    fun check(): Boolean {
        println("Potential sponsor... ")
        return age in 21..30 && salary > 2000
    }
}

open class Person constructor(
    private val personName: String,
    private val personAge: Int,
    private val personSalary: Double
) {

    var name = personName
    var age = personAge
    var salary = personSalary
}

//иеррархия: com.example.myapplication.trash.I -> com.example.myapplication.trash.O -> com.example.myapplication.trash.P -> com.example.myapplication.trash.A <- com.example.myapplication.trash.B. C -> com.example.myapplication.trash.A. com.example.myapplication.trash.A <-> MAIN


