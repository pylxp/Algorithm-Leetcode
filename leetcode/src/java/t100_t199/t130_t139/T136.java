package java.t100_t199.t130_t139;

public class T136 {
    class Solution {
        public int singleNumber(int[] nums) {
            //求非空数组中只出现过一次的数
            //其余的数均出现2次
            //实际上题目已经给了一个重要的提示了
            //其余的数只出现两次，那么我们要找到只出现了一次的数
            //换个角度，实际上就是去除所有只出现了两次的数
            //那么怎么去除两个相同的数，不难想到，异或运算
            //根据以上思路，将整个数组遍历异或，最后剩下的即为结果

            //存放结果
            int res = 0;
            //异或每个数
            for (int num : nums) res ^= num;
            //返回结果
            return res;
        }
    }
}
