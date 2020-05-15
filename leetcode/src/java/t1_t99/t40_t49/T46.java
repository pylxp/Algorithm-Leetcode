package java.t1_t99.t40_t49;

public class T46 {
    class Solution {
        //提取为全局变量，方便调用
        //首先根据返回类型创建结果集
        List<List<Integer>> res = new ArrayList<>();
        //创建临时列表，存放单词遍历的结果
        List<Integer> list = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            //创建标志数组，表示某个数是否已经遍历过
            boolean[] visited = new boolean[nums.length];
            //典型的回溯算法题，这题可采取dfs/bfs，这里主要讲解dfs
            dfs(nums, 0, visited);
            //返回结果
            return res;
        }

        //编写dfs算法
        //nums需要遍历的数组，len已遍历的长度，visited标志列表
        public void dfs(int[] nums, int len, boolean[] visited) {
            //dfs/bfs/回溯等递归调用的方法，第一步，优先编写退出条件
            //即列表长度达到数组长度，即单次遍历结束
            if (len == nums.length) {
                //将结果放入结果集
                res.add(new ArrayList<>(list));
                //退出遍历
                return;
            }
            //循环遍历每一个值
            for (int i = 0; i < nums.length; i++) {
                //如果该数没有遍历过，则可以使用
                if (!visited[i]) {
                    //更新标志位
                    visited[i] = true;
                    //将该数放入列表
                    list.add(nums[i]);
                    //往下继续遍历
                    dfs(nums, len + 1, visited);
                    //重点！当回溯时，一定要删除之前添加的值
                    list.remove(list.size() - 1);
                    //同时要把标志位重置
                    visited[i] = false;
                }
            }
        }
    }
}
