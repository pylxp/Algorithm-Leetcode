package src.java.t50_t59;

public class T51 {
    class Solution {
        //提取为全局变量，方便调用
        //先创建好结果集
        List<List<String>> res = new ArrayList<>();
        //因为多次转换填充棋盘其实没有必要，所以这里可以先初始化棋盘
        char[][] chessBoard;
        //根据八皇后的特性，建立三个标志组
        //1.判断竖列是否冲突
        boolean[] cols;
        //2.判断主对角线是否冲突
        boolean[] mainDiag;
        //3.判断副对角线是否冲突
        boolean[] deputyDiag;

        public List<List<String>> solveNQueens(int n) {
            //经典的八皇后问题，区别只在于n==8变成了可变参数
            //根据八皇后问题的特性，实际上我们可以分为几个点来理解
            //参考数独，横竖，3*3不能存放相同数
            //实际上八皇后问题也类似数独问题，只是判断条件发生了变化
            //1.横竖不能放，这点跟数独一样
            //2.两条斜对角线不能放，等同于将数独的3*3换成了对角线
            //那么根据这个思路，其实两种问题的解法都是典型的回溯算法
            //参考题目36，37，建议一起做

            //初始化棋盘
            chessBoard = new char[n][n];
            for (char[] ch : chessBoard) {
                Arrays.fill(ch, '.');
            }
            //初始化三个标志组
            cols = new boolean[n];
            mainDiag = new boolean[2 * n + 1];
            deputyDiag = new boolean[2 * n - 1];
            //调用遍历方法
            dfs(n, 0);
            //返回结果
            return res;
        }

        //遍历方法
        //n表示题目要求的皇后数，len表示已经存放的皇后数
        public void dfs(int n, int len) {
            //重点！递归回溯方法第一步
            //先设置好终止条件
            //及要求的皇后数和已填放的皇后数相等
            if (n == len) {
                //封装成单次结果
                List<String> oneRes = new ArrayList<>();
                for (char[] ch : chessBoard) {
                    oneRes.add(new String(ch));
                }
                res.add(oneRes);
                //退出当次遍历
                return;
            }
            //遍历每一个位置
            for (int i = 0; i < n; i++) {
                //先判断该位置是否可以存放皇后
                //只有三个都为false，即不冲突才可以放入
                if (!cols[i] && !mainDiag[n + len - i] && !deputyDiag[len + i]) {
                    //到这里表示可以存放
                    //先把皇后放进入棋盘
                    chessBoard[len][i] = 'Q';
                    //更新标志位
                    cols[i] = true;
                    mainDiag[n + len - i] = true;
                    deputyDiag[len + i] = true;
                    //往下一行继续遍历
                    dfs(n, len + 1);
                    //先把皇后放进入棋盘
                    chessBoard[len][i] = '.';
                    //更新标志位
                    cols[i] = false;
                    mainDiag[n + len - i] = false;
                    deputyDiag[len + i] = false;
                }
            }
        }
    }
}
