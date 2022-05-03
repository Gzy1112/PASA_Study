/**
 * @author Gzy1112
 *  题目：打家劫舍
 *  动态规划
 *   f(o)表示选择 o节点的情况下，o节点的子树上被选择的节点的最大权值和
 *   g(o)表示不选择 o节点的情况下，o节点的子树上被选择的节点的最大权值和；l 和 r 代表 o 的左右孩子
 */
import java.util.HashMap;
import java.util.Map;

public class LeetCode337 {
    Map<TreeNode,Integer> f = new HashMap<TreeNode,Integer>();
    Map<TreeNode,Integer> g = new HashMap<TreeNode,Integer>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }

    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node,node.val + g.getOrDefault(node.left,0) + g.getOrDefault(node.right,0));
        g.put(node,Math.max(f.getOrDefault(node.left,0),g.getOrDefault(node.left,0)) + Math.max(f.getOrDefault(node.right,0),g.getOrDefault(node.right,0)));
    }
}
