package java.t100_t199.t140_t149;

public class T145 {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            //这题跟144相似，建议放在一起做
            //后序遍历
            //如果采用递归法，当然更快，不过题目要求使用迭代法
            //迭代和递归的简要区别，就在于下一次的调用是否受上一次的影响
            //那么根据后序遍历，左右中的特性
            //可以采用栈的先进后出特性，存放每个节点即可
            //这里可以采用双辅助栈的方法
            //也可以根据上一题的思路，采用中右左遍历，然后翻转即可
            //这里取个巧，借助上一题修改即可
            //即采用中右左的遍历顺序，每次结果插入结果集的头部
            //即形成了伪翻转，左右中的后序遍历

            //创建结果集
            List<Integer> res = new ArrayList<>();
            //先建立辅助栈
            Stack<TreeNode> stack = new Stack<>();
            //遍历树
            while (root != null || !stack.isEmpty()) {
                //如果右子树不为空，则遍历完右子树
                while (root != null) {
                    //每次往头部加入，形成伪翻转
                    res.add(0, root.val);
                    stack.push(root);
                    root = root.right;
                }
                //弹出节点遍历左子树
                root = stack.pop().left;
            }
            //返回结果
            return res;
        }
    }
}
