/**
 * @author Gzy1112
 *  题目：二叉树的直径
 *  深度优先搜索
 */
public class LeetCode543 {
    public int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }
    public int depth(TreeNode root){
        if(root == null){
            //返回节点深度
            return 0;
        }
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        //更新最大直径
        ans = Math.max(lDepth+rDepth,ans);
        //返回节点深度
        return Math.max(lDepth,rDepth) + 1;
    }
}
