package src.java.t60_t69;

public class T60 {
    class Solution {
        //提取为全局变量，方便排列
        boolean[] visited;
        //用于拼接结果
        //由于String不可变比较耗内存，所以这里最后再转换为String
        StringBuilder res = new StringBuilder();

        public String getPermutation(int n, int k) {
            //n！种排列，取第k个排列
            //根据排列的性质，不难发现如下性质
            //n！=n*(n-1)!
            //即可以通过k包括几个(n-1)!来逐步缩小排列范围
            visited = new boolean[n];
            // 将 n! 种排列分为：n 组，每组有 (n - 1)! 种排列
            dfs(n, calcFactorial(n - 1), k);
            return res.toString();
        }

        //遍历方法
        //n剩余为排列个数，factorial对应的阶乘，k即要找的第k个排列
        private void dfs(int n, int factorial, int k) {
            //偏移量，即取模得到该位应该是几
            int offset = k % factorial;
            //计算得到当前为第几组
            int num = k / factorial + (offset > 0 ? 1 : 0);
            //遍历得到没有被访问的数字里的第 num 个数字
            int index = 0;
            for (; index < visited.length && num > 0; index++) {
                if (!visited[index]) num--;
            }
            //标志该位置
            visited[index - 1] = true;// 标记为已访问
            //即还没找到最后
            if (n - 1 > 0) {
                // 拼接当前遍历到的数字
                res.append(index);
                //向下继续遍历，这里factorial/(n-1)，即可获得下一次的阶段，不用循环计算
                //同时，k的值变更为偏移量，或者阶乘的最后一位
                dfs(n - 1, factorial / (n - 1), offset == 0 ? factorial : offset);
            } else {
                // 拼接最后一个字符
                res.append(index);
            }
        }

        //计算阶乘的方法
        private int calcFactorial(int n) {
            int res = 1;
            for (int i = n; i > 1; i--) {
                res *= i;
            }
            return res;
        }
    }
}
