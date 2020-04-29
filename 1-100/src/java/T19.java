package java;

public class T19 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //由于要删除的是倒数第n个节点，那么换个思路，就等于删除第k(k=总个数-n)个节点
            //所以这里要两个索引遍历，题目保证了n的有效性，就不用多余的排除了
            //添加一个多余的头节点，可以简化删除的节点刚好是第一个的情况
            ListNode newHead = new ListNode(0);
            //连接旧的头节点
            newHead.next = head;
            //tailNode用于遍历到尾节点,kNode用于指向要删除的节点
            ListNode tailNode = newHead;
            ListNode kNode = newHead;
            //即将tailNode和kNode节点拉开n个差距
            //因为新增了一个假节点，所以要多遍历一次，即 n==0也要
            while (n >= 0) {
                n--;
                tailNode = tailNode.next;
            }
            //将tailNode遍历到底，kNode紧随保持n个差距
            while (tailNode != null) {
                tailNode = tailNode.next;
                kNode = kNode.next;
            }
            //删除第k(由于新增了一个假节点，所以k.next才是要删除的，即倒数第n个节点)
            kNode.next = kNode.next.next;
            //排除新增的假头节点
            return newHead.next;
        }
    }
}
