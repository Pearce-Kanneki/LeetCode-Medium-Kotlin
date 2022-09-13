package q07

import q01.TreeNode

/**
 * No.701
 */
class `Insert into a Binary Search Tree` {

    /**
     * 較快的解
     */
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if(root == null) return TreeNode(`val`)
        dfs(root, `val`)
        return root
    }

    private fun dfs(root: TreeNode?, value: Int){
        if(root == null) return
        if(value < root!!.`val`){
            if(root!!.left == null){
                root!!.left = TreeNode(value)
                return
            }
            dfs(root!!.left , value)
        }else{
            if(root!!.right == null){
                root!!.right = TreeNode(value)
                return
            }
            dfs(root!!.right, value)
        }
    }

    /**
     *
     */
    fun insertIntoBST1(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return TreeNode(`val`)

        var pos = root
        while (pos != null) {
            if (`val` < pos.`val`) {
                if (pos.left == null) {
                    pos.left = TreeNode(`val`)
                    break
                } else {
                    pos = pos.left
                }
            } else {
                if (pos.right == null) {
                    pos.right = TreeNode(`val`)
                    break
                } else {
                    pos = pos.right
                }
            }
        }

        return root
    }
}