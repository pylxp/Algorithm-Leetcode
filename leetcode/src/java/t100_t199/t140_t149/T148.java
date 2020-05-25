package java.t100_t199.t140_t149;

public class T148 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            //在 O(n log n)时间复杂度和常数级空间复杂度下，对链表进行排序。
            //这里只满足了O(n log n)时间复杂度

            //先设立终止条件
            if (head == null || head.next == null) return head;
            //建立快慢指针
            ListNode fast = head;
            ListNode slow = head;
            //找到中间节点
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //根据中间节点拆分链表
            //fast指向链表B头节点
            fast = slow.next;
            //链表A尾节点指向null，即断开链表
            slow.next = null;
            //左边排序并返回头节点
            slow = sortList(head);
            //右边排序并返回头节点
            fast = sortList(fast);
            //调用归并方法合并了两个链表
            return merge(fast, slow);
        }

        //归并方法
        public ListNode merge(ListNode left, ListNode right) {
            //创建一个临时头节点，用于返回结果
            ListNode newHead = new ListNode(0);
            //操作指针
            ListNode temp = newHead;
            //逐个比较左右链表节点
            while (left != null && right != null) {
                if (left.val <= right.val) {
                    temp.next = left;
                    temp = temp.next;
                    left = left.next;
                } else {
                    temp.next = right;
                    temp = temp.next;
                    right = right.next;
                }
            }
            //如果其中一个链表遍历完了，则直接排到后面即可
            if (left != null) temp.next = left;
            if (right != null) temp.next = right;
            //返回真头节点
            return newHead.next;
        }
    }
}
