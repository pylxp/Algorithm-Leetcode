package java.t1_t99.t70_t79;

public class T73 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            //题目要求使用原地算法
            //那么毫无意问，只能在传进来的矩阵上进行操作
            //将0所在的行列清零，那么不难得出以下结论
            // 1.遍历找到0所在的位置
            // 2.将0所在行清零
            // 3.将0所在列清零
            //综上不难想到，如果找到0后直接清零行列，后续遍历会错误识别人为清零产生的0
            //那么反过来思考
            //1.有0所在的行列清零
            //那么反过来思考
            //1.有0所在的行列头部标志为0
            //2.找到头部标志为0的行列
            //3.对应的行列清零
            //注意第一行第一列本身就为自己的标志位
            //所以第一行或者第一列要单独清理
            //否则会造成上面同样的错误

            //标志位，单独标志第一列
            boolean flag = false;
            //获取矩阵的行列数
            int row = matrix.length;
            int col = matrix[0].length;

            //遍历每一行
            for (int i = 0; i < row; i++) {
                //用于判断第一列是否存在0
                if (matrix[i][0] == 0) flag = true;
                //遍历每一列
                for (int j = 1; j < col; j++)
                    //如果找到0,则把对应的行列头设为0，标志该行列存在0
                    if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
            }
            //逆序遍历每一行
            for (int i = row - 1; i >= 0; i--) {
                //逆序遍历每一列
                for (int j = col - 1; j >= 1; j--)
                    //如果该行或者该列头部标志为0了，则该值清零
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
                //第一列清零
                if (flag) matrix[i][0] = 0;
            }
        }
    }
}
