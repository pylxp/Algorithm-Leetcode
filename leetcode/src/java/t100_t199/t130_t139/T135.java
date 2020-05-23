package java.t100_t199.t130_t139;

public class T135 {
    class Solution {
        public int candy(int[] ratings) {
            //分发糖果，根据题目要求，简述为以下两个条件
            //1.没人最少获得一个
            //2.评分高于周边的，必须多分
            //假设存在极端情况，即1234321
            //不难发现，正确的分发方法如下
            //1.确保每个孩子先获得一个
            //2.从左往右遍历，如果比前一位高，则在其基础上+1
            // 即先解决比左边高的情况
            //3.从右往左遍历，如果比后一位高，则在其基础上+1
            // 再解决比右边高的情况
            //最后比较左右遍历的最大值，即最少分发的糖果数

            //存放结果
            int res = 0;
            //存放每个小孩获得的最小糖果数
            int[] candys = new int[ratings.length];
            Arrays.fill(candys, 1);
            //从左往右遍历
            for (int i = 1; i < ratings.length; i++)
                //如果大于左边，则在其基础上+1
                if (ratings[i] > ratings[i - 1]) candys[i] = candys[i - 1] + 1;

            //从右往左遍历
            for (int i = ratings.length - 2; i >= 0; i--) {
                //如果大于右边，且糖果数小于右边，则在其基础上+1
                //这里debug就理解了，因为右边值的先遍历更新了，所以比较有意义
                if (ratings[i] > ratings[i + 1] && candys[i] <= candys[i + 1]) candys[i] = candys[i + 1] + 1;
                //求和
                res += candys[i];
            }

            //返回结果,这里注意，要加上最右边的最大值，即从左往右遍历的最后一位
            return res + candys[ratings.length - 1];
        }
    }
}
