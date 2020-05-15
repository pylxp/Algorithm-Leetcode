package java.t1_t99.t40_t49;

public class T47 {
    class Solution {
        //提取为全局变量，方便调用
        //首先根据返回类型创建结果集
        List<List<Integer>> res = new ArrayList<>();
        //创建临时列表，存放单词遍历的结果
        List<Integer> list = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            //这题跟46，41，40相似，建议一起做
            //这题跟46的主要区别在于，出现了可重复数字，导致结果的去重比较麻烦
            //而对于去重，首先考虑的自然就是剪枝
            //而剪枝的前提自然是有序，所以要先对数组进行排序
            Arrays.sort(nums);
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
                //如果该值被遍历过，则跳过
                if (visited[i]) continue;
                //关键，遇到同值跳过，保证每层遍历只会取到同值一次
                //并且每次取得都是最后一个同值
                //防止出现多次重复遍历
                if (i < nums.length - 1 && nums[i] == nums[i + 1] && !visited[i + 1])
                    continue;
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
