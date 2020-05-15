package java.t1_t99.t90_t99;

public class T98 {
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
        //默认一个最小值，用于判断是否根小于左子树
        //因为最小值可能为Integer.MIN_VALUE,所以要用比他更小的数做初始化
        long minValue = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            //判断是否是一个有效的二叉搜索树
            //根据二叉搜索树的性质
            //即 左小于根，根小于右
            //那么这里递归往左右遍历即可

            //如果递归到底为null了，则为true
            if (root == null) return true;
            //往左递归，这里会递归到最左，然后从下往下比较
            //只要有一个false，则返回false
            if (!isValidBST(root.left)) return false;
            //根节点必须大于左子树
            if (root.val <= minValue) return false;
            //更新最小值为前一个根节点，即下一个根节点的左子树
            minValue = root.val;
            //往右递归，这里会递归到最右，然后从下往下比较
            //左边已经遍历完了，所以右边的遍历结果即为最终结果
            //这里同样，会拿右节点去对比根节点，即前两步，debug一下很好理解
            return isValidBST(root.right);
        }
    }
}
