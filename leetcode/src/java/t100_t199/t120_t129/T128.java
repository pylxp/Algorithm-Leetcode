package java.t100_t199.t120_t129;

public class T128 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            //求最长连续序列
            //那么不难知道，重复值不算连续序列，即可以先去重
            //然后判断每个数是否包含前后位即可判断是否有连续序列
            //题目本身不难，但是要求只能有O(n)的时间复杂度
            //所以可以采用set结构特性去重，简化操作
            //然后通过找到连续序列的最大值或者最小值，选定一个方向遍历即可

            //复制数组
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums) set.add(num);
            //存放结果
            int res = 0;
            //遍历集合
            for (int num : set) {
                //如果小于自身的连续数，则跳过，知道找到最小的连续数为止
                if (!set.contains(num - 1)) {
                    int len = 1;
                    //如果存在比自身小的数，则长度加1
                    while (set.contains(num + 1)) {
                        num++;
                        len++;
                    }
                    //更新最大长度
                    res = Math.max(res, len);
                }
            }
            //返回结果
            return res;
        }
    }
}
