/**
 * @author Gzy1112
 * 题目：课程表
 * 转换为有向图是否存在环的问题
 * 拓扑排序
 */
import java.util.ArrayList;
import java.util.List;

class LeetCode207 {
    List<List<Integer>> edges;
    int[] visited;
    /**
     * 0-未搜索 1-搜索中 2-搜索完成
     */
    boolean valid = true;
    public void dfs(int u){
        visited[u] = 1;
        for(int v : edges.get(u)){
            if(visited[v] == 0){
                dfs(v);
                if(!valid){
                    return;
                }
            }
            else if(visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for(int i=0 ; i<numCourses ; i++){
            edges.add(new ArrayList<>());
        }
        for(int[] info : prerequisites){
            edges.get(info[1]).add(info[0]);
        }
        visited = new int[numCourses];
        for(int i=0 ; i<numCourses && valid ; i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }
        return valid;
    }
}