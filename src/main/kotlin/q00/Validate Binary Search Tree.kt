package q00

import q01.TreeNode

/**
 * No.98
 */
class `Validate Binary Search Tree` {

    /**
     * 較快的解
     */
    fun isValidBST(root : TreeNode? , min: Long, max: Long): Boolean {
        if(root == null ) {
            return true
        } else {
            if(root.`val` <= min || root.`val` >= max) {
                return false
            }

            if(root.left != null && root.left.`val` >= root.`val`) {
                return false
            }
            if(root.right !=null && root.right.`val` <= root.`val`) {
                return false
            }

            return isValidBST(root.left, min,root.`val`.toLong()) && isValidBST(root.right,  root.`val`.toLong(), max)
        }


    }

    fun isValidBST(root: TreeNode?): Boolean {

        return isValidBST(root, Integer.MIN_VALUE - 1.toLong(), Integer.MAX_VALUE + 1.toLong())

    }

    /**
     *
     */
    fun isValidBST1(root: TreeNode?): Boolean {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun helper(node: TreeNode?, min:Long, max:Long): Boolean {
        if (node == null) return true
        if (node.`val` <= min || node.`val` >= max) return false
        return helper(node.left, min, node.`val`.toLong()) && helper(node.right, node.`val`.toLong(), max)
    }
}