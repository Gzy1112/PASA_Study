/**
 * @author Gzy1112
 *题目：不同路径
 * 动态规划
 * f[i,j] = f[i-1,j]+f[i,j-1]
 */
class LeetCode62 {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for(int i=0 ; i<m ; i++){
            f[i][0] = 1;
        }
        for(int j=0 ; j<n ; j++){
            f[0][j] = 1;
        }
        for(int i=1 ; i<m ; i++){
            for(int j=1 ; j<n ; j++){
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }
}
