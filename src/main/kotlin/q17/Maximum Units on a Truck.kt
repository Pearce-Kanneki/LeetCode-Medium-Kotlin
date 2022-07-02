package q17

import java.util.*

/**
 * No.1710
 */
class `Maximum Units on a Truck` {

    /**
     * 較快的解
     */
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        var unit = 0
        val pq = PriorityQueue<IntArray>{ p1: IntArray, p2: IntArray -> p2[1] - p1[1]}
        var curBox = 0

        for(box in boxTypes){
            pq.add(box)
        }

        while(curBox != truckSize && !pq.isEmpty()){
            val boxValue = pq.remove()
            val b = boxValue[0]
            val u = boxValue[1]
            if(curBox + b >= truckSize){
                unit += ( truckSize - curBox ) * u
                break
            }
            unit += b * u
            curBox += b

        }

        return unit

    }

    fun maximumUnits1(boxTypes: Array<IntArray>, truckSize: Int): Int {

        var sum = 0
        var maxNumber = truckSize
        boxTypes.sortByDescending { it[1] }

        for (i in boxTypes.indices) {

            if (maxNumber > boxTypes[i][0]) {
                sum += boxTypes[i][0] * boxTypes[i][1]
                maxNumber -= boxTypes[i][0]
            } else {
                sum += maxNumber * boxTypes[i][1]
                break
            }
        }

        return sum
    }
}