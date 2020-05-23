package java.t100_t199.t130_t139;

public class T138 {
    /*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

    class Solution {
        public Node copyRandomList(Node head) {
            //这题跟133相似，建议放在一起做
            //参考133的解法，这里同样采用HashMap即可
            //即遍历每一个节点，用hashmap存储每个节点和对应的拷贝节点

            //先处理特殊情况
            if (head == null) return null;
            //用于存放每个节点对应的拷贝节点
            HashMap<Node, Node> map = new HashMap<>();
            //指向头节点用于操作
            Node temp = head;
            //复制节点基本数据
            while (temp != null) {
                map.put(temp, new Node(temp.val));
                temp = temp.next;
            }
            //重新遍历
            temp = head;
            //复制节点的下一个节点和随即节点
            while (temp != null) {
                map.get(temp).next = map.get(temp.next);
                map.get(temp).random = map.get(temp.random);
                temp = temp.next;
            }
            //返回头节点
            return map.get(head);
        }
    }
}
