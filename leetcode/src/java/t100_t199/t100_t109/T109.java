package java.t100_t199.t100_t109;

public class T109 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
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
        public TreeNode sortedListToBST(ListNode head) {
            //这题跟108类似，建议放在一起做
            //将有序链表构造成一个高度平衡的二叉搜索树
            //那么根据二叉搜索树和有序链表的特性不难得出以下结论
            //有序链表的中间节点mid，即为根
            //则左子树 left~mid-1  右子树 mid+1~right
            //那么参考上一题，这题不难想出两种解法
            //1.将有序链表转换成上一题的有序数组，再套用上一题的解法
            //2.采用快慢指针，直接在链表中找到中节点

            //调用方法
            return recursion(head, null);
        }

        private TreeNode recursion(ListNode head, ListNode tail) {
            //先设立终止条件
            if (head == tail) return null;
            //创建快慢指针，用于找到中节点
            ListNode fast = head, slow = head;
            //快指针跑两个节点，慢指针跑一个节点，当快指针到尾时，慢指针则到中节点
            while (fast != tail && fast.next != tail) {
                fast = fast.next.next;
                slow = slow.next;
            }
            //创建根
            TreeNode root = new TreeNode(slow.val);
            //递归遍历左子树
            root.left = recursion(head, slow);
            //递归遍历右子树
            root.right = recursion(slow.next, tail);
            //返回根节点
            return root;
        }
    }
}
