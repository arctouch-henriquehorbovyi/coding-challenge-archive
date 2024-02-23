package org.example

/*
Ratiorg got statues of different sizes as a present from CodeMaster for his birthday,
each statue having a non-negative integer size. Since he likes to make things perfect,
he wants to arrange them from smallest to largest so that each statue will be bigger than
the previous one exactly by 1.

He may need some additional statues to be able to accomplish that.
Help him figure out the minimum number of additional statues needed.

Example:
For statues = [6, 2, 3, 8], the output should be

solution(statues) = 3
*/

fun main() {
    val s = solutionLongButGoodPerformance(mutableListOf(6, 2, 3, 8))
    assert(s == 3)
}

fun solutionShortButPoorPerformance(statues: MutableList<Int>): Int {
    statues.sort()
    return (statues.first()..statues.last())
        .subtract(statues.toSet())
        .count()
}


fun solutionLongButGoodPerformance(statues: MutableList<Int>): Int {
    if (statues.size <= 1)
        return 0

    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    val foundNumbers = mutableSetOf<Int>()

    statues.forEach {
        if (it < min)
            min = it

        if (it > max)
            max = it

        foundNumbers.add(it)
    }

    val diff = (max - min) - 1
    val statuesNeeded = foundNumbers.size - 2
    return diff - statuesNeeded
}
