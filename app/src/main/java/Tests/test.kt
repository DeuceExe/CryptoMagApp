import java.util.*

fun twoSum(nums: IntArray, target: Int): IntArray {
    for (num in nums) {
        for (num2 in nums) {
            if (num.plus(num2) == target) {
                return intArrayOf(nums.indexOf(num), nums.indexOf(num2))
            }
        }
    }
    return intArrayOf()
}
fun main(){
    val ans = twoSum(intArrayOf(2, 7, 9, 15), 9)
    println(ans.contentToString())
}