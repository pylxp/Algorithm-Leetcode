package java.t40_t49;

public class T49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            //根据题目示例异位词可以总结大概思路如下
            //第一种，逐个字符进行对比
            //1.首先异位词，字符组成完全相同
            //2.那么要分组，首先就得确定每个词的字符组成，即转换为字符数组
            //3.为了对比每个字符是否一一相等，可以先排序后逐一对比
            //4.简化操作操作3，将排序后字符数组直接转换为String对比
            //第二种，用唯一标识替代字符，进行对比
            //即参考hash函数
            //这里用质数表来替代26个字母
            //1.用26个质数分别替换26个字符
            //2.遍历字符串将每个字符对应的值相乘
            //3.除非两个字符串是异位词，否则根据质数性质，不可能相等
            //注意，这种解法有个弊端，就是字符串太长时，容易乘积溢出
            //不过这里经过测试，第二种方法更快，同时测试用例不存在溢出，故这里主要讲解第二种方法

            //判断特殊情况，即空字符串列表则直接返回
            if (strs.length == 0) return new ArrayList<>();
            //建立对应的质数表
            int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                    31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                    73, 79, 83, 89, 97, 101};

            //为了区分不同的异位词分组，创建HashMap存放不同的分组
            Map<Integer, List<String>> map = new HashMap<>();

            //题目要求根据字母异位词分组，首先肯定要遍历每一个字符串
            for (String str : strs) {
                //根据题目示例异位词可以总结大概思路如下
                //1.用26个质数分别替换26个字符
                //2.遍历字符串将每个字符对应的值相乘
                // 除非两个字符串是异位词，否则根据质数性质，不可能相等
                //3.根据计算得到的哈希值进行分组

                //1.先转换为字符数组
                char[] ch = str.toCharArray();
                //2.遍历每个字符，用对应的质数相乘
                int hashValue = 1;
                for (char c : ch) {
                    hashValue *= primes[c - 'a'];
                }
                //3.根据进行对比分组
                //第一次出现时，先创立对应的列表分组
                if (!map.containsKey(hashValue)) map.put(hashValue, new ArrayList<>());
                //将该异位词放入对应的列表，注意，是原词，str
                map.get(hashValue).add(str);
            }
            //将map中的列表封装成一个列表集合返回，即为结果
            return new ArrayList(map.values());
        }

    }
}
