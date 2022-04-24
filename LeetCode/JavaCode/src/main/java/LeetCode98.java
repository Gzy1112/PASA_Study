/**
 * @author Gzy1112
 *题目：验证二叉搜索树
 */
class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        return validBTS(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean validBTS(TreeNode root,long lower,long upper){
        if(root == null){
            return true;
        }
        if(root.val <= lower || root.val >= upper){
            return false;
        }
        return validBTS(root.left,lower,root.val) && validBTS(root.right,root.val,upper);
    }
}