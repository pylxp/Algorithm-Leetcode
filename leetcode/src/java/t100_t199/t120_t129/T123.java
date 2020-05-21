package java.t100_t199.t120_t129;

public class T123 {
    class Solution {
        public int maxProfit(int[] prices) {
            //这题算是121、122的进阶，建议放在一起做
            //跟121、121的区别在于，只能买卖两次
            //但是同样要求买之前不能卖，那么就等于说
            //要先减（买）再加（卖）
            //那么不难发现，实际上就是
            //同122，不过总售价只算利润最大的两次
            //这里需要注意的是，第二次买入必须在第一次卖出前
            //那么这里可以在上一题的基础上，进行修改
            //这里创建四个数，分别表示四次操作的收益
            //profit1 买1 = -价格
            //profit2 卖2 = 买1 + 价格
            //profit3 买3 = 卖2 - 价格
            //profit4 卖4 = 买3 + 价格

            //分别存放四次操作的收益
            //因为买1、买3可能出现负收益，所以这里要设置预先设置个最小值，防止不买入的情况
            int profit1 = Integer.MIN_VALUE, profit2 = 0, profit3 = Integer.MIN_VALUE, profit4 = 0;
            //遍历价格数组
            for (int i = 0; i < prices.length; i++) {
                //买1的最大收益，即最小买入价格
                profit1 = Math.max(profit1, -prices[i]);
                //卖1的最大收益，即买1的收益加当前卖出价格
                profit2 = Math.max(profit2, profit1 + prices[i]);
                //买2的最大收益，即卖1的收益-当前购买价格
                profit3 = Math.max(profit3, profit2 - prices[i]);
                //卖2的最大收益，即买2的收益加当前卖出价格
                profit4 = Math.max(profit4, profit3 + prices[i]);
            }
            //返回买卖的最大价格
            return Math.max(0, Math.max(profit2, profit4));
        }
    }
}
