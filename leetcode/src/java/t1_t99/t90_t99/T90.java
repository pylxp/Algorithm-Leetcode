package java.t1_t99.t90_t99;

public class T90 {
    class Solution {
        //提取为全局变量，方便调用
        //首先根据返回类型创建结果集
        List<List<Integer>> res = new ArrayList<>();
        //创建临时列表，存放单次遍历的结果
        List<Integer> list = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            //这题跟47，46，41，40相似，建议一起做
            //而对于去重，首先考虑的自然就是剪枝
            //而剪枝的前提自然是有序，所以要先对数组进行排序

            //先处理特殊情况
            if (nums == null || nums.length == 0) return new ArrayList<>();
            //排序，方便剪枝去重
            Arrays.sort(nums);
            //调用方法
            dfs(nums, 0);
            //返回结果
            return res;
        }

        /**
         * @Author: Lxp
         * @Description: 回溯剪枝算法
         * @Date: 2020/5/13
         * @Param nums: 待遍历的数组
         * @Param start: 遍历起始索引
         * @return: void
         **/
        public void dfs(int[] nums, int start) {
            //添加进结果列表
            res.add(new ArrayList<>(list));
            ///每次遍历从start开始，即剪枝
            for (int i = start; i < nums.length; i++) {
                //跳过已使用的重复元素，保证结果不重复
                if (i != start && nums[i] == nums[i - 1]) continue;
                //添加进临时结果
                list.add(nums[i]);
                //往下继续遍历
                dfs(nums, i + 1);
                //删除最后一个元素，即回溯
                list.remove(list.size() - 1);
            }
        }
    }
}
