import java.util.ArrayList;
import java.util.List;

/**
 * @author Gzy1112
 * 题目：二叉树展开为列表
 */
class LeetCode114 {
    public void flatten(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        preorder(root,ans);
        int size = ans.size();
        for(int i=1 ; i<size ; i++){
            TreeNode prev = ans.get(i-1);
            TreeNode cur = ans.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }
    public void preorder(TreeNode root,List<TreeNode> ans){
        if(root != null){
            ans.add(root);
            preorder(root.left,ans);
            preorder(root.right,ans);
        }
    }
}