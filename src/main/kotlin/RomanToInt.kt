/*

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

*/


fun romanToIntOld(s: String): Int {
    var sum = 0
    for (i in s.length - 1 downTo 0) {
        val char = s[i]
        val value = when (char) {
            'I' -> if (sum >= 5) -1 else 1
            'V' -> 5
            'X' -> if (sum >= 50) -10 else 10
            'L' -> 50
            'C' -> if (sum >= 500) -100 else 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
        sum += value // map[] ?: 0
    }

    return sum
}

fun romanToInt(s: String): Int {
    var prev = 0
    var sum = 0

    for (c in s) {
        val actual = when (c) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }

        sum += if (actual > prev) {
            actual - 2 * prev
        } else {
            actual
        }
        prev = actual
    }
    return sum
}


fun main() {
    require(romanToInt("III"), 3)
    require(romanToInt("LVIII"), 58)
    require(romanToInt("MCMXCIV"), 1994)
    require(romanToInt("XL"), 40)
    require(romanToInt("CD"), 400)
}

fun require(x: Int, y: Int) {
    require(x == y) {
        "$x must be equals to $y"
    }
}