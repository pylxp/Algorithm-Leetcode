package java.t1_t99.t90_t99;

public class T99 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public void recoverTree(TreeNode root) {
            //这题跟94，95，96，98相似，建议放在一起做
            //二叉搜索树中的两个节点被错误交换，在不改变其结构的情况下恢复
            //本题解法非常多，不过题目要求常数空间，目前只有Morris算法符合
            //Morris可以以O(1)的空间复杂度实现二叉树的中序遍历
            //Morris的遍历思想很简单：只遍历树而不是用空间。
            //根据二叉搜索树的特性和中序遍历，不难知道，每个节点的前序节点，都是小于且最接近自身的数
            //即一个节点的前序节点的右节点只有两种可能，1.空 2.节点自身
            //如 1，2    以1为根，节点2的前序节点1，右节点为节点2自身
            //以2为根，节点2的前驱节点1，右节点为空
            //Morris的步骤如下：
        /*1.根据当前节点，找到其前序节点
            1.1 前序节点的右孩子是空，那么把前序节点的右孩子指向当前节点，然后进入当前节点的左孩子
                1.1.1 如果当前节点的左孩子为空，打印当前节点，然后进入右孩子
            1.2 前序节点其右孩子指向了当前节点本身，那么把前序节点的右孩子设置为空，打印当前节点，然后进入右孩子。
        */
            //根据以下结论开始编程

            //创建两个节点，分别指向待交换的两个节点
            TreeNode swap1 = null, swap2 = null;
            //创建两个节点，preNode存放前驱节点，predecessor用于遍历找到前序节点
            TreeNode preNode = null, predecessor = null;
            //根节点的前序节点的右节点必定为空，所以直接从流程 1.1开始
            while (root != null) {
                // 找到root的前序节点，即左孩子的右叶子节点遍历到底
                if (root.left != null) {
                    predecessor = root.left;
                    while (predecessor.right != null && predecessor.right != root)
                        predecessor = predecessor.right;
                    // 流程 1.1
                    if (predecessor.right == null) {
                        predecessor.right = root;
                        root = root.left;
                    }
                    //流程 1.2
                    else {
                        //即如果当前节点的值小于前序结点的值，则这个节点是要交换的节点
                        if (preNode != null && root.val < preNode.val) {
                            swap2 = root;
                            if (swap1 == null) swap1 = preNode;
                        }
                        //更新前序节点
                        preNode = root;
                        //更新前序节点的右节点
                        predecessor.right = null;
                        //更新根节点
                        root = root.right;
                    }
                }
                //如果左孩子为空，则表示小数遍历到底了
                else {
                    //即如果当前节点的值小于前序结点的值，则这个节点是要交换的节点
                    if (preNode != null && root.val < preNode.val) {
                        swap2 = root;
                        if (swap1 == null) swap1 = preNode;
                    }
                    preNode = root;
                    root = root.right;
                }
            }
            //交换节点值
            int tmp = swap1.val;
            swap1.val = swap2.val;
            swap2.val = tmp;
        }
    }
}
