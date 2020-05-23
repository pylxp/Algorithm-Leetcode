package java.t100_t199.t130_t139;

public class T133 {
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

    class Solution {
        //提取为全局变量，方便调用
        //key表示原节点，value表示克隆的节点
        HashMap<Node, Node> visited = new HashMap<>();

        public Node cloneGraph(Node node) {
            //深拷贝图，不能通过复制指针地址来拷贝
            //必须通过new来创建新的节点
            //那么毫无疑问需要遍历每个节点
            //同时遍历每个结点的时候，还要遍历其链接关系，即邻居节点
            //那么可以通过HashMap的结构，来一一对应源节点和克隆节点
            //从而确保每个结点的遍历完整且不重复遍历

            //先设立终止条件
            if (node == null) return node;
            //如果当前节点已经遍历过，则取出其克隆节点即可
            if (visited.containsKey(node)) return visited.get(node);
            //创建克隆节点，克隆节点的值，同时创建邻居节点列表
            Node cloneNode = new Node(node.val, new ArrayList());
            //存放对应的克隆关系
            visited.put(node, cloneNode);
            //遍历其邻居列表并存入
            for (Node neighbor : node.neighbors) cloneNode.neighbors.add(cloneGraph(neighbor));
            //返回克隆节点
            return cloneNode;
        }
    }
}
