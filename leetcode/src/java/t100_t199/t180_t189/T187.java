package java.t100_t199.t180_t189;

public class T187 {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            //查找在s字符串中出现超过一次的长度为10的子串
            //最容易想到的方法，维持两个存储，一个存放第一次遍历过的子串
            //一个存放多次遍历的子串即可

            //存放遍历过的子串
            Set<String> visited = new HashSet<>();
            //存放结果子串
            Set<String> res = new HashSet<>();
            //遍历字符串，最后9个字符不用多余遍历，长度不足10
            for (int i = 0; i <= (s.length() - 10); i++) {
                //截取子串
                String str = s.substring(i, i + 10);
                //遍历过的，则加入结果
                if (visited.contains(str)) res.add(str);
                    //未遍历过的，则加入已遍历
                else visited.add(str);
            }
            //返回结果
            return new ArrayList<>(res);
        }
    }
}
