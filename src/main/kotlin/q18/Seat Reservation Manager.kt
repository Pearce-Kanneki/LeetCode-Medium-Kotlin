package q18

import java.util.*

/**
 * No.1845
 */
class `Seat Reservation Manager` {}

class SeatManager(n: Int) {

    val seats = PriorityQueue<Int>().apply {
        (1..n).forEach { add(it) }
    }

    fun reserve(): Int {
        return seats.poll()
    }

    fun unreserve(seatNumber: Int) {
        seats.add(seatNumber)
    }

}