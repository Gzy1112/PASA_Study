import java.util.HashMap;
import java.util.Map;

/**
 * @author Gzy1112
 * 题目：根据前序和中序构建二叉树
 */
class LeetCode105 {
    private Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>(n);
        for(int i=0 ; i<n ; i++){
            indexMap.put(inorder[i],i);
        }
        return buildNewTree(preorder,inorder,0,n-1,0,n-1);
    }
    public TreeNode buildNewTree(int[] preorder,int[] inorder,int preorderLeft,int preorderRight,int inorderLeft,int inorderRight){
        if(preorderLeft>preorderRight){
            return null;
        }
        int preorderRoot = preorderLeft;
        int inorderRoot = indexMap.get(preorder[preorderRoot]);
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        int sizeLeftSubtree = inorderRoot - inorderLeft;
        root.left = buildNewTree(preorder,inorder,preorderLeft+1,preorderLeft+sizeLeftSubtree,inorderLeft,inorderRoot-1);
        root.right = buildNewTree(preorder,inorder,preorderLeft+sizeLeftSubtree+1,preorderRight,inorderRoot+1,inorderRight);
        return root;

    }
}