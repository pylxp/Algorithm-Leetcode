package java.t100_t199.t120_t129;

public class T126 {
    class Solution {
        //提取为全局变量方便调用
        //创建结果集
        List<List<String>> res = new ArrayList<>();

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            //单词接龙
            //根据题目要求，每次接龙只能改变一个字母
            //那么不难得出以下结论
            //每个单词可达的单词列表都是固定的，即一个字母的差别
            //那么反过来想，如果一个单词的可达单词包括目标单词
            //那么最短路径必然在这些单词之中
            //即通过bfs遍历每一层，如果当前层已经有单词可达目标单词，即必然为最短路径层
            //因此这里采用bfs方法，是个比较容易想到的选择
            //同时为了尽可能遍历更少的单词，采用双向bfs方法可以进一步优化

            // 先处理特殊情况
            if (!wordList.contains(endWord)) return res;
            //复制单词表
            Set<String> words = new HashSet<>(wordList);
            //正序当前层的单词列表
            Set<String> beginPath = new HashSet<>();
            //逆向当前层的单词列表
            Set<String> endPath = new HashSet<>();
            // 存放每个单次能到达的下一层单词列表(即只能有一个字母的查别)
            Map<String, List<String>> map = new HashMap<>();
            //初始化路径
            beginPath.add(beginWord);
            endPath.add(endWord);
            if (bfs(words, beginPath, endPath, map, true))
                dfs(map, beginWord, endWord, new LinkedList<>());
            //返回结果
            return res;
        }

        // 双向BFS，构建每个单词的层级对应关系
        private boolean bfs(Set<String> words, Set<String> beginPath, Set<String> endPath, Map<String, List<String>> map, boolean isFront) {
            //先设立终止条件
            if (beginPath.size() == 0) return false;
            // 删除列表中当前层的单词列表，即已使用的单词
            words.removeAll(beginPath);
            // 标记当前层是否已匹配到结果单词
            boolean visited = false;
            // 记录本层所访问的单词
            Set<String> nextLevel = new HashSet<>();
            //遍历当前层的单词
            for (String now : beginPath) {
                //转换为字符数组便于对比
                char[] chars = now.toCharArray();
                // 遍历每个字符
                for (int i = 0; i < chars.length; i++) {
                    char temp = chars[i];
                    //判断是否只差一个字符
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String newWord = String.valueOf(chars);
                        if (!words.contains(newWord)) continue;
                        //有责添加进下一层可达列表
                        nextLevel.add(newWord);
                        //判断当前bfs是从前往后还是从后往前
                        //nextWord存放下一层单词，key存放当前层遍历的单词
                        String nowWord = isFront ? now : newWord;
                        String nextWord = isFront ? newWord : now;
                        // 判断是否已经遍历到了目标单词
                        if (endPath.contains(newWord)) visited = true;
                        //如果下一层为空，则先添加该当次对应的列表
                        if (!map.containsKey(nowWord)) map.put(nowWord, new ArrayList<>());
                        //不为空，则直接加进去即可
                        map.get(nowWord).add(nextWord);
                    }
                    chars[i] = temp;
                }
            }
            //如果已经遍历到了目标单词，则返回
            if (visited) return true;
            //保持少的一层优先遍历
            if (nextLevel.size() > endPath.size()) return bfs(words, endPath, nextLevel, map, !isFront);
            //否则往下一层遍历
            return bfs(words, nextLevel, endPath, map, isFront);
        }

        // dfs拼接路径
        public void dfs(Map<String, List<String>> map, String beginWord, String endWord, LinkedList<String> list) {
            //先添加单词头
            list.add(beginWord);
            //已经拼接完成了，则放入结果集
            if (beginWord.equals(endWord)) res.add(new ArrayList<>(list));
                //获取当前单词能到达的下一层单词列表
                //往下遍历直到拼接到目标单词
            else if (map.containsKey(beginWord))
                for (String word : map.get(beginWord))
                    dfs(map, word, endWord, list);
            //回溯删除当前单词
            list.removeLast();
        }
    }
}
