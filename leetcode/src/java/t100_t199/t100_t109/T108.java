package java.t100_t199.t100_t109;

public class T108 {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            //将有序数组构造成一个高度平衡的二叉搜索树
            //那么根据二叉搜索树和有序数组的特性不难得出以下结论
            //有序数组的中位数mid，即为根
            //则左子树=left~mid-1  右子树 mid+1~right
            //以此类推，递归能很简单的解决这个问题

            //调用方法
            return recursion(nums, 0, nums.length - 1);
        }

        public TreeNode recursion(int[] nums, int left, int right) {
            //先设立终止条件
            if (left > right) return null;
            //取有序数组的中位数，即二叉搜索树的根
            int mid = (left + right + 1) / 2;
            //创建根
            TreeNode root = new TreeNode(nums[mid]);
            //递归遍历左子树
            root.left = recursion(nums,left, mid - 1);
            //递归遍历右子树
            root.right = recursion(nums,mid + 1, right);
            //返回根节点
            return root;
        }
    }
}
