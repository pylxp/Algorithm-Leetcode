package java.t100_t199.t160_t169;

public class T167 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            //有序数组查找目标和的两个索引
            //那么不难想到，即采用两个指针，遍历到目标和即可
            //那么换个思路先，如果固定了一个数，就变成了有序数组查找target-num1
            //既可以使用二分查找法找target-num1即可

            //遍历数组
            for (int i = 0; i < numbers.length; i++) {
                //固定一个数，numbers[i],调用二分法查找另一个数
                int index = binarySearch(numbers, i + 1, target - numbers[i]);
                if (index != -1) return new int[]{i + 1, index + 1};
            }
            //实际上由于一定有解，走不到这里
            return new int[2];
        }

        //二分法缩小边界
        public int binarySearch(int[] numbers, int start, int target) {
            int right = numbers.length - 1, mid;
            while (start <= right) {
                mid = (start + right) >>> 1;
                if (numbers[mid] == target) return mid;
                else if (numbers[mid] < target) start = mid + 1;
                else right = mid - 1;
            }
            return -1;
        }
    }
}
