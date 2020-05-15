package src.java.t60_t69;

public class T61 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            //旋转链表，这题跟19，24，25相似，建议放在一起做
            //本质上就是链表的重排序问题
            //题目要求链表整体向右移动k个位置
            //那么换个角度来看，假设整个链表是个闭环
            //右移k个节点，就等同于倒数第k个节点成为新的头节点
            //倒数第k+1节点新的尾节点，同时末尾断开环

            //处理特殊情况
            if (head == null || head.next == null || k == 0) return head;
            // tailNode原链表的尾节点，用于闭环
            // kNode倒数第k+1个节点，即为新的尾节点
            // resNode倒数第k个节点,即为新的头节点
            ListNode tailNode = head;
            ListNode kNode = head;
            ListNode resNode;
            //记录链表总长度，可以避免k过大，跑无效圈数
            int len = 1;
            //计算链表长度
            for (; tailNode.next != null; tailNode = tailNode.next)
                len++;
            //更新k值，减少无效圈数
            k = k % len;
            //即移动步数刚好等同于n倍len，等同于没有移动
            if (k == 0) return head;
            //闭环
            tailNode.next = head;
            //开始找倒数第k+1个节点
            for (int i = 0; i < len - k - 1; i++)
                kNode = kNode.next;
            //此时倒数第k+1个节点即为新的尾节点，下一个节点即为新的头节点
            //指向新的头节点，即结果节点
            resNode = kNode.next;
            //解环
            kNode.next = null;
            //返回结果
            return resNode;
        }
    }
}
