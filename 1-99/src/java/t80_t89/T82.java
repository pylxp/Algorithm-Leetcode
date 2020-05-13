package java.t80_t89;

public class T82 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            //删除排序链表中的重复元素的节点
            //根据以上要求不能得出以下结论
            //1.链表的性质，要删除重复节点，必须逐个遍历
            //2.头节点也可能重复，所以要创建一个假头节点，指针真的头节点
            //3.重复的节点全部删除，不保留任何一个，所以应该删除到下一个不重复的节点为止
            // 即需要一个辅助指针，来指向下一个不重复的节点
            //4.重复的节点可能不止2个，所以要创建一个临时指针，用于扫描当次的所有重复节点

            //先处理特殊情况
            if (head == null || head.next == null) return head;
            //创建假头节点，指向真头节点
            ListNode newHead = new ListNode(-1);
            newHead.next = head;
            //用于指向下一个不重复的节点
            ListNode nextNode = newHead;
            //遍历链表，由于是比较，所以每次都需要最少遍历两个节点
            while (nextNode.next != null && nextNode.next.next != null) {
                //如果出现重复
                if (nextNode.next.val == nextNode.next.next.val) {
                    //临时节点，用于扫描当次的所有的重复节点
                    ListNode temp = nextNode.next;
                    //扫描所有的重复节点
                    while (temp.next != null && temp.val == temp.next.val) {
                        temp = temp.next;
                    }
                    //开始下一个重复节点的遍历
                    nextNode.next = temp.next;
                }
                //指向下一个不重复的节点
                else nextNode = nextNode.next;
            }
            //返回真头节点
            return newHead.next;
        }
    }
}
