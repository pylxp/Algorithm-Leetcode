package java.t100_t199.t190_t199;

public class T191 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            //计算1的个数（也被称为汉明重量）
            //不难想到，将每一位与1与计算，统计个数即可

            //存放结果
            int res = 0;
            //遍历
            for (int i = 0; i <= 31; i++)
                //每一位进行与计算
                res += (n >> i & 1) == 1 ? 1 : 0;
            //返回结果
            return res;
        }
    }
}
