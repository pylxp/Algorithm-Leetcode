package java.t100_t199.t140_t149;

public class T144 {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            //前序遍历，根据题目要求使用迭代法
            //迭代和递归的简要区别，就在于下一次的调用是否受上一次的影响
            //那么根据前序遍历，中左右的特性
            //可以采用栈的先进后出特性，存放每个节点即可

            //创建结果集
            List<Integer> res = new ArrayList<>();
            //先建立辅助栈
            Stack<TreeNode> stack = new Stack<>();
            //遍历树
            while (root != null || !stack.isEmpty()) {
                //如果左子树不为空，则遍历完左子树
                while (root != null) {
                    res.add(root.val);
                    stack.push(root);
                    root = root.left;
                }
                //弹出节点遍历右子树
                root = stack.pop().right;
            }
            //返回结果
            return res;
        }
    }
}
