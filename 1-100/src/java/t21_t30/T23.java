package java.t21_t30;

public class T23 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        //这题可以和21题一起做，实际上就是21题的扩展
        //提升为全局变量，方便调用取值
        ListNode[] list;

        public ListNode mergeKLists(ListNode[] lists) {
            //首先判断特殊情况
            if (lists.length == 0) return null;
            //提升为全局变量
            list = lists;
            //这题实际上是21题的扩展，由2条链表变成了n条
            //那么采用分治的方法，重新简化成2条链表的合并即可
            return divide(0, lists.length - 1);
        }

        //left/right分别表示两条合并链表的索引
        //这里是拆分的方法
        public ListNode divide(int left, int right) {
            //left==right,即表示只剩一条链表，即为结果
            if (left == right) return list[left];
            //取中间值作为分治区间
            int mid = left + (right - left) / 2;
            //左半区继续拆分
            ListNode leftNode = divide(left, mid);
            //右半区继续拆分
            //之所以这里+1，不在上面-1，是因为奇数时更合理
            ListNode rightNode = divide(mid + 1, right);
            //到这里才是真的调用合并方法
            return mergeTwoLists(leftNode, rightNode);
        }

        //这是21题的算法，这里偷个懒直接调用了
        //这里是合并的方法
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //首先判断是否为空，没啥好说的
            if (l1 == null || l2 == null)
                return (l1 == null) ? l2 : l1;

            else if (l1.val < l2.val) {
                //如果l1比较小，那么继续比较l1.next和l2,即拼接下一个最小值
                l1.next = mergeTwoLists(l1.next, l2);
                //直到跳出则表示l1遍历完了,l2直接往后拼接，返回l1
                return l1;
            } else {
                //如果l2比较小，那么继续比较l2.next和l1,即拼接下一个最小值
                l2.next = mergeTwoLists(l2.next, l1);
                //直到跳出则表示l2遍历完了，l1直接往后拼接，返回l2
                return l2;
            }
        }
    }
}
