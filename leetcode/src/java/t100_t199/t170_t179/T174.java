package java.t100_t199.t170_t179;

public class T174 {
    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            //判断从起点走到终点所需的最小健康值
            //那么其实可以拆分为两个问题
            //1.怎么才能走到终点
            //即应该从终点逆序遍历，判断可达路径
            //2.在所有可行方案里，挑选所需的最小健康值
            //即计算所有可达路径里面的最小结果
            //因此，综上结论，使用动态规划方法即可
            //dp[i][j]表示走到第[i][j]格所需的健康值，终点为起始点

            //计算地图的行列数
            int rows = dungeon.length, cols = dungeon[0].length;
            //初始化dp矩阵
            int[][] dp = new int[rows][cols];
            //需要保证到达终点起码剩1点
            dp[rows - 1][cols - 1] = Math.max(1, 1 - dungeon[rows - 1][cols - 1]);
            //初始化右边界，走到每一格所剩的健康点数，必须足够走到下一格
            for (int row = rows - 2, col = cols - 1; row >= 0; row--)
                dp[row][col] = Math.max(1, dp[row + 1][col] - dungeon[row][col]);
            //初始化下边界，走到每一格所剩的健康点数，必须足够走到下一格
            for (int row = rows - 1, col = cols - 2; col >= 0; col--)
                dp[row][col] = Math.max(1, dp[row][col + 1] - dungeon[row][col]);
            //遍历地图，走到每一格所剩的健康点数，必须足够走到下一格
            //而任一格的下一格，无非就是往右或者往下，即取两个之中的最小值即可
            for (int row = rows - 2; row >= 0; row--) {
                for (int col = cols - 2; col >= 0; col--)
                    dp[row][col] = Math.max(1, Math.min(dp[row][col + 1], dp[row + 1][col]) - dungeon[row][col]);
            }
            //返回结果
            return dp[0][0];
        }
    }
}
