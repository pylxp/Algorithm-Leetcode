package java.t100_t199.t140_t149;

public class T147 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            //插入排序，即遍历每一个数，将其放到比他小的数前面
            //那么可以新建一个假的头节点
            //然后按序每次取出待排序的一个节点，与已排序列表对比插入即可

            //先处理特殊情况
            if (head == null || head.next == null) return head;
            //创建一个假的头节点
            ListNode newHead = new ListNode(0);
            //拼接旧头节点
            newHead.next = head;
            ListNode tailNode = head;
            ListNode nextNode = head.next;
            //遍历链表
            while (nextNode != null) {
                //如果新增节点大于已排序已排序节点的最大值
                //则更新已排序节点的最大值
                if (nextNode.val >= tailNode.val) {
                    //更新已排序的尾节点，同时遍历下一个节点
                    tailNode = nextNode;
                    nextNode = nextNode.next;
                }
                //否则则遍历到合适的位置插入
                else {
                    ListNode temp = newHead;
                    while (temp.next.val < nextNode.val) temp = temp.next;
                    //更新已排序链表的尾节点
                    tailNode.next = nextNode.next;
                    nextNode.next = temp.next;
                    temp.next = nextNode;
                    //遍历下一个待排序节点
                    nextNode = tailNode.next;
                }
            }
            //返回真的头节点
            return newHead.next;
        }
    }
}
