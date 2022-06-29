package q16

/**
 * No.1657
 */
class `Minimum Deletions to Make Character Frequencies Unique` {

    fun minDeletions(s: String): Int {
        val cnt = IntArray(26) // 因輸入值只有英文字母,所以最大值為26
        s.forEach { cnt[it - 'a']++ } // 個別字母統計

        cnt.sortDescending() // 重新排序-倒敘


        // 計算保留數量
        for (i in 1 until cnt.size) {
            cnt[i] = maxOf(0, minOf(cnt[i], cnt[i - 1] - 1))
        }
        return s.length - cnt.sum()
    }

    /**
     * 目前最快解
     */
    fun minDeletions2(s: String): Int {
        val count = IntArray(26)
        s.forEach { count[it - 'a']++ }

        count.sortDescending()

        var result = 0
        var maxNumber = s.length
        for ( i in count.indices) {
            var item = count[i]

            if (item > maxNumber) {
                result += (item - maxNumber)
                item = maxNumber
            }

            maxNumber = maxOf(0, item - 1)
        }

        return result
    }

    /**
     * 初始草稿解
     */
    fun minDeletions1(s: String): Int {

        val map = hashMapOf<Char, Int>()
        s.forEach {char ->
            map[char] = (map[char] ?: 0) + 1
        }

        var sum = 0
        val emptyList = arrayListOf<Int>()

        for (index in 1..(map.maxBy { it.value }?.value ?: 1)) {
            var numberSize =  map.filter { it.value == index }.size

            when{
                numberSize == 0 -> emptyList.add(index)
                numberSize > 1 && emptyList.isNotEmpty() -> {
                    for (i in numberSize downTo 0){
                        sum += index - emptyList.last()
                        emptyList.removeAt(emptyList.lastIndex)
                        numberSize--
                        if (emptyList.isEmpty() || numberSize == 1) break
                    }

                    if (numberSize > 1) {
                        sum += (numberSize - 1) * index
                    }
                }
                numberSize > 1 -> {
                    sum += (numberSize - 1) * index
                }
            }
        }

        return sum
    }
}