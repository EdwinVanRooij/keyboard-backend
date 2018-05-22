package io.github.edwinvanrooij

fun main(args: Array<String>) {

    val m = Manager("Henk", 20)
    m.fireSomeone("Karel")
    m.fireSomeone("Karel", "klootzak!")
}

class Manager(val name: String, val age: Int) {

    fun fireSomeone(name: String ) {
        println("$name, you're fired!")
    }
}


fun Manager.fireSomeone(name: String, cussword: String) {
    println("$name, you're fired you $cussword!")
}
