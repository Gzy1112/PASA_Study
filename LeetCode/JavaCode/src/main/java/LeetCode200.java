/**
 * @author Gzy1112
 * 题目：岛屿数量
 * dfs
 * 当找到一个‘1’，岛屿数加1，与其相连接的‘1’全部变为‘0’
 * 再找下一个‘1’
 */
public class LeetCode200 {
    void dfs(char[][] grid,int r,int c){
        int nr = grid.length;
        int nc = grid[0].length;
        if(r<0 || c<0 || r>=nr || c>=nc || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for(int r=0 ; r<nr ; r++){
            for(int c=0 ; c<nc ; c++){
                if(grid[r][c]=='1'){
                    num_islands++;
                    dfs(grid,r,c);
                }
            }
        }
        return num_islands;
    }
}
