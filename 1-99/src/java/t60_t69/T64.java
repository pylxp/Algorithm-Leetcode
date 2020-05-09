package src.java.t60_t69;

public class T64 {
    class Solution {
        public int minPathSum(int[][] grid) {
            //这题跟62，63相似，建议放在一起做
            //典型的动态规划问题
            //由于路径图已经给了，可以直接用来当作动态规划图

            //先获取行列数
            int rows = grid.length, cols = grid[0].length;
            //第一行，步长等于前一列加上自身
            for (int i = 1; i < cols; i++)
                grid[0][i] += grid[0][i - 1];

            //处理第一列，步长等于前一行加上自身
            for (int i = 1; i < rows; i++)
                grid[i][0] += grid[i - 1][0];

            //遍历剩余每一行
            for (int i = 1; i < rows; i++)
                //遍历剩余每一列
                for (int j = 1; j < cols; j++)
                    //步长等于自身加上前一列或前一行的最小值
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);

            //返回结果
            return grid[rows - 1][cols - 1];
        }
    }
}
