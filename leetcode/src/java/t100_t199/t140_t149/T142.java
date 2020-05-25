package java.t100_t199.t140_t149;

public class T142 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            //这题跟141相似，建议放在一起做
            //判断链表是否有环，实际上就是判断是否有一个节点遍历过多次
            //那么只需要标志遍历过的节点即可
            //因此这里采用map和set都行，但是会超过题目要求的O(1)内存
            //那么这里可以采用快慢指针标志，即能满足题目的O(1)内存要求
            //假设起点到入口为k，环长度为q，快指针步数f，慢指针步数s
            //同时快指针是慢指针的两倍，即快指针和慢指针第一次相遇时
            //fast=f=2slow=2s，且由于相遇必然是在环内，即fast比slow多走了n圈
            //即fast-slow=f-s=s=nq
            //此时重置fast到起点，两指针各走一步，则会在入口相遇，即nq+k

            //创建快慢指针
            ListNode fast = head, slow = head;
            //先找到环
            while (true) {
                //如果没有进入环，则直接返回null
                if (fast == null || fast.next == null) return null;
                //移动快慢指针
                fast = fast.next.next;
                slow = slow.next;
                //如果两个指针碰撞了，则退出循环，表明slow指针已经走了nq步
                if (fast == slow) break;
            }
            //重置快指针
            fast = head;
            //遍历链表，走到入口
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            //返回入口
            return fast;
        }
    }
}
