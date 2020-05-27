package java.t100_t199.t160_t169;

public class T160 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            //找到两个单链表相交的起始节点
            //那么不难发现，从相交开始，两个节点必然相同
            //那么问题就换成了，怎么让两个节点同时找到相交节点
            //到这里不难想到。走同样的长度即可
            //即A节点走完a，再走b
            //B节点走完b，再走a
            //即A、B节点所走的路程都为a+b
            //由于相交的部分完全相同，假设长度为c
            //那么两个节点必然会在a+b-c的时候相遇，即为结果


            //分别用于操作两个链表
            ListNode tempA = headA, tempB = headB;
            //如果两个节点不相等，则继续往后便利
            while (tempA != tempB) {
                //走完A走B
                tempA = tempA != null ? tempA.next : headB;
                //走完B走A
                tempB = tempB != null ? tempB.next : headA;
            }
            //返回相交节点，A、B都行
            return tempA;
        }
    }
}
