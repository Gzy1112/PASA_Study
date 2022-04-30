/**
 * @author Gzy1112
 *  题目：翻转二叉树
 *  递归
 *  若左子树已完成翻转，右子树也已完成翻转
 *  此时只需要交换左右子树
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
