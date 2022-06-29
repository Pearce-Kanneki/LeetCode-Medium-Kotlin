package q04

import java.util.*
import kotlin.Comparator

/**
 * No.406
 */
class `Queue Reconstruction by Height` {

    /**
     * 解題策略:
     *
     *  if 兩人身高一樣
     *      排序較低的k值先出現
     *  else
     *      排序較高的人先出來(因為稍後出現的不會改變我們的答案)
     */

    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        val compartor = Comparator { prv: IntArray, next: IntArray ->
            if (prv[0] == next[0]) {
                prv[1].compareTo(next[1])
            } else {
                next[0].compareTo(prv[0])
            }
        }

        people.sortWith(compartor)
        val ans = arrayListOf<IntArray>()
        people.forEach {
            ans.add(it[1], it)
        }

        return ans.toTypedArray()
    }

    /**
     *  4 line
     */
    fun reconstructQueue1(people: Array<IntArray>): Array<IntArray> {
        val result = LinkedList<IntArray>()
        people.sortWith(compareBy({ person -> -person[0] }, { person -> person[1] }))
        people.forEach { person -> result.add(person[1], person) }
        return result.toTypedArray()
    }

    fun reconstructQueue2(people: Array<IntArray>): Array<IntArray> {
        people.sortWith(Comparator { a, b ->
            if (a[0] == b[0]) a[1] - b[1]
            else b[0] - a[0]
        })

        val res = ArrayList<IntArray>()

        for (p in people) {
            res.add(p[1], p)
        }

        return res.toTypedArray()
    }
}