package q03

/**
 * No.341
 */
class `Flatten Nested List Iterator` {
}

class NestedIterator(nestedList: List<NestedInteger>) {
    private val ret = mutableListOf<Int>()
    private var index = 0

    init {
        flatten(nestedList)
    }

    private fun flatten(nes: List<NestedInteger>) {
        nes.forEach {
            if (it.isInteger()) {
                ret.add(it.getInteger()!!)
            } else {
                flatten(it.getList()!!)
            }
        }
    }

    fun next(): Int {
        return ret[index++]
    }

    fun hasNext(): Boolean {
        return index < ret.size
    }
}

class NestedInteger {
    // Constructor initializes an empty nested list.
    constructor()

    // Constructor initializes a single integer.
    constructor(value: Int)

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int?

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>?
}