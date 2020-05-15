package src.java.t60_t69;

public class T68 {
    class Solution {
        //提升为全局变量，方便调用
        //根据返回类型创建结果集
        List<String> res;
        //用于拼接每行单词
        //用StringBuilder存储优势
        //1.比String不可变字符串更省内存
        //2.不考虑安全的情况，比StringBuffer性能更高
        StringBuilder rowRes;
        //获取每行已有长度，即下一行开头的单词
        int rowLen;

        public List<String> fullJustify(String[] words, int maxWidth) {
            //根据题意，给定一个单词组，同时保证每行恰好有maxWidth个字符
            //从这句话我们可以得出以下几个结论：
            //1.所有字符数=各个单词长度+空格
            //2.words[i]+(已有长度)+1(单词间空格)>maxWidth,则i为新一行结尾
            //3.words[i]+(words[i+1])+1(单词间空格)>maxWidth,则i为新一行开头
            //4.每行需要填充的空格数spaceCount = maxWidth - rowLen(已拼接长度) + (wordNumber- 1)(已添加空格);
            //填充空格
            //补充空格的几种情况
            //1.空格补充在末尾
            // 只有一个单词，或者最后一行
            //2.空格补充在单词之间
            // 多个单词且不是最后一行

            //根据返回类型创建结果集
            res = new ArrayList<>();
            //用于遍历words的索引
            int index = 0;
            //words单词个数
            int wordCount = words.length;
            //遍历单词
            while (index < wordCount) {
                //用于拼接每行单词
                rowRes = new StringBuilder();
                //获取每行已有长度，即下一行开头的单词
                rowLen = words[index].length();
                //获取下一行的起始索引
                int nextIndex = getLastWordIndex(words, maxWidth, index + 1, wordCount);
                //填充空格
                fillSpace(wordCount, index, nextIndex, words, maxWidth);
                //添加进结果集
                res.add(rowRes.toString());
                //更新为下一行的起始索引
                index = nextIndex;
            }
            //返回结果集
            return res;
        }

        /**
         * @Author: Lxp
         * @Description: 计算下一行单词起始索引的方法
         * @Date: 2020/5/9
         * @Param words: 单词表
         * @Param maxWidth: 每行限制长度
         * @Param rowLen: 当前行已有长度
         * @Param nextIndex: 下一个单词的索引
         * @Param wordCount: 单词表的单词数量
         * @return: int 返回该行最后一个单词的索引
         **/
        public int getLastWordIndex(String[] words, int maxWidth, int lastIndex, int wordCount) {
            //往后继续遍历到行末
            while (lastIndex < wordCount) {
                //words[i]+(已有长度)+1(单词间空格)>maxWidth,则i为新一行结尾
                if (rowLen + 1 + words[lastIndex].length() > maxWidth) break;
                //更新已有长度
                rowLen += (1 + words[lastIndex].length());
                //往后更新索引
                lastIndex++;
            }
            //返回下一行的开头索引
            return lastIndex;
        }

        /**
         * @Author: Lxp
         * @Description: 填充空格的方法
         * @Date: 2020/5/9
         * @Param wordCount: 单词表的单词数
         * @Param index: 当前行的起始索引
         * @Param nextIndex: 下一行的起始索引
         * @Param words:   单词表
         * @Param maxWidth: 每行的限制长度
         * @return: void
         **/
        public void fillSpace(int wordCount, int index, int nextIndex, String[] words, int maxWidth) {
            //计算当前行的单词数
            int wordNumber = nextIndex - index;
            //计算需要补充的空格数=maxWidth-已有长度+已有长度里面的空格
            int spaceCount = maxWidth - rowLen + (wordNumber - 1);

            //处理1.空格补充在末尾
            //只有一个单词，或者最后一行
            if (wordNumber == 1 || nextIndex == wordCount) {
                //添加除最后一个单词外的所有单词
                for (int i = index; i < nextIndex - 1; i++)
                    rowRes.append(words[i]).append(" ");
                //添加最后一个单词
                rowRes.append(words[nextIndex - 1]);
                //添加剩余空格
                while (spaceCount - wordNumber + 1 > 0) {
                    rowRes.append(" ");
                    spaceCount--;
                }
            }
            //处理2.空格补充在单词之间
            //多个单词且不是最后一行
            else {
                //平均两个单词间添加的空格数=sapceCount/(wordNumber-1)
                int averageSpace = spaceCount / (wordNumber - 1);
                //剩余空格
                int remainSpace = spaceCount % (wordNumber - 1);
                //添加除最后一个单词外的所有单词
                //按平均添加空格，剩余的空格从前往后添加到没有剩余为止
                for (int i = index; i < nextIndex - 1; i++) {
                    rowRes.append(words[i]);
                    for (int j = 0; j < averageSpace; j++)
                        rowRes.append(" ");
                    //从前往后补充剩余空格
                    if (i - index < remainSpace) rowRes.append(" ");
                }
                //添加最后一个单词
                rowRes.append(words[nextIndex - 1]);
            }
        }
    }
}
