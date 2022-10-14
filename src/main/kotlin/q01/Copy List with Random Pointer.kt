package q01

/**
 * No.138
 */
class `Copy List with Random Pointer` {

    val map = HashMap<Node, Node>()

    fun copyRandomList(node: Node?): Node? {
        if(node == null) return null

        if (!map.containsKey(node)) {
            val headNew = Node(node.`val`)
            map[node] = headNew
            headNew.next = copyRandomList(node.next)
            headNew.random = copyRandomList(node.random)
        }

        return map[node]
    }
}

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}