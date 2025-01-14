@file:Suppress("UNUSED_PARAMETER")
package lesson2.task2

import lesson1.task1.*
import java.lang.Math.pow
import kotlin.math.*

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    println("$number")
    val n4 = number / 1000 % 10
    val n3 = number / 100 % 10
    val n2 = number / 10 % 10
    val n1 = number % 10

    return n4 + n3 == n2 + n1
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    return x1 == x2 || y1 == y2 || (abs(x1 - x2) == abs(y1 - y2))
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    val leapYear = (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)
    println("$year; $leapYear")
    return when {
        month == 1 -> 31
        month == 2 && leapYear -> 29
        month == 2 && !leapYear -> 28
        month == 3 -> 31
        month == 4 -> 30
        month == 5 -> 31
        month == 6 -> 30
        month == 7 -> 31
        month == 8 -> 31
        month == 9 -> 30
        month == 10 -> 31
        month == 11 -> 30
        month == 12 -> 31
        else -> 0
    }
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean {

    val distance = sqrt((x2 - x1).pow(2.0) + (y2 - y1).pow(2.0))

    return distance + r1 <= r2
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    val minSide1 = min(min(a, b), c)
    val maxSide = max(max(a, b), c)
    val minSide2 = a + b + c - maxSide - minSide1
    println("$minSide1; $minSide2")
    println("$r; $s")

    return (minSide1 <= min(r, s)) && (minSide2 <= max(r, s))
}
