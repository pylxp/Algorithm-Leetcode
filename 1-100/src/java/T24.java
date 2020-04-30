package java;

public class T24 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            //创建一个新的假头节点，用于辅助简化操作
            ListNode newHead = new ListNode(0);
            //链接旧的头节点
            newHead.next = head;
            //创建一个临时节点，用作操作链表
            // 可以理解为，新（逻辑上的新，已完成交换的部分）链表的尾节点
            ListNode tailNode = newHead;
            //至少两个节点都不为空，才有必要交换
            while ((head != null) && (head.next != null)) {

                //preNode为前一个节点，postNode为后一个节点
                ListNode preNode = head;
                ListNode postNode = head.next;

                //交换节点，三步
                //1.即新链表尾节点链接后一个节点
                tailNode.next = postNode;
                //2.前一个节点，指向后一个节点的后一个节点
                preNode.next = postNode.next;
                //3.后一个节点连接前一个节点
                postNode.next = preNode;

                //tailNode指向尾节点
                tailNode = preNode;
                //往后移，继续交换后两个节点
                head = preNode.next;
            }
            //返回结果
            return newHead.next;
        }
    }
}
