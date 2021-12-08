package Day01

import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01/large")

    val num_increases: Int = testInput.let {
        var increases = 0
        var prev_measurement = it[0].toInt()
        it.forEach { str_measurement ->
            val measurement = str_measurement.toInt()
            if (measurement > prev_measurement) {
                increases++
            }
            prev_measurement = measurement
        }
        increases
    }
    println(num_increases)


}
