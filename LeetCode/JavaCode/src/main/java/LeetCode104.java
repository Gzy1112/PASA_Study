/**
 * @author Gzy1112
 * 题目：二叉树的最大深度
 */
class LeetCode104{
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        else{
            int leftDepth = maxDepth(root.left);
            int rigthDepth = maxDepth(root.right);
            return Math.max(leftDepth,rigthDepth) + 1;
        }
    }
}