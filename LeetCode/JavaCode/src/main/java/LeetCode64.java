/**
 * @author Gzy1112
 *题目：最小路径之和
 * 动态规划
 * dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
 *
 */
class LeetCode64 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=1 ; i<rows ; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j=1 ; j<cols ; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i=1 ; i<rows ; i++){
            for(int j=1 ; j<cols ; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }
}