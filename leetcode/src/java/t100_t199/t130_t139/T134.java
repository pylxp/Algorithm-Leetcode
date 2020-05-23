package java.t100_t199.t130_t139;

public class T134 {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            //求从哪个加油站出发才能成功环绕一周
            //那么无非就是假设任意一个加油站出发，环绕计算即可
            //同时为了减少计算量，如果加油站的油不够开往下一站
            //即gas[i]<cost[i],则该站必然不能作为起点，跳过即可

            //起点站
            int start = 0;
            //分别存放当前剩余油量和总剩余油量
            int remain = 0, totalRemain = 0;
            //遍历每个加油站
            for (int i = 0; i < gas.length; i++) {
                //总油量消耗
                totalRemain += (gas[i] - cost[i]);
                //当前剩余油量
                remain += (gas[i] - cost[i]);
                //如果当前剩余油量不足
                if (remain < 0) {
                    //更新起点
                    start = i + 1;
                    //剩余油量清零
                    remain = 0;
                }
            }
            //如果还有剩余油，则表示起点假设成立
            return totalRemain >= 0 ? start : -1;
        }
    }
}
