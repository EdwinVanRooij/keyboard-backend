fun main(args: Array<String>) {

    val numbers = arrayOf(2, 4, 5, 8, 9, 1)
    printLessThanFive(numbers)

}

fun printLessThanFive(numbers: Array<Int>) {
    for (n in numbers) {
        if (n < 5) println("$n is lower than 5")
    }
}
