fun main(args: Array<String>) {

    // Make a function that returns the correct answer on the game 'juffen'
    val countTo = 100

    playJuffen(countTo)
}

fun playJuffen(countTo: Int) {
    for (number in 1..countTo) {
        if (number.toString().contains("7") || number % 7 == 0) {
            println("Juf!")
        } else {
            println(number)
        }
    }
}

