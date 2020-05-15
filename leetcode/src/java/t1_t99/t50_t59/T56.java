package src.java.t50_t59;

public class T56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            //常规做法，先对数组按照左区间进行排序
            //然后根据下一个左值和上一个的右值来比较判断是否合并
            //不过由于用例问题，这里排序会浪费较多时间
            //所以这里采用标志数轴的方式进行解答
            //即合并区间的头部标志为1，区间标志为2

            //先处理特殊情况
            if (intervals.length <= 1) return intervals;
            //创建标志数轴
            int[] flag = new int[10000];
            //初始化最大值，即标志数轴的最大索引
            int max = intervals[0][1];
            //初始化最小值，即标志数轴的最小索引
            int min = intervals[0][0];
            //开始遍历数组，对标志数轴进行染色
            for (int[] interval : intervals) {
                //染色起点
                int index = interval[0];
                //如果该起点没有标志过，则为新合并数组的起点
                if (flag[index] == 0) flag[index] = 1;
                //对区间进行染色
                while (++index <= interval[1]) flag[index] = 2;
                //更新最大值
                max = Math.max(interval[1], max);
                //更新最小值
                min = Math.min(interval[0], min);
            }

            //遍历数轴，进行区间合并
            //创建结果列表
            ArrayList<int[]> res = new ArrayList<>();
            //创建单个数组拼接区间
            int[] tempRes = new int[2];
            //创建边界标志位，判断是否为同一个区间
            boolean border = true;
            while (min <= max + 1) {
                //右边界
                if ((flag[min] == 0 || flag[min] == 1) && !border) {
                    tempRes[1] = min - 1;
                    border = true;
                    res.add(Arrays.copyOf(tempRes, 2));
                }
                //左边界
                if (flag[min] == 1 && border) {
                    tempRes[0] = min;
                    border = false;
                }
                min++;
            }
            return res.toArray(new int[0][]);
        }
    }
}
