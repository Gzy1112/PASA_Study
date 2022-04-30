
/**
 * @author Gzy1112
 *  题目：二叉树的最近公共祖先
 *  递归
 *  若一个在左子树，一个在右子树，返回root
 *  若两个都在左子树，返回lNode
 *  若两个都在右子树，返回rNode
 */
public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q){
            return root;
        }
        if(root != null){
            TreeNode lNode = lowestCommonAncestor(root.left,p,q);
            TreeNode rNode = lowestCommonAncestor(root.right,p,q);
            if(lNode!=null&&rNode!=null){
                return root;
            }
            else if(lNode==null){
                return rNode;
            }
            else{
                return lNode;
            }
        }
        return null;
    }
}
