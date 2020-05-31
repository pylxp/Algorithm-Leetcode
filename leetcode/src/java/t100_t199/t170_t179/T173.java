package java.t100_t199.t170_t179;

public class T173 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class BSTIterator {
        //提升为全局变量，方便调用
        //创建栈，用于存放中序遍历结果
        Stack<TreeNode> stack = new Stack<>();

        //创建栈，用于中序遍历
        public BSTIterator(TreeNode root) {
            //根据二叉搜索树，实现两个简单的方法
            //1.返回下一个最小数
            //根据二叉搜索树的性质，即中序遍历的顺序输出
            //题目要求只能使用O(h)空间，那么表示只能最多存放一条路径的节点
            //这里采用栈模拟即可，先存放根节点和左节点
            //当单出的节点有右节点时，再入栈即可
            //2.判断是否有下一个最小的数
            //即判断是否为空

            //先将根节点和左节点入栈
            push(root);
        }

        //将根节点和左节点入栈
        public void push(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        //返回下一个最小值
        public int next() {
            //弹出下一个节点
            TreeNode node = stack.pop();
            //同时将其右节点入栈
            if (node.right != null) push(node.right);
            //返回弹出节点的值
            return node.val;
        }

        //判空
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
