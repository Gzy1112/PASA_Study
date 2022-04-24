/**
 * @author Gzy1112
 *题目：不同的二叉搜索树
 * 给定一个有序序列 1-n,
 * 为了构建出一棵二叉搜索树，我们可以遍历每个数字 i，将该数字作为树根,
 * 将 1 - (i-1) 序列作为左子树,
 * 将 (i+1) - n 序列作为右子树,
 * 接着我们可以按照同样的方式递归构建左子树和右子树。
 * 原问题可以分解成规模较小的两个子问题，且子问题的解可以复用。因此，我们可以想到使用动态规划来求解本题
 * ans(n): 长度为 nn 的序列能构成的不同二叉搜索树的个数
 * F(i,n): 以 ii 为根、序列长度为 nn 的不同二叉搜索树个数 (1<=i<=n)
 * ans(n) = sum(F(i,n)) i=1-n
 * ans[0]=1 ans[1]=1
 * F(i,n) = G[i-1] * G[n-i]
 */

class LeetCode96 {
    public int numTrees(int n) {
        int[] ans = new int[n+1];
        ans[0] = 1;
        ans[1] = 1;

        for(int i=2 ; i<=n ; i++){
            for(int j=1 ; j<=i ;j++){
                ans[i] = ans[i] + ans[j-1] * ans[i-j];
            }
        }

        return ans[n];
    }
}