package src.java.t50_t59;

public class T52 {
    class Solution {
        //提取为全局变量，方便调用
        //先创建好结果集
        int res = 0;
        //1.判断竖列是否冲突
        boolean[] cols;
        //2.判断主对角线是否冲突
        boolean[] mainDiag;
        //3.判断副对角线是否冲突
        boolean[] deputyDiag;

        public int totalNQueens(int n) {
            //这题跟36，37，51相似，建议放在一起做
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
                res++;
                //退出当次遍历
                return;
            }
            //遍历每一个位置
            for (int i = 0; i < n; i++) {
                //先判断该位置是否可以存放皇后
                //只有三个都为false，即不冲突才可以放入
                if (!cols[i] && !mainDiag[n + len - i] && !deputyDiag[len + i]) {

                    //更新标志位
                    cols[i] = true;
                    mainDiag[n + len - i] = true;
                    deputyDiag[len + i] = true;
                    //往下一行继续遍历
                    dfs(n, len + 1);
                    //更新标志位
                    cols[i] = false;
                    mainDiag[n + len - i] = false;
                    deputyDiag[len + i] = false;
                }
            }
        }
    }
}
