package java.t200_t299.t200_t209;

public class T200 {
    class Solution {
        public int numIslands(char[][] grid) {
            //判断岛屿数量，即判断有多少块不相连的1
            //即简单的矩阵遍历，满足以下条件即为独立岛屿
            //1.本身为1
            //2.上下左右都为0或者遍历过的1(这里可以将已经遍历过的标志为0)

            //存放结果
            int res = 0;
            //遍历行
            for (int row = 0; row < grid.length; row++) {
                //遍历列
                for (int col = 0; col < grid[0].length; col++) {
                    //如果满足条件1.本身为1
                    if (grid[row][col] == '1') {
                        //判断是否满足条件2.上下左右都为0
                        dfs(grid, row, col);
                        //岛屿数量+1
                        res++;
                    }
                }
            }
            //返回结果
            return res;
        }

        /**
         * @Author: Lxp
         * @Description:遍历上下左右的方法
         * @Date: 2020/6/3
         * @Param grid:待遍历的矩阵
         * @Param row:遍历的行数
         * @Param col:遍历的列数
         * @return: void
         **/
        public void dfs(char[][] grid, int row, int col) {
            //先设立终止条件
            if (row < 0 || col < 0 || row >= grid.length
                    || col >= grid[0].length || grid[row][col] == '0') return;
            //已经遍历过标志为0
            grid[row][col] = '0';
            //遍历上下左右
            dfs(grid, row - 1, col);
            dfs(grid, row + 1, col);
            dfs(grid, row, col - 1);
            dfs(grid, row, col + 1);
        }
    }
}
