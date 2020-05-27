package java.t100_t199.t150_t159;

public class T151 {
    class Solution {
        public String reverseWords(String s) {
            //逐个翻转字浮串中的每个单词
            //即无非是完成两个任务
            //1.得到每个有效单词
            //2.翻转单词表

            //去除首尾空格，同时根据空格分割字符串
            String[] strs = s.trim().split(" ");
            //用于拼接单词
            StringBuilder res = new StringBuilder();
            //逆序遍历拼接
            for(int i = strs.length - 1; i >= 0; i--) {
                //遇到多余空格单词则跳过
                if(strs[i].equals("")) continue;
                //拼接单词，记得每个单词之间要加空格
                res.append(strs[i] + " ");
            }
            //返回结果集，记得去掉最后的空格
            return res.toString().trim();
        }
    }
}
