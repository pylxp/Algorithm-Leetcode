package java.t80_t89;

public class T86 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode partition(ListNode head, int x) {
            /*给定一个值x，将小于x的节点移动到大于等于x的节点前
             * 根据上面的题目要求，不难得出以下结论
             * 1.只需要小于x的节点移动到大于等于x的节点前，没要求排序
             * 2.那么拆分1，就等于将链表拆分成2个链表
             * 即小链表1存放小于x的节点，大链表2存放大于等于x的节点
             * 3.将两个链表合并后返回小链表1的头节点即为结果
             * */

            //创建小链表1
            ListNode smallLink = new ListNode(0);
            //链表1的操作指针
            ListNode smallNode = smallLink;
            //创建大链表2
            ListNode bigLink = new ListNode(0);
            //链表2的操作指针
            ListNode bigNode = bigLink;
            //遍历原链表
            while (head != null) {
                //小于x的值放入小链表1，同时操作指针后移
                if (head.val < x) {
                    smallNode.next = head;
                    smallNode = head;
                }
                //大于等于x的放入大链表2，同时操作指针后移
                else {
                    bigNode.next = head;
                    bigNode = head;
                }
                //原链表指针后移
                head = head.next;
            }
            //大链表2的尾部要加上null空节点作为合并后的末尾
            bigNode.next = null;
            //合并链表
            smallNode.next = bigLink.next;
            //返回小链表1的头节点，主要是第二个节点，头结点是人为创建的
            return smallLink.next;
        }
    }
}
