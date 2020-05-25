package java.t100_t199.t140_t149;

public class T149 {
    class Solution {
        public int maxPoints(int[][] points) {
            //求最多有几个点在同一条直线上
            //那么实际上就等同于，怎么判断有多少点在同一条直线上
            //即可以根据两点确定一条直线的性质
            //换算固定任意两点，求该线上有几个点的问题

            //获取点数
            int count = points.length;
            //两个点必定是一条直线，所以小于等于2个点直接返回即可
            if (count <= 2) return count;
            //分别记录结果和当前最大值
            int res = 0;
            //遍历每个点
            for (int i = 0; i < count; i++) {
                //记录重复的点,初始为1即自身
                int sameValue = 1;
                //往后遍历，查看有多少点跟当前点在一条直线上
                for (int j = i + 1; j < count; j++) {
                    //记录同斜率的点
                    int sameSlope = 0;
                    //先记录重复的点
                    if (points[j][0] == points[i][0] && points[j][1] == points[i][1]) sameValue++;
                        //记录同斜率的点
                    else {
                        //代表选中了第一个不相同的点，则默认这点为一条直线
                        sameSlope++;
                        //计算当前点和任意点的斜率
                        long dx = points[i][0] - points[j][0];
                        long dy = points[i][1] - points[j][1];
                        for (int k = j + 1; k < count; k++) {
                            if (dx * (points[i][1] - points[k][1]) == dy * (points[i][0] - points[k][0]))
                                sameSlope++;
                        }
                    }
                    //更新最大值
                    res = Math.max(res, sameValue + sameSlope);
                }
            }
            //返回结果
            return res;
        }
    }
}
