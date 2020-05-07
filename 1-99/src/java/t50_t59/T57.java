package src.java.t50_t59;

public class T57 {
    class Solution {
        //提取为全局变量，方便调用
        //创建结果集
        List<int[]> res;
        //用于存放最后一个Interval
        int[] lastInterval;

        public int[][] insert(int[][] intervals, int[] newInterval) {
            //这题跟56相似，建议放在一起做
            //上一题因为排序比较耗时，使用了标志数轴的做法
            //不过这题是默认有序的，所以直接进行比较插入即可

            //创建结果列表
            res = new ArrayList<>();
            //数组索引
            int index = 0;
            //遍历找到newInterval插入的位置
            for (int[] interval : intervals) {
                //找到左值插入位置
                if (newInterval[0] <= interval[0]) {
                    insertOrMerge(newInterval);
                    break;
                }
                //复制旧数组
                insertOrMerge(interval);
                //记录插入位置
                index++;
            }
            //插入剩余部分
            if (index == intervals.length) {
                // 将新区间添加到最后
                insertOrMerge(newInterval);
            } else {
                // 新区间已插入，添加剩余的区间
                for (; index < intervals.length; index++) {
                    insertOrMerge(intervals[index]);
                }
            }
            //转换格式输出
            return res.toArray(new int[0][]);
        }

        //插入合并的方法
        private void insertOrMerge(int[] newInterval) {
            //如果最后一个区间为空，或者最后一个区间的右值小于新区间的左值，则插入
            if (lastInterval == null || lastInterval[1] < newInterval[0]) {
                lastInterval = newInterval;
                res.add(newInterval);
            }
            //如果最后一个区间的右值小于新区间右值，则合并
            else if (lastInterval[1] < newInterval[1]) {
                lastInterval[1] = newInterval[1];
            }
        }
    }
}
