/**
 * @author Gzy1112
 *  题目：路径总和III
 *  dfs
 */
public class LeetCode437 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int ret = rootSum(root,targetSum);
        ret = ret + pathSum(root.left,targetSum);
        ret = ret + pathSum(root.right,targetSum);
        return ret;
    }
    public int rootSum(TreeNode root,int targetSum){
        int ret = 0;
        if(root == null){
            return 0;
        }
        int val = root.val;
        if(val == targetSum){
            ret++;
        }
        ret = ret + rootSum(root.left,targetSum-val);
        ret = ret + rootSum(root.right,targetSum-val);
        return ret;
    }
}
