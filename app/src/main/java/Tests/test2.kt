fun removeDuplicates(nums: ArrayList<Int>): MutableList<Int> {
    var count: Int
    var n: Int
    nums.toMutableList()
    for (num in nums){
        n = num
        count = 0
        for (num2 in nums){
            if (n == num2) count++
            if (count > 0) nums.remove(num2)
            return mutableListOf(num)
        }
    }
    return mutableListOf()
}

fun main() {
    val res = removeDuplicates(mutableListOf(3, 5, 5, 5, 6, 6, 7, 7) as ArrayList<Int>)
    println(res)
}