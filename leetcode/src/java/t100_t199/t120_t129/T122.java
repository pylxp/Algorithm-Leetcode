package java.t100_t199.t120_t129;

public class T122 {
    class Solution {
        public int maxProfit(int[] prices) {
            //这题算是121的进阶，建议放在一起做
            //跟121的区别在于，不限制买卖次数
            //但是同样要求买之前不能卖，那么就等于说
            //要先减（买）再加（卖）
            //那么不难发现，实际上就是
            //初始化买入价格，遍历顺序最大值，遇到逆序则回退一位卖出
            //同时更新下一次买入价格
            //即跟上一题相同，同样只需要维护两个值，买入和总售价即可

            //先处理特殊情况
            if (prices.length <= 1) return 0;
            //分别存放最小买入价格和总收益
            int buyMin = prices[0];
            int sum = 0;
            //遍历价格数组
            for (int i = 1; i < prices.length; i++) {
                //出现逆序，则卖出同时重新买入
                if (prices[i] < prices[i - 1]) {
                    sum += prices[i - 1] - buyMin;
                    buyMin = prices[i];
                }
            }
            //添加最后一次的价格
            sum += Math.max(0, prices[prices.length - 1] - buyMin);
            //返回最大收益
            return sum;
        }
    }
}
