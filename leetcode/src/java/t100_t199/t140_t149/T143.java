package java.t100_t199.t140_t149;

public class T143 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public void reorderList(ListNode head) {
            //链表重排序，根据题目要求
            //实际上不难发现，即先取头，再取尾，直到每个节点遍历完成为止
            //那么不难想到，可以直接将链表一分为二
            //即变成了每次从链表a头取一个节点，再从链表b尾取一个节点
            //如果再将链表b翻转，则变成了每次分别从链表a、b头节点各取一个节点

            //先处理特殊情况，少于3个节点，则无需重排序了
            if (head == null || head.next == null || head.next.next == null) return;
            //根据快慢指针，找到链表中点，对半拆分链表
            ListNode fast = head, slow = head;
            //找到中点
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //拆分链表，即慢指针的下一个节点即为新的链表的头节点
            ListNode newHead = slow.next;
            slow.next = null;
            //用于找到链表的尾节点，翻转即为头节点
            ListNode tail = null;
            //翻转链表
            while (newHead != null) {
                ListNode temp = newHead.next;
                newHead.next = tail;
                tail = newHead;
                newHead = temp;
            }
            //接收第二个链表翻转后的头节点
            newHead = tail;
            //按序连接两个链表
            while (newHead != null) {
                ListNode temp = newHead.next;
                newHead.next = head.next;
                head.next = newHead;
                head = newHead.next;
                newHead = temp;
            }
        }
    }
}
