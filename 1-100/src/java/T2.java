package java;

public class T2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //由于题目规定两个都是非空链表，那么如果其中一个是0，则可以直接返回另一个链表作为结果
            if((l1.val==0&&l1.next==null)||(l2.val==0&&l2.next==null)){
                return (l1.next==null&&l1.val==0)?l2:l1;
            }
            //创建res节点作为待返回的结果
            ListNode res = new ListNode(0);
            //创建temp临时节点用于操作res结果节点
            ListNode temp = res;
            //进位符号carry
            int carry=0,num1,num2,sum;
            //只要其中一个节点没有遍历完，就要继续遍历
            //这里之所以不在一个节点为空时，直接继承非空节点，是因为可能出现  1+99999...=100000...这种特殊情况
            while (l1 != null || l2 != null) {
                //读取当前两个节点的值，为空则值为0
                num1 = (l1 != null) ? l1.val : 0;
                num2 = (l2 != null) ? l2.val : 0;
                //！！！重点，计算要加上进位
                sum = carry + num1 + num2;
                //！！！重点，取进位
                carry = sum / 10;
                //！！！重点，余数才是节点值
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
                //遍历计算下一位
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            //！！！重点，不能漏了最后可能存在的进位
            if (carry > 0) {
                temp.next = new ListNode(carry);
            }
            //返回结果
            return res.next;
        }
    }
}
