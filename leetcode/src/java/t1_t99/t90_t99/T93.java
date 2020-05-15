package java.t1_t99.t90_t99;

public class T93 {
    class Solution {
        //提取为全局变量，方便调用
        //创建结果集
        List<String> res;
        //用于拼接单次结果
        StringBuilder sb;

        public List<String> restoreIpAddresses(String s) {
            //根据给定的字符串，判断有几种合理的ip地址
            //现总结题目要求
            //1.ip地址的合理范围是0~255
            // 即，如果是0开头，必须单独为一个数
            //2.ip地址由4个数组成
            // 即字符串s最少4个字符，最大12个字符
            //由此不难想到，回溯剪枝是比较好的做法

            //初始化res
            res = new ArrayList<>();
            //先判断特殊情况
            if (s.length() < 4) return res;
            //初始化sb
            sb = new StringBuilder();
            //调用遍历方法
            dfs(s, 0, 0);
            //返回结果
            return res;
        }

        /**
         * @Author: Lxp
         * @Description:遍历方法
         * @Date: 2020/5/14
         * @Param s: 待遍历的字符串
         * @Param index: 遍历的索引
         * @Param count: 遍历第count个数,从0计数
         * @return: void
         **/
        public void dfs(String s, int index, int count) {
            //先设立终止条件
            //1.找到解，即遍历完4个正数，同时遍历到末尾了
            if (count == 4 && index == s.length()) {
                res.add(new String(sb));
                return;
            }
            int remainCount = 4 - count;
            int remainChar = s.length() - index;
            //2.无解，即剩余字符数小于未填充位数，或者大于3倍未填充位数
            if (remainChar < remainCount || remainChar > remainCount * 3) return;
            //如果第一位是0，则只能单独为一个数
            int maxLen = s.charAt(index) == '0' ? 1 : 3;
            //遍历剪枝
            for (int i = 0; i < maxLen && i + index < s.length(); i++) {
                //先处理几种特殊情况，即3位数时不能超过255，0开头只能是1位数
                if (i == 2 && ((s.charAt(index) - '0') * 100
                        + (s.charAt(index + 1) - '0') * 10
                        + (s.charAt(index + 2) - '0') > 255)) continue;
                //将每个数添加进单次结果集
                for (int j = 0; j <= i; j++) sb.append(s.charAt(index + j));
                //前三个数后面要加'.'
                if (count < 3) sb.append('.');
                //往下继续遍历
                dfs(s, index + i + 1, count + 1);
                //回溯时要删除先前添加的数
                sb.delete(count < 3 ? sb.length() - i - 2 : sb.length() - i - 1, sb.length());
            }
        }
    }
}
