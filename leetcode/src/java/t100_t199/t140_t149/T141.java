package java.t100_t199.t140_t149;

public class T141 {
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
        public boolean hasCycle(ListNode head) {
            //判断链表是否有环，实际上就是判断是否有一个节点遍历过多次
            //那么只需要标志遍历过的节点即可
            //因此这里采用map和set都行，但是会超过题目要求的O(1)内存
            //那么这里可以采用快慢指针标志，即能满足题目的O(1)内存要求

            //先处理特殊情况
            if (head == null || head.next == null) return false;
            //建立快慢指针
            ListNode fast = head.next, slow = head;
            //遍历链表
            while (slow != fast) {
                //如果快指针遍历完了，即没有陷进去环，则返回false
                if (fast == null || fast.next == null) return false;
                //移动快慢指针
                slow = slow.next;
                fast = fast.next.next;
            }
            //返回true
            return true;
        }
    }
}
