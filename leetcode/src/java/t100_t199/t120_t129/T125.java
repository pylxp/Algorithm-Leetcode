package java.t100_t199.t120_t129;

public class T125 {
    class Solution {
        public boolean isPalindrome(String s) {
            //判断是否为回文串
            //这题的坑点在于,除了数字和字母，其余的符号和空格都跳过
            //同时，不考虑字母的大小写
            //那么根据以上的要求，不难推出以下结论
            //1.需要判断是否为数字或字母
            // 1.1 这里可以调用自带的api，Character.isLetterOrDigit()
            // 1.2 自己加判断语句
            //2.需要判断大小写字母
            //不难想到，采用ASCII进行转换是一个比较好的方法对比大小写
            // 2.1 这里可以调用自带的api，Character.toLowerCase()同义转换为小写字母比较
            // 2.2 a~z=97~122  A~Z=65~90, 即大小写差值在为32
            //3.判断是否为回文串，即头尾对比遍历
            //那么需要维护两个索引，分别指向头尾，索引重叠或者超过则为true

            //先处理特殊情况，题目定义了空字符串为回文串
            if (s.length() <= 1) return true;
            //为了便于遍历，先转换为字符数组
            char[] ch = s.toCharArray();
            //创建头尾索引
            int head = 0, tail = s.length() - 1;
            //遍历字符数组
            while (head < tail) {
                //如果头索引遇到非数字或字母跳过，移动头索引
                if (!Character.isLetterOrDigit(ch[head])) head++;
                    //如果尾索引遇到非数字或字母跳过，移动尾索引
                else if (!Character.isLetterOrDigit(s.charAt(tail))) tail--;
                    //如果相等则头尾索引都移动
                else if (Character.toLowerCase(s.charAt(head)) == Character.toLowerCase(s.charAt(tail))) {
                    head++;
                    tail--;
                }
                //如果不相等则返回false
                else return false;
            }
            //走到这里则表示想等，返回即可
            return true;
        }
    }
}
