package java.t100_t199.t160_t169;

public class T169 {
    class Solution {
        public int majorityElement(int[] nums) {
            //查找数组中的多数元素，那么实际上等通过于136题，查找只出现一次的数
            //即换个角度，怎么消除我们不想要的数
            //那么我们可以维持一个计数，如果是想要的数，加一，不是则-1即可
            //默认计数为0时，遇到的数则为想要的数
            //由于目标数超过数组一半。最后必然结果为目标数

            //存放目标数和计数
            int count = 0, res = 0;
            //遍历数组
            for (int num : nums) {
                //计数为0，则更新目标数
                if (count == 0) res = num;
                //遍历到目标数+1，不是-1
                count += (num == res) ? 1 : -1;
            }
            //返回结果
            return res;
        }
    }
}
