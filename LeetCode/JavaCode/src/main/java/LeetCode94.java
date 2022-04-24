import java.util.ArrayList;
import java.util.List;
/**
 * @author Gzy1112
 *题目：二叉树中序遍历
 */

class LeetCode94 {
    List<Integer> order = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root,order);
        return order;
    }
    public void inorder(TreeNode root, List<Integer> order){
        if(root == null){
            return;
        }
        inorder(root.left,order);
        order.add(root.val);
        inorder(root.right,order);
    }
}

