fun main() {
    val time: Int = 46556565;
    println(agoToText(time))
}

fun agoToText(time: Int): String {

    val strForText = "был(а) в сети"
    val strTime = when (time) {
        in 0..60 -> strForText + " только что"
        in 61..60 * 60 -> strForText + " " + (time / 60).toString() + " " + agoToTextMin(time)
        in 60 * 60 + 1..24 * 60 * 60 -> strForText + " " + (time / 3600).toString() + " " + agoToTextHour(time)
        in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> strForText + " " + "вчера"
        in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> strForText + " " + "позавчера"
        else -> strForText + " " + "давно"
    }

    return strTime
}

fun agoToTextMin(time: Int): String {

    val timeForMin = if (time / 60 in 11..19) time / 60 else time / 60 % 10

    val strTimeMin = when (timeForMin) {
        1 -> "минуту назад"
        in 2..4 -> "минуты назад"
        else -> "минут назад"
    }

    return strTimeMin
}

fun agoToTextHour(time: Int): String {

    val timeForHour = if (time / 3600 in 11..19) time / 3600
    else time / 3600 % 10

    val strTimeHour = when (timeForHour) {
        1 -> "час назад"
        in 2..4 -> "часа назад"
        else -> "часов назад"
    }

    return strTimeHour
}

