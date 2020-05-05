package java.t1_t10;

public class T3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            //如果字符串长度小于等于1，即长度为结果
            if(s.length()<=1) return s.length();
            //存放结果长度,left表示无重复字母所在字符串的左索引
            int res=0,left=0;
            //用于存放已知字符的索引位置
            Map<Character, Integer> map = new HashMap<>();
            //right表示遍历到的当前位的索引
            for (int right = 0; right < s.length(); right++) {
                //当出现相同字母时
                if (map.containsKey(s.charAt(right))) {
                    //左索引获取无重复字符串的高位，确保不包含重复字母
                    //即如果重复字母出现的位置在left左侧，则不用理会
                    //出现在left右侧，则替换left的值
                    left = Math.max(left,map.get(s.charAt(right)));
                }
                //取无重复字符串最大值，+1，是防止出现一个字母的情况下输出0
                res = Math.max(res, right - left+1);
                //将字母丢入map，+1，是防止出现一个字母的情况下输出0
                map.put(s.charAt(right), right+1);
            }
            return res;
        }
    }
}
