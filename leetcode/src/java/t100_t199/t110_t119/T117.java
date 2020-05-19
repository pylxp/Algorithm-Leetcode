package java.t100_t199.t110_t119;

public class T117 {
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {
            //这题跟116相似，建议放在一起做
            //题目要求实际上很简单，就是把每一层都从左到右连接起来
            //难点在于题目的附加要求，只使用常量级额外空间
            //但是这题需要注意的点是，每个非叶子节点不一定有2个子节点
            //所以我们要编写一个方法，用来查找父节点的next节点的最左节点

            //先设立终止条件
            if (root == null) return null;
            //连接左子节点的next节点
            if (root.left != null) {
                //同个父节点的左右节点相连
                if (root.right != null) root.left.next = root.right;
                else root.left.next = findNext(root);
            }
            //连接右子节点的next节点
            if (root.right != null) root.right.next = findNext(root);
            //往下一层遍历
            //重点，由于左节点的next节点依赖于右节点，所以要先遍历右节点
            connect(root.right);
            connect(root.left);
            //返回根节点
            return root;
        }

        //查找父节点的next节点的最左节点
        public Node findNext(Node root) {
            while (root.next != null) {
                if (root.next.left != null) return root.next.left;
                if (root.next.right != null) return root.next.right;
                root = root.next;
            }
            return null;
        }
    }
}
