package java.t1_t99.t90_t99;

public class T92 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            //这题跟24，25相似，建议放在一起做
            //翻转m~n的链表
            //其实一句话就不能得出以下结论
            //1.要完成两个节点的翻转，好比两个数的翻转，我们需要3个内存空间
            // 即除了head外，还需要额外创建2个节点，同时还需要一个新的头节点保存结果用于返回

            //创建新头节点，指向旧头节点
            ListNode newHead=new ListNode(0);
            newHead.next=head;
            //创建两个辅助交换的节点
            ListNode preNode=newHead;
            //计数m，找到第m-1个节点
            while (m>1){
                preNode=preNode.next;
                m--;
                n--;
            }
            //head指向即将要翻转第1个的节点
            head=preNode.next;
            //开始翻转，直到第n个节点
            while (n>1){
                //指向即将要翻转的第2个节点
                ListNode postNode = head.next;
                //指向第2个节点的后一个节点
                head.next = postNode.next;
                //第二个节点指向第一个节点
                postNode.next = preNode.next;
                //原节点指向第二个节点
                preNode.next = postNode;
                //n--
                n--;
            }
            return newHead.next;
        }
    }
}
