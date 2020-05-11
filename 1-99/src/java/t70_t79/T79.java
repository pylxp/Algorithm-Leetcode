package java.t70_t79;

public class T79 {
    class Solution {
        //提取为全局变量，方便调用
        //获取矩阵行列数
        int rows;
        int cols;

        public boolean exist(char[][] board, String word) {
            //判断单词是否存在于矩阵中，类似八皇后及数独问题，典型的dfs+回溯算法
            // 区别在于
            //八皇后:行列对角线不重复
            //数独：行列，3*3不重复
            //判断单词：行列必须连续

            //获取矩阵行列数
            rows = board.length;
            cols = board[0].length;

            //由于矩阵的每个点都可以是单词的起点，所有逐个遍历不可避免
            //遍历每一行
            for (int i = 0; i < rows; i++)
                //遍历每一列
                for (int j = 0; j < cols; j++)
                    //调用遍历方法
                    if (dfs(board, word, i, j, 0)) return true;

            //不匹配则返回false
            return false;
        }

        /**
         * @Author: Lxp
         * @Description: 递归回溯算法
         * @Date: 2020/5/11
         * @Param board: 矩阵
         * @Param word: 需要匹配的单词
         * @Param row: 行坐标
         * @Param col: 列坐标
         * @Param k: 已匹配长度
         * @return: boolean 判断是否包含
         **/
        public boolean dfs(char[][] board, String word, int row, int col, int k) {
            //先设立终止条件
            //简单区分则只有两种情况，一种true，一种false

            //已经匹配完全，则返回true
            if (k == word.length()) return true;
            //1.索引超出矩阵边界，fanhuifalse
            //2.当前坐标不匹配，返回false
            if (row < 0 || col < 0 || row == rows || col == cols
                    || board[row][col] != word.charAt(k)) return false;

            //到这里则表示当前位置匹配
            //那么就剩四种情况，分别为往上下左右遍历
            //这里先把当前位清空，防止多次遍历
            char temp = board[row][col];
            board[row][col] = ' ';
            //上
            if (dfs(board, word, row - 1, col, k + 1)) return true;
            //下
            if (dfs(board, word, row + 1, col, k + 1)) return true;
            //左
            if (dfs(board, word, row, col - 1, k + 1)) return true;
            //右
            if (dfs(board, word, row, col + 1, k + 1)) return true;
            //还原当前位
            board[row][col] = temp;
            //不匹配则返回false
            return false;
        }
    }
}
