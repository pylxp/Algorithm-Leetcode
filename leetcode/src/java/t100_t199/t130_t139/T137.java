package java.t100_t199.t130_t139;

public class T137 {
    class Solution {
        public int singleNumber(int[] nums) {
            //这题跟136类似，建议放在一起做
            //求非空数组中只出现过一次的数
            //其余的数均出现3次
            //换个角度，实际上就是去除所有出现了3次的数
            //那么怎么去除3个相同的数
            //根据上一题，我们知道了异或可以去除2个相同的数
            //那么怎么样区分出现1次和3次，不难想到，在出现2次的时候，打个标记即可
            //根据以上思路，将整个数组遍历异或，最后剩下的即为结果

            //记录出现1次和2次的标志
            int one = 0, two = 0;
            //异或每个数
            for (int num : nums) {
                //第一次出现，则异或并记录，同时清楚第二次出现的标志
                one = ~two & (one ^ num);
                //第二次出现，则异或并记录，同时清除第一次出现的标志
                two = ~one & (two ^ num);
            }
            //返回结果
            return one;
        }
    }
}
