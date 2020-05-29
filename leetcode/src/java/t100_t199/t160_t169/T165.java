package java.t100_t199.t160_t169;

public class T165 {
    class Solution {
        public int compareVersion(String version1, String version2) {
            //对比版本号，前导0无效
            //那么实际上，就等同于从左往右逐个对比
            //如果version1>version2,返回true
            //反之返回false
            //如果相等或者遇到0则继续往后遍历

            //由于'.'是版本号分隔符，所以直接根据'.'分割版本号即可
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            //遍历索引
            int index = 0;
            //比较版本号大小
            for (; index < Math.max(v1.length, v2.length); index++) {
                int num1 = index < v1.length ? Integer.parseInt(v1[index]) : 0;
                int num2 = index < v2.length ? Integer.parseInt(v2[index]) : 0;
                if (num1 > num2) return 1;
                if (num1 < num2) return -1;
            }
            //表示想等，返回0
            return 0;
        }
    }
}
