/**
 * @author Gzy1112
 * 题目：全排列
 * dfs深度搜索 回溯 剪枝
 *
 */
import java.util.ArrayList;
import java.util.List;

class LeetCode42 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums,path,res);
        return res;
    }

    private void dfs(int[] nums,List<Integer> path,List<List<Integer>> res){
        if(path.size() == nums.length){
            /**
             * res.add(new ArrayList(path))：开辟一个独立地址，地址中存放的内容为path链表，后续path的变化不会影响到res
             * res.add(path)：将res尾部指向了path地址，后续path内容的变化会导致res的变化。
            */
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i : nums){
            /**
             * 剪枝
             */
            if(path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums,path,res);
            path.remove(path.size()-1);
        }
    }
}