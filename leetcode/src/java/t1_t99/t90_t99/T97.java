package java.t1_t99.t90_t99;

public class T97 {
    class Solution {
        //提取为全局变量，方便调用
        //创建标志矩阵，判断该位是否遍历过
        boolean[][] visited;
        //转换为字符数组便于遍历
        char[] ch1;
        char[] ch2;
        char[] ch3;

        public boolean isInterleave(String s1, String s2, String s3) {
            //这题跟10.30.44相似，建议放在一起做
            //判断s3是否由s1/s2交错组成，实际上本质还是个字符串匹配
            //本题的难点在于交错，那么就是说，匹配串是固定的，模式串反而不固定了
            //而且模式串必须是有序的，即s1/s2原先得顺序交错，不能打乱
            //那么不难明白，s3每个位，都是和s1/s2匹配，如果都不匹配，则为false
            //即可以通过三个索引，来移动对比s3的每一位，只要不同，则为false。相同往后遍历
            //因此这里可以采用递归的方法来解答

            //先处理特殊情况
            if (s1.length() + s2.length() != s3.length()) return false;
            //初始化visited矩阵
            visited = new boolean[s1.length() + 1][s2.length() + 1];
            //转换为字符数组
            ch1 = s1.toCharArray();
            ch2 = s2.toCharArray();
            ch3 = s3.toCharArray();
            //调用方法并返回结果
            return dfs(0, 0, 0);
        }

        //分别对应s1,s2,s3的索引
        public boolean dfs(int index1, int index2, int index3) {
            //先设立终止条件
            if (index1 == ch1.length && index2 == ch2.length) return true;
                //如果越界或者该位已经遍历过返回false
            else if (index1 > ch1.length || index2 > ch2.length || visited[index1][index2]) return false;
                //如果跟s1匹配，则移动s1和s3索引
            else if (index1 < ch1.length && ch1[index1] == ch3[index3]
                    && dfs(index1 + 1, index2, index3 + 1)) return true;
                //如果跟s2匹配，则移动s2和s3索引
            else if (index2 < ch2.length && ch2[index2] == ch3[index3]
                    && dfs(index1, index2 + 1, index3 + 1)) return true;
            //标志该位已经遍历过
            visited[index1][index2] = true;
            //跟s1和s2都不匹配，返回false
            return false;
        }
    }
}
