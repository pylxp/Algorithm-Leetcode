package java.t1_t99.t40_t49;

public class T44 {
    class Solution {
        public boolean isMatch(String s, String p) {
            //这题跟第10题相似，建议放在一起做
            //由于题目要求完全匹配，所以这里用动态规划算法没必要，反而更慢
            //采用逐一便利的方法即可
            //分别作为s，p的索引,sLog,pLog分别记录当匹配'*‘时的位置
            int sIndex = 0, pIndex = 0, sLog = -1, pLog = -1;
            //遍历字符串s,p,超出长度则停止遍历
            //注意，这里以s为主，因为s是规则字符串，没有'?/*'
            while (sIndex < s.length()) {
                //如果相等，或者p等于‘?‘,则往后继续遍历
                if (pIndex < p.length() &&
                        (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')) {
                    sIndex++;
                    pIndex++;
                }
                //如果p等于’*‘,则分情况处理
                else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                    //1.'*’表示空字符串
                    //2.'*'表示一个字符
                    //3.’*‘表示多个字符
                    //则sIndex保持不变，pIndex往后继续遍历
                    sLog = sIndex;
                    pLog = pIndex;
                    pIndex++;
                } else if (sLog > -1) {
                    //走到这里，则表示'*'为空时s没有遍历完
                    //则p回退到'*'的后一位重新遍历，sLog标志后移一位
                    //表示进入’*‘进入一个多匹配一个字符的状态，这里debug一下比较容易理解
                    sIndex = ++sLog;
                    pIndex = pLog + 1;
                }
                //如果不匹配，直接返回false
                else return false;
            }
            //走到这里表示s遍历完了，那么去除p可能剩余的’*‘
            while (pIndex < p.length() && p.charAt(pIndex) == '*') pIndex++;
            //如果p剩余的’*‘去除完了，还没遍历完，则表明有其余字符剩余，返回false
            return pIndex == p.length();
        }
    }
}
