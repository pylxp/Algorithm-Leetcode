package java.t100_t199.t140_t149;

public class T146 {
    class LRUCache {
        //提升为全局变量方便调用
        //创建双向链表
        DLinkedNode head = new DLinkedNode(0, 0), tail = new DLinkedNode(0, 0);
        //创建HashMap
        Map<Integer, DLinkedNode> map = new HashMap<>();
        //容量
        int size;

        // 创建双向链表结构
        static class DLinkedNode {
            DLinkedNode prev, next;
            int key, value;

            DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public LRUCache(int capacity) {
            //LRU缓存机制，要求存放和取出都是O(1)时间复杂度
            //那么先总结出题目要求
            //1.LRU,即当达到容量上限时，优先清除最近最少使用的数据
            // 即需要在O(1)的时间复杂度中找到最近最少的使用的数据并且删除
            //2.在存放时，需要在O(1)时间复杂度内找到目标值，修改或者添加
            //3.在取出时，需要在O(1)时间复杂度内找到目标值
            //即增、删、改、查都必须在O(1)时间复杂度内完成
            //同时需要根据传入的参数设定容量，同时需要将最近最少使用的数据标志
            //那么根据以上要求，对比8大数据结构
            //不难发现，任何单一数据结构都难以同时满足要求
            //而要标志最近最少使用，最好的即为链表的结构，每次往末尾放入，剔除头部即可
            //同时为了满足查找的O(1),可以采用hash标志，既本题可以采用HashMap+链表的方式解答
            //也可以直接采用LinkedHashMap来解决，不过这里不做展开，使用自定义数据结构完成


            //先初始化存放结构
            //1.初始化容量
            size = capacity;
            //初始化双端链表
            head.next = tail;
            tail.prev = head;
        }

        //get方法
        public int get(int key) {
            //如果包含，取出数据
            //同时清楚原来的位置，移动到末尾
            if (map.containsKey(key)) {
                DLinkedNode node = map.get(key);
                remove(node);
                add(node);
                return node.value;
            } else return -1;
        }

        //put方法
        public void put(int key, int value) {
            //如果包含，则删除旧数据
            if (map.containsKey(key)) remove(map.get(key));
            //如果超过容量，则删除链表头，即最近最少使用的数据
            if (map.size() == size) remove(head.next);
            //同时插入当前添加的最新数据到链表尾
            add(new DLinkedNode(key, value));
        }

        //remove方法
        private void remove(DLinkedNode node) {
            //删除节点
            map.remove(node.key);
            //重构双向链表
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        //add方法
        private void add(DLinkedNode node) {
            //添加数据
            map.put(node.key, node);
            //重构双向链表，将最新数据放到末尾
            DLinkedNode preTail = tail.prev;
            node.next = tail;
            tail.prev = node;
            preTail.next = node;
            node.prev = preTail;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
