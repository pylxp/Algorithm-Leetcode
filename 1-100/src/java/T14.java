package java;

public class T14 {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            //如果只有为空，直接返回
            if (strs.length==0) return "";
            //如果只有一组，会跳过for循环直接返回
            String res=strs[0];
            for (int i=1;i<strs.length;i++){
                //这是关键，只要以最短字符串的长度作为遍历上限即可
                int minLen=Math.min(res.length(),strs[i].length());
                int len;//存放最大公共前缀长度
                for (len=0;len<minLen;len++){
                    //只要匹配到不等，即可跳出循环
                    if (res.charAt(len)!=strs[i].charAt(len)) break;
                }
                //截取现有公共前缀
                res=res.substring(0,len);
                //如果公共前缀长度为0，即表示无公共前缀
                if (res.length()==0) return "";
            }
            //返回公共前缀结果
            return res;
        }
    }
}
