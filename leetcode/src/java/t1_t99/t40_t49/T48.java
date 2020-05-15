package java.t1_t99.t40_t49;

public class T48 {
    class Solution {
        public void rotate(int[][] matrix) {
            //旋转问题，这类问题的经典解法就是把数字的旋转，看成块的旋转
            //那么实际上就类似于 卍 => 以中心为固定点，分为左上，左下，右上，右下四块进行旋转
            int len = matrix.length;
            //以中心为固定点，划分上下两半遍历
            for (int row = 0; row < (len + 1) / 2; row++) {
                //以中心为固定点，划分左右两半来遍历
                for (int cow = 0; cow < len / 2; cow++) {
                    //开始旋转，形成环
                    //根据旋转特点，行由列决定，列由行决定
                    //这里比较难理解，建议debug跑一遍
                    //保存当前块，即左上
                    int temp = matrix[row][cow];
                    //左上替换为左下
                    matrix[row][cow] = matrix[len - 1 - cow][row];
                    //左下替换为右下
                    matrix[len - 1 - cow][row] = matrix[len - 1 - row][len - 1 - cow];
                    //右下替换为右上
                    matrix[len - 1 - row][len - 1 - cow] = matrix[cow][len - 1 - row];
                    //右上替换为当前块，即左上
                    matrix[cow][len - 1 - row] = temp;
                }
            }
        }
    }
}
