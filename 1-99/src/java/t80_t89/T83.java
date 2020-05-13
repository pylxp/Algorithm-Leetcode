package java.t80_t89;

public class T83 {
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
            //这题跟82相似，区别只在于重复节点保留了一个，82重复节点不保留
            //删除排序链表中的重复元素的节点
            //根据以上要求不能得出以下结论
            //1.链表的性质，要删除重复节点，必须逐个遍历
            //2.头节点即便重复也可以保留，所以不用创建一个假头节点
            //3.重复的节点不全部删除，保留一个，所以应该删除到下一个不重复的节点为止
            // 即需要一个辅助指针，来指向下一个不重复的节点
            //4.重复的节点可能不止2个，所以要创建一个临时指针，用于扫描当次的所有重复节点

            //先处理特殊情况
            if (head == null || head.next == null) return head;
            //用于指向下一个不重复的节点
            ListNode nextNode = head;
            //遍历链表，由于是比较，所以每次都需要最少遍历两个节点
            while (nextNode.next != null) {
                //如果出现重复
                if (nextNode.val == nextNode.next.val) {
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
            return head;
        }
    }
}
