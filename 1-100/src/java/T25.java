package java;

public class T25 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {

        public ListNode reverseKGroup(ListNode head, int k) {
            //这里实际上则是24题的扩展，建议一起做
            //创建一个新的假头节点，用于辅助简化操作
            ListNode newHead = head;
            //index做索引，判断剩余节点是否满足k
            int index = 0;
            //将head指向第 k+1个节点
            while (index < k && newHead != null) {
                newHead = newHead.next;
                index++;
            }
            //为空则表示不足k个节点，不翻转直接返回
            if (index < k) return head;
            //传入后面未翻转的部分递归,resNode接受翻转后的结果
            //注意，这里的newHead是第k+1个节点
            ListNode resNode = reverseKGroup(newHead, k);
            //翻转链表，返回翻转链表的头节点
            return reverse(head, resNode, k);
        }

        //head传入本次翻转的头节点，resNode为已翻转的头节点，k为翻转次数
        public ListNode reverse(ListNode head, ListNode resNode, int k) {
            while (k > 0) {
                //截取待翻转链表的尾巴(即独立出头节点)
                ListNode nextNode = head.next;
                //指向已翻转链表的头节点
                head.next = resNode;
                //更新已翻转链表的头节点
                resNode = head;
                //更新待翻转链表的头节点
                head = nextNode;
                k--;
            }
            //返回已翻转链表的头节点
            return resNode;
        }

    }
}
