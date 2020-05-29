package java.t100_t199.t160_t169;

public class T164 {
    class Solution {
        //建立桶
        static class Bucket {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
        }

        public int maximumGap(int[] nums) {
            //给定一个无序数组，找出数组排序后相邻元素之间的最大差值
            //那么大家首先想到的思路，肯定是先比较排序后遍历
            //但是题目要求线性时间复杂度和空间复杂度的条件下解决此问题
            //即上面的思路显而易见是不符合要求的
            //即显而易见，不能先比较排序后遍历
            //那么不难想到另外一种方法，计数排序后遍历
            //明显这个方法也是不符合要求的
            //但是到了这里，不难想到，普通计数排序不符合
            //但是进阶的计数排序，即桶排序是可以达到要求的
            //每个桶的容量设为平均间隔，那么就表明，同个桶不可能存在最大间隔
            //即最大间隔必然存在不同的桶之间

            //先处理特殊情况
            if (nums.length < 2) return 0;
            //分别存放最大值和最小值
            int min = 0, max = 0;
            //遍历数组计算最大值最小值
            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            //计算桶的容量
            //在n个数下,形成的区间是 n - 1 个
            //有4个数[3,6,9,1],但是只有3个区间,[1,3],[3,6],[6,9]
            //即桶容量=区间长度/区间个数 = (max - min)/(nums.length - 1)
            int bucketSize = Math.max(1, (max - min) / (nums.length - 1));

            //计算桶的个数
            //即桶个数=区间长度/桶容量
            //同时由于桶是左开右闭的，因此多加一个桶
            //即桶个数=区间长度/桶容量+1
            Bucket[] buckets = new Bucket[(max - min) / bucketSize + 1];
            //遍历数组
            for (int num : nums) {
                //由于桶个数=区间长度/桶容量
                //所以存放的同位置=当前区间长度/桶容量
                //即桶内数的最大间隔不超过桶容量
                int bucketsIndex = (num - min) / bucketSize;
                //如果为空桶，则先创建桶
                if (buckets[bucketsIndex] == null) buckets[bucketsIndex] = new Bucket();
                //更新桶内最大值和最小值
                buckets[bucketsIndex].min = Math.min(buckets[bucketsIndex].min, num);
                buckets[bucketsIndex].max = Math.max(buckets[bucketsIndex].max, num);
            }
            //由于桶是按序的，即需要保留前一个桶的最大值，比较后一个桶的最小值
            int preMax = Integer.MAX_VALUE;
            //存放结果
            int res = 0;

            //遍历桶
            for (Bucket bucket : buckets) {
                //比较前一个桶的最大值和当前桶的最小值的间隔即可
                if (bucket != null && preMax != Integer.MAX_VALUE) res = Math.max(res, bucket.min - preMax);
                //更新前一个桶的最大值
                if (bucket != null) preMax = bucket.max;
            }
            //返回结果
            return res;
        }
    }
}
