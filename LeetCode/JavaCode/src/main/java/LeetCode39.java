/**
 * @author Gzy1112
 * 题目：组合总和
 * dfs深度搜索 回溯
 *对candidates每个元素是否选择
 * 不选择-dfs(candidates,target,ans,combine,index+1)-直接跳过看下一个元素
 * 选择-1.加入该元素 2.元素是否选择 3.回溯
 * combine.add(candidates[index]);
 * dfs(candidates,target-candidates[index],ans,combine,index);
 * combine.remove(combine.size()-1);
 */
import java.util.ArrayList;
import java.util.List;

class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates,target,ans,combine,0);
        return ans;
    }
    public void dfs(int[] candidates,int target,List<List<Integer>> ans,List<Integer> combine,int index){
        if(index == candidates.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(combine));
            return;
        }
        dfs(candidates,target,ans,combine,index+1);
        if(target - candidates[index] >= 0){
            combine.add(candidates[index]);
            dfs(candidates,target-candidates[index],ans,combine,index);
            combine.remove(combine.size()-1);
        }
    }
}