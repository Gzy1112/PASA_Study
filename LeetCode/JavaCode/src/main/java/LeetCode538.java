/**
 * @author Gzy1112
 *  题目：把二叉搜索树转换为累加树
 *  反序中序遍历
 */
public class LeetCode538 {
    public int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            sum = sum + root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
