package src.java.t50_t59;

public class T54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            //旋转问题，这题跟48相似，建议放在一起做
            //先处理特殊情况
            if (matrix.length == 0) return new ArrayList<Integer>();
            //分别指向上下左右边界
            int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
            //根据题目要求，创建结果集
            List<Integer> res = new ArrayList<Integer>();
            //分别记录当前索引和最大索引
            int index = 0, max = matrix.length * matrix[0].length;
            //填充结果集
            while (res.size() < max) {
                //最上行，从左到右
                for (int i = left; res.size() < max && i <= right; i++)
                    res.add(matrix[up][i]);
                //更新上边界
                up++;
                //最右列，从上到下
                for (int i = up; res.size() < max && i <= down; i++)
                    res.add(matrix[i][right]);
                //更新右边界
                right--;
                //最下行，从右到左
                for (int i = right; res.size() < max && i >= left; i--)
                    res.add(matrix[down][i]);
                //更新下边界
                down--;
                //最左列，从下到上
                for (int i = down; res.size() < max && i >= up; i--)
                    res.add(matrix[i][left]);
                //更新左边界
                left++;
            }
            //返回结果集
            return res;
        }
    }
}
