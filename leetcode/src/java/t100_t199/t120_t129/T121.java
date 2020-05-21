package java.t100_t199.t120_t129;

public class T121 {
    class Solution {
        public int maxProfit(int[] prices) {
            //买卖各一次，求最大值
            //题目要求买之前不能卖，那么就等于说
            //要先减（买）再加（卖）
            //那么不难发现，只需要维护两个值
            //一个存放买卖结果，一个存放买入的价格即可
            //而买入的价格，实际上就是遍历到的最小值
            //因为遍历到大值，就更新买卖结果的最大值即可，不需保存

            //分别存放最大收益和最小购买价格
            int max = 0;
            int min = Integer.MAX_VALUE;
            //遍历价格数组
            for (int price : prices) {
                //遇到更低的价格，再更新买入价格
                if (price < min) min = price;
                //遇到更高的价格，则计算最大收益
                max = Math.max(max, price - min);
            }
            //返回最大收益
            return max;
        }
    }
}
