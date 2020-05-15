package java.t1_t99.t70_t79;

public class T74 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            //m*n矩阵中查找一个数
            //矩阵内数值从左往右，从上到下有序排列
            //综上，大家不难发现，本质上就是个数组中查找目标值的问题
            //那么这里同样的，二分法是个很好的选择

            //处理特殊情况
            if (matrix.length == 0) return false;
            //获取行列长度
            int row = matrix.length;
            int col = matrix[0].length;

            //建立左右中索引和中值
            int left = 0, right = row * col - 1, mid, midValue;
            //二分查找
            while (left <= right) {
                //计算中值索引
                mid = (left + right) / 2;
                //获得中值
                midValue = matrix[mid / col][mid % col];
                //如果找到直接返回true
                if (target == midValue) return true;
                    //中值过大，往左遍历
                else if (target < midValue) right = mid - 1;
                    //中值过小，往右遍历
                else left = mid + 1;
            }
            //找不到返回false
            return false;
        }
    }
}
