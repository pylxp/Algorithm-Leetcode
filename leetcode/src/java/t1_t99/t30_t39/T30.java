package java.t21_t30;

public class T30 {
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            //没啥说的，先把要返回的类型结果创建了
            List<Integer> res = new ArrayList<>();
            //特殊情况判断,words为空直接返回空结果
            if (words.length == 0) return res;
            //为了单词的读取方便，首选HashMap,存放待匹配的所有单词
            Map<String, Integer> wordMap = new HashMap<>();
            //遍历words存放单词进map
            //key表示单词，value表示单词数
            for (String word : words) {
                //如果不存在，设为1，存在则个数+1
                wordMap.put(word, wordMap.get(word) == null ? 1 : wordMap.get(word) + 1);
            }
            //获取单词长度
            int wordLen = words[0].length();
            //由于单词可能存在极端情况，如foo,oof等，所以需要逐一遍历
            //已一个单词的长度为终止条件，每次遍历往后跳一个单词
            for (int len = 0; len < wordLen; len++) {
                //表示已匹配的单词个数
                int hadNum = 0;
                //存放已匹配的单词，对比原单词列表进行匹配
                HashMap<String, Integer> hadMap = new HashMap<>();
                //由于上面已单词长度为循环遍历，所以这里每次步长为一个单词长度wordLen
                //同时如果剩余长度不足需要匹配的最短长度，则无需遍历
                for (int i = len; i < s.length() - words.length * wordLen + 1; i += wordLen) {

                    //hadNum==words.length则表示刚好匹配
                    while (hadNum < words.length) {
                        //获取即将匹配的单词
                        String nowWord = s.substring(i + hadNum * wordLen, i + (hadNum + 1) * wordLen);
                        //如果匹配成功
                        if (wordMap.containsKey(nowWord)) {
                            //放入已匹配的单词映射表,不存在则设为1，存在则个数+1
                            hadMap.put(nowWord, hadMap.get(nowWord) == null ? 1 : hadMap.get(nowWord) + 1);
                            //已匹配单词数+1
                            hadNum++;
                            //记录超出的单词
                            int removeNum = 0;
                            //如果已匹配的同个单词数超过拥有的同个单词数
                            while (hadMap.get(nowWord) > wordMap.get(nowWord)) {
                                //截取多余的同个单词
                                String removeWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                //将已匹配的同个单词-1
                                hadMap.put(removeWord, hadMap.get(removeWord) - 1);
                                //已匹配的单词数-1
                                hadNum--;
                                //超出的单词数+1
                                removeNum++;
                            }
                            //如果存在超出的多余单词
                            if (removeNum > 0) {
                                //那么就需要跳过多余的单词，否则匹配无意义
                                //由于遍历步长会增加一个wordLen，所以这里要-1
                                i += (removeNum - 1) * wordLen;
                                break;
                            }
                        }
                        //如果匹配失败，即出现不存在的单词
                        else {
                            //请空已匹配单词映射表
                            hadMap.clear();
                            //直接跳到这个不存在的单词后面开始重新匹配
                            //否则会一直包含这个不存在的单词，匹配无意义
                            i += hadNum * wordLen;
                            //已匹配单词数清空
                            hadNum = 0;
                            break;
                        }
                    }
                    //完全匹配
                    if (hadNum == words.length) {
                        //放入结果集
                        res.add(i);
                        //跳过第一个单词
                        String headWord = s.substring(i, i + wordLen);
                        //对应第一个单词的已匹配单词-1
                        hadMap.put(headWord, hadMap.get(headWord) - 1);
                        //已匹配单词数-1
                        hadNum--;
                    }
                }
            }
            return res;
        }

    }
}
