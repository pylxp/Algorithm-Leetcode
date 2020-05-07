package src.java.t50_t59;

public class T59 {
    class Solution {
        public int[][] generateMatrix(int n) {
            //旋转问题，这题跟48，54相似，建议放在一起做
            //分别指向上下左右边界
            int left = 0, right = n - 1, up = 0, down = n - 1;
            //根据题目要求，创建结果集
            int[][] res = new int[n][n];
            //分别记录当前值和最大值
            int value = 1, max = n * n;
            //填充结果集
            while (value <= max) {
                //最上行，从左到右
                for (int i = left; i <= right; i++) res[up][i] = value++;
                //更新上边界
                up++;
                //最右列，从上到下
                for (int i = up; i <= down; i++) res[i][right] = value++;
                //更新右边界
                right--;
                //最下行，从右到左
                for (int i = right; i >= left; i--) res[down][i] = value++;
                //更新下边界
                down--;
                //最左列，从下到上
                for (int i = down; i >= up; i--) res[i][left] = value++;
                //更新左边界
                left++;
            }
            //返回结果集
            return res;
        }
    }
}
