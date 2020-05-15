package java.t100_t199.t100_t109;

public class T100 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            //这题是树的概念题，要求树完全相同
            //那么直接从根节点同步遍历左右子树即可

            //如果都为空，返回true
            if (p == null && q == null) return true;
            //如果其中一个为空，或者值不同，返回false
            if (q == null || p == null || p.val != q.val) return false;
            //同步往左右子树递归
            return isSameTree(p.right, q.right) &&
                    isSameTree(p.left, q.left);
        }
    }
}
