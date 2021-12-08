package Day02

import readInput
import java.lang.Exception
import kotlin.math.abs

enum class Direction {
    FORWARD, DOWN, UP
}

data class Command(val direction: Direction, val distance: Int)

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02/large")
    val commands = testInput.map { lineToCommand(it) }
    val groupedCommands = commands.groupBy(Command::direction, Command::distance)
    fun safeSumDirection(direction: Direction) = groupedCommands.getOrDefault(direction, listOf(0)).sum()
    val totalDepth = safeSumDirection(Direction.UP) - safeSumDirection(Direction.DOWN)
    val totalForward = safeSumDirection(Direction.FORWARD)
    println(abs(totalDepth) * totalForward)
}

fun stringToDirection(direction_str: String): Direction = when(direction_str) {
    "forward" -> Direction.FORWARD
    "down" -> Direction.DOWN
    "up" -> Direction.UP
    else -> throw Exception("Unknown direction: '$direction_str'")
}

fun lineToCommand(line: String): Command {
    val direction = stringToDirection(line.split(" ")[0])
    val distance = line.split(" ")[1].toInt()
    return Command(direction, distance)
}
