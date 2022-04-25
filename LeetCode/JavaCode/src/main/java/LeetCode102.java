/**
 * @author Gzy1112
 *  题目：二叉树层序遍历
 *  广度优先
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for(int i=1 ; i<=currentLevelSize ; i++){
                TreeNode p = queue.poll();
                level.add(p.val);
                if(p.left!=null){
                    queue.offer(p.left);
                }
                if(p.right!=null){
                    queue.offer(p.right);
                }
            }
            ans.add(new ArrayList<>(level));
        }
        return ans;
    }
}