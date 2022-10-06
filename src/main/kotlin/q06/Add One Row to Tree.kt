package q06

import q01.TreeNode

/**
 * No.623
 */
class `Add One Row to Tree` {

    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        if (root == null) return null

        if (depth == 1) return TreeNode(`val`).apply {
            left = root
        }

        if (depth == 2) {
            root.apply {
                left = TreeNode(`val`).apply { left = root.left }
                right = TreeNode(`val`).apply { right = root.right }
            }
        } else {
            root.apply {
                left = addOneRow(root.left, `val`, depth - 1)
                right = addOneRow(root.right, `val`, depth - 1)
            }
        }

        return root
    }
}