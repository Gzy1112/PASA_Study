/**
 * @author Gzy1112
 *  题目：对称二叉树
 * public boolean check(TreeNode p,TreeNode q){
 *         if(p==null && q==null) return true;
 *         if(p==null || q==null) return false;
 *         return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
 * }
 */
import java.util.LinkedList;
import java.util.Queue;

class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode p,TreeNode q){
        Queue<TreeNode> l = new LinkedList<>();
        l.offer(p);
        l.offer(q);
        while(!l.isEmpty()){
            p = l.poll();
            q = l.poll();
            if(p==null && q==null){
                continue;
            }
            if(p==null || q==null || p.val!=q.val){
                return false;
            }
            l.offer(p.left);
            l.offer(q.right);
            l.offer(p.right);
            l.offer(q.left);
        }
        return true;
    }
}