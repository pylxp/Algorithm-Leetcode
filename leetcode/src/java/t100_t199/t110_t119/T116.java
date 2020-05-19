package java.t100_t199.t110_t119;

public class T116 {
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
            //题目要求实际上很简单，就是把每一层都从左到右连接起来
            //难点在于题目的附加要求，只使用常量级额外空间
            //那么根据以上两个要求，不难得出以下结论
            //1.只能使用原来的节点本身来操作
            //2.层次遍历，连接每一个层
            // 2.1 同个父节点，直接相连root.left.next = root.right;
            // 2.2 不是同个父节点,左节点的最右节点，连接右节点的最左节点
            // root.right.next = root.next.left;

            //先设立终止条件
            if (root == null) return null;
            //题目规定了每个非叶子节点都有2个子节点
            //那么这里判空随便取一个节点都可
            if (root.left != null) {
                //同个父节点的左右节点相连
                root.left.next = root.right;
                //不是同个不是同个父节点,左节点的最右节点，连接右节点的最左节点
                if (root.next != null) root.right.next = root.next.left;
            }
            //往下一层遍历
            connect(root.left);
            connect(root.right);
            //返回根节点
            return root;
        }
    }
}
