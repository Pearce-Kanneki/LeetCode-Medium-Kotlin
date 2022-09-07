package q08

import q01.TreeNode

/**
 * No.814
 */
class `Binary Tree Pruning` {

    /**
     *
     */
    fun pruneTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        root?.left = pruneTree(root?.left)
        root?.right = pruneTree(root?.right)
        if(root?.`val` == 1){
            return root
        }
        if(root?.left == null && root?.right == null){
            return null
        }
        return root
    }

    /**
     *
     */
    fun pruneTree1(root: TreeNode?): TreeNode? {
        if(root == null) return null

        root.left = pruneTree1(root.left)
        root.right = pruneTree1(root.right)
        if (root.left == null && root.right == null && root.`val` == 0) {
            return null
        }

        return root
    }
}