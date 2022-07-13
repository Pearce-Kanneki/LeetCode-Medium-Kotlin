package q01

/**
 * No.102
 */
class `Binary Tree Level Order Traversal` {

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        root?.let { recLevelOrder(listOf(it), result) }
        return result
    }

    fun recLevelOrder(nodes: List<TreeNode>, result: MutableList<List<Int>>) {
        if(nodes.size > 0) { result.add( nodes.map { n -> n.`val` } ) }
        val nextLayer = mutableListOf<TreeNode>()
        for(n in nodes) {
            n.left?.let { nextLayer.add(it) }
            n.right?.let { nextLayer.add(it) }
        }
        if(nextLayer.size > 0) { recLevelOrder(nextLayer, result) }
    }

    /**
     *
     */
    val result = mutableListOf<MutableList<Int>>()
    fun levelOrder1(root: TreeNode?): List<List<Int>> {

        root?.let { setLevelOrderValue(0,it) }
        return result
    }

    fun setLevelOrderValue(index: Int, root: TreeNode) {
        if (result.size - 1 < index) result.add(mutableListOf())
        result[index].add(root.`val`)
        root.left?.let { setLevelOrderValue(index + 1, it) }
        root.right?.let { setLevelOrderValue(index + 1, it) }
    }
}