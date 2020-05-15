package java.t31_t40;

public class T36 {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            //由于9*9是固定的，根据题目和数独的性质，只需要判断3个条件即可
            //1.横排无重复
            //2.竖列无重复
            //3.3*3宫格内无重复
            //3*3宫格的计算：(row / 3) * 3 + col / 3
            int[][] rows = new int[9][10];
            int[][] cols = new int[9][10];
            int[][] boxs = new int[9][10];
            //9*9，固定遍历9次即可
            for (int i = 0; i < 9; ++i) {
                //9*9，固定遍历9次即可
                for (int j = 0; j < 9; ++j) {
                    //如果是‘.’，则不处理
                    if (board[i][j] == '.') continue;
                    //获取当前数的值
                    int num = board[i][j] - '0';
                    //表示这一行，这个值出现过了
                    if (rows[i][num] == 1) return false;
                    rows[i][num] = 1;
                    //表示这一列，这个值出现过了
                    if (cols[j][num] == 1) return false;
                    cols[j][num] = 1;
                    //表示3*3规格内，这个值出现过了
                    if (boxs[(i / 3) * 3 + j / 3][num] == 1) return false;
                    boxs[(i / 3) * 3 + j / 3][num] = 1;
                }
            }
            //到这就表示所有无效条件都不成立了
            return true;
        }
    }
}
