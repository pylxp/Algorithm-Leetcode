package java.t21_t30;

public class T21 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //首先判断是否为空，没啥好说的
            if (l1==null||l2==null)
                return (l1==null)?l2:l1;

            else if(l1.val<l2.val){
                //如果l1比较小，那么继续比较l1.next和l2,即拼接下一个最小值
                l1.next=mergeTwoLists(l1.next,l2);
                //直到跳出则表示l1遍历完了,l2直接往后拼接，返回l1
                return l1;
            }
            else {
                //如果l2比较小，那么继续比较l2.next和l1,即拼接下一个最小值
                l2.next=mergeTwoLists(l2.next,l1);
                //直到跳出则表示l2遍历完了，l1直接往后拼接，返回l2
                return l2;
            }
        }
    }
}
