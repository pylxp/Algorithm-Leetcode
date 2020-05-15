package java.t1_t99.t80_t89;

public class T85 {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            //这题跟84类似，可以遍历每一行后已行为矩阵，调用84的单调栈方法进行计算
            //不过如果行数过多的情况下，会有多次的遍历转换，效率不高
            //不过根据以上的想法，我们可以明显感受到，每一行的高度都受上一行影响
            //所以这里可以采用动态规划的方法来进行遍历计算

            //先处理特殊情况
            if (matrix.length == 0 || matrix[0].length == 0) return 0;

            //获取行列数
            int rows = matrix.length;
            int cols = matrix[0].length;
            //动态规划矩阵，dp[i][j]表示第i行第j列的坐标的高度
            int[][] dp = new int[rows][cols];
            //初始化结果和初始化矩阵头部
            int res = dp[0][0]=matrix[0][0]-'0';
            // 初始化dp矩阵第一列，
            for (int i = 1; i < rows; i++) {
                // 每个点的高度=上一行同一列的点的高度+1
                dp[i][0] = matrix[i][0] == '1' ? dp[i - 1][0] + 1 : 0;
                //保存第一列的最大高度
                res = Math.max(dp[i][0], res);
            }
            // 初始化第一行
            // rowMax统计第一行的最大连续值
            int rowMax = dp[0][0];
            for (int j = 1; j < cols; j++) {
                //如果为1，则高度为1，否则为0
                if (matrix[0][j] == '1') {
                    rowMax++;
                    dp[0][j] = 1;
                    //保存第一行和第一列最大值中的最大值
                    res = Math.max(rowMax, res);
                } else rowMax = dp[0][j] = 0;
            }
            // 开始动态递归
            //遍历除第一行外每一行
            for (int i = 1; i < rows; i++) {
                //遍历除第一列外每一列
                for (int j = 1; j < cols; j++) {
                    //该位置==1，则处理，否则高度设为0即可
                    if (matrix[i][j] == '1') {
                        // 更新当前位置的高度
                        int minLength = dp[i][j] = dp[i - 1][j] + 1;
                        // 计算当前列的面积
                        res = Math.max(res, minLength);
                        // 向左扫描每一列，计算矩阵面积
                        for (int k = j - 1; k >= 0 && matrix[i][k] == '1'; k--) {
                            // 获取连续列中的最小高度
                            minLength = Math.min(minLength, dp[i][k]);
                            // 计算面积并更新最大面积
                            res = Math.max(res, minLength * (j - k + 1));
                        }
                    } else dp[i][j] = 0;
                }
            }
            //返回结果
            return res;
        }
    }
}
