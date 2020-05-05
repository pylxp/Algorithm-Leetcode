package java.t31_t40;

public class T37 {
    class Solution {
        //由于9*9是固定的，根据题目和数独的性质，只需要判断3个条件即可
        //1.横排无重复
        //2.竖列无重复
        //3.3*3宫格内无重复
        //3*3宫格的计算：(row / 3) * 3 + col / 3
        //这里设为10列，方便取值，第0列不做处理
        //提升为全局变量，方便调用
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxs = new boolean[9][10];
        //标志位，判断数独填写是否冲突
        boolean flag = false;

        public void solveSudoku(char[][] board) {
            //这题基本算是36的扩展，建议放在一起做
            ////9*9，固定遍历9次即可
            for (int i = 0; i < 9; i++) {
                //9*9，固定遍历9次即可
                for (int j = 0; j < 9; j++) {
                    //如果是‘.’，则不处理
                    if (board[i][j] != '.') {
                        //获取当前数的值
                        int num = board[i][j] - '0';
                        //表示这一行，这个值出现过了
                        rows[i][num] = true;
                        //表示这一列，这个值出现过了
                        cols[j][num] = true;
                        //表示3*3规格内，这个值出现过了
                        boxs[(i / 3) * 3 + j / 3][num] = true;
                    }
                }
            }
            //开始进入数独填充方法
            dfs(board, 0, 0);
        }

        //数独填充方法，row表示当前要填写的行，col表示当前要填写的列
        public void dfs(char[][] board, int row, int col) {
            //表示0-8行已经全部填写完毕
            if (row == 9) {
                flag = true;
                return;
            }
            //不是‘.'则不需要填写，向后移动
            if (board[row][col] != '.') {
                //如果本列已经是最后一列，则继续填写下一行的第一列
                if (col == 8) dfs(board, row + 1, 0);
                    //否则继续往下一列填写
                else dfs(board, row, col + 1);
            } else {
                //计算当前位于第几个3*3子数独块
                int box = row / 3 * 3 + col / 3;
                //这里是指数字1-9，置空不处理
                for (int i = 1; i < 10; i++) {
                    //如果数字i在行、列、3*3都没出现过，可以填入
                    if (!rows[row][i] && !cols[col][i] && !boxs[box][i]) {
                        //填入该值
                        board[row][col] = (char) (i + '0');
                        //表示该数字在行、列、3*3都出现过
                        rows[row][i] = cols[col][i] = boxs[box][i] = true;
                        //如果本列是最后一列，则继续填写下一行的第一列
                        if (col == 8) dfs(board, row + 1, 0);
                            //否则往下一列继续填写
                        else dfs(board, row, col + 1);
                        //如果当前填入的数字组合冲突，则回溯
                        if (!flag) {
                            //清除当前填写的数字
                            board[row][col] = '.';
                            //将标志位同时清空
                            rows[row][i] = cols[col][i] = boxs[box][i] = false;
                        }
                    }
                }
            }
        }
    }
}
