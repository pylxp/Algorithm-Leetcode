package java.t31_t40;

public class T39 {
    class Solution {
        //提取为全局变量，方便调用
        //先根据返回类型创建结果集
        List<List<Integer>> res = new ArrayList<>();
        //用于存放单次结果
        List<Integer> list = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            //空集不处理
            if (candidates == null) return res;
            //调用递归遍历方法
            dfs(candidates.length - 1, candidates, target);
            //返回结果
            return res;
        }

        //默认每次添加的值，不能超过上一次添加的值，即往小于等于加，防止重复
        //即通过剪枝有效防止重复结果
        public void dfs(int lastIndex, int[] candidates, int target) {

            //表明符合结果，加入结果集
            if (target == 0) {
                res.add(new ArrayList<Integer>(list));
                return;
            }
            //遍历数集，计算所有可能成立的结果
            for (int i = 0; i <= lastIndex; i++) {
                //满足添加空间。则继续添加
                if (candidates[i] <= target) {
                    //加入临时列表
                    list.add(candidates[i]);
                    //继续递归添加
                    dfs(i, candidates, target - candidates[i]);
                    //不满足结果，则要删除当前添加的值,即最后一个值
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
