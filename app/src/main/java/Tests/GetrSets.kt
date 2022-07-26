package Tests

enum class Day(val value: Int){
    MONDAY(1), TUESDAY(2), WEDNESDAY(3),
    THURSDAY(4), FRIDAY(5), SATURDAY(6),
    SUNDAY(7);
    fun getDuration(day: Day): Int{
        return value - day.value;
    }
}

fun main() {

    val day1: Day = Day.FRIDAY
    val day2: Day = Day.MONDAY
    println(day1.getDuration(day2))        // 4
}