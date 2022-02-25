package com.bpointer.kotlindemo

import java.util.*

fun main() {
    println("Hello world")
    println(5 + 5)
    println(10 - 5)
    println(5 * 5)
    println(100 / 10)
    println(100 % 80)

    var name = "John Wick"
    val movie = 3

    println(name)
    println(movie)

    name = "Terminator"
    val movie2 = 6
    println(name)
    println(movie2)

    var key: String
    key = "Lock"
    println(key)

    var count = 10
    println(count)

    count = 20
    println(count)

    val x = 5432156789.1234
    println(x.toInt())
    println(x.toDouble())
    println(x.toFloat())
    println(x.toLong())

    println("**************************************************************************************")
    var str1 = "Test"
    var str2 = "Demo Test"

    println(str1.compareTo(str2))
    println(str1.compareTo(str1))
    println(str1.plus(str2))
    println(str2.length)
    println(str2.uppercase())
    println(str2.lowercase())


    var txt = "May the force be with you"
    println(txt.indexOf("force"))
    println(txt.indexOf("you"))

    println("**************************************************************************************")
    val isKotlinEasy = true
    val isFishTasty = false
    println(isKotlinEasy)
    println(isFishTasty)

    println("**************************************************************************************")
    val a = 100
    val b = 90
    println(a == b)
    println(a > b)
    println(a == 100)

    val p = 25
    if (p < 12) {
        println("Good Morning")
    } else if (p < 17) {
        println("Good Afternoon")
    } else {
        println("Good Evening")
    }

    val res = if (p > 24) "It is not time" else "It is time"
    println(res)

    println("**************************************************************************************")
    val res1 = when (8) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        5 -> "Friday"
        6 -> "Saturday"
        7 -> "Sunday"
        else -> "Invalid day"
    }
    println(res1)


    when {
        p < 12 -> {
            println("Good Morning")
        }
        p < 17 -> {
            println("Good Afternoon")
        }
        else -> {
            println("Good Evening")
        }
    }

    println("**************************************************************************************")
    var cars = arrayOf("ALTROZ", "I20", "PUNCH", "NEXON", "SWIFT")
    for (c in cars) {
        println(c)
    }

    if ("SWIFT" in cars) println("It exists") else println("It does not exist ")

    for (chars in 'p'..'x') {
        print("\t" + chars)
    }

    println()
    for (nums in 8..21) {
        print("\t" + nums)
    }

    println()
    for (nums in 5..20) {
        if (nums == 9)
            break
        print("\t" + nums)
    }

    println()
    for (nums in 5..21) {
        if (nums == 15)
            continue
        print("\t" + nums)
    }
    println()
    println("**************************************************************************************")

    myFunction()

    myFunction2("John", 32)
    myFunction2("Stephen", 27)
    myFunction2("Tony", 40)

    println(function1(80, 90))
    println(function2(90, 80))

    println("**************************************************************************************")

    val c1 = Car()
    c1.brand = "Ford"
    c1.model = "Mustang"
    c1.year = 1969
    println(c1.brand + "\t" + c1.model + "\t" + c1.year)

    val c2 = Car()
    c2.brand = "BMW"
    c2.model = "X5"
    c2.year = 1999
    println(c2.brand + "\t" + c2.model + "\t" + c2.year)

    val z1 = createFruit(1, "Kalingad", "Green", "Big")
    val z2 = createFruit(2, "Safarchand", "Red", "Small")
    val z3 = createFruit(3, "kel", "Yellow", "Small")
    val z4 = createFruit(4, "Peru", "Green", "Small")
    val z5 = createFruit(5, "Zambul", "Black", "Small")

    val fruitList = arrayListOf(z1, z2, z3, z4, z5)
    for (f in fruitList) {
        println("" + f.sr + "\t" + f.name + "\t" + f.color + "\t" + f.size)
    }

    val x1=Car2("Ford","Mustang",1969)
    val x2=Car2("BMW","X5",1999)
    val x3=Car2("Tesla","Model s",2020)

    println(x1.brand + "\t" + x1.model + "\t" + x1.year)
    println(x2.brand + "\t" + x2.model + "\t" + x2.year)
    println(x3.brand + "\t" + x3.model + "\t" + x3.year)

}

fun createFruit(sr: Int, name: String, color: String, size: String): Fruit {
    val f = Fruit()
    f.sr = sr
    f.name = name
    f.color = color
    f.size = size
    return f
}

fun myFunction() {
    println("I just executed")
}

fun myFunction2(fname: String, age: Int) {
    println("$fname is $age")
}

fun function1(x: Int, y: Int): Int {
    return (x + y)
}

fun function2(x: Int, y: Int): Int = x + y