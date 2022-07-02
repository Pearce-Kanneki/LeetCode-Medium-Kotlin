package q14


/**
 * NO.1465
 */
class `Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts` {

    /**
     * 較快的解
     */
    data class Range(val from: Int, val to : Int)


    val modulo: Long = Math.pow(10.0,9.0).toLong() + 7L

    //https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/solution/
    //time: O(nLogn)
    //space: O(n)
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {

        horizontalCuts.sort()
        verticalCuts.sort()

        var prevCut = 0

        val hor = mutableListOf<Range>()
        for(cut in horizontalCuts){
            val range = Range(prevCut, cut)
            hor.add(range)
            prevCut = cut
        }

        hor.add(Range(prevCut, h))

        hor.sortWith(Comparator<Range>{r1, r2 ->

            (r2.to - r2.from) - (r1.to - r1.from)
        })

        val ver = mutableListOf<Range>()
        prevCut = 0
        for(cut in verticalCuts){
            val range = Range(prevCut, cut)
            ver.add(range)
            prevCut = cut
        }

        ver.add(Range(prevCut, w))

        ver.sortWith(Comparator<Range>{r1, r2 ->

            (r2.to - r2.from) - (r1.to - r1.from)
        })

        // println("hor: " + hor)
        // println("ver: " + ver)

        val r1 = hor[0]
        val r2 = ver[0]

        val side1 = (r1.to - r1.from).toLong()
        val side2 = (r2.to - r2.from).toLong()

        return  ((side1 * side2) % modulo).toInt()

    }

    /**
     * 個人解
     */
    fun maxArea1(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        val horizontalList = (horizontalCuts + minOf(h, 100000)).sorted()
        val vericalList = (verticalCuts + minOf(w, 100000)).sorted()

        var maxH = 0
        var maxW = 0

        horizontalList.forEachIndexed { index, item ->
            maxH = if (index == 0) {
                maxOf(item, maxH)
            } else {
                maxOf(item - horizontalList[index - 1], maxH)
            }

        }

        vericalList.forEachIndexed { index, item ->
            maxW = if (index == 0) {
                maxOf(item, maxW)
            } else {
                maxOf(item - vericalList[index - 1], maxW)
            }
        }

        return ((maxW.toBigInteger() * maxH.toBigInteger()) % (1000000007).toBigInteger()).toInt()
    }
}