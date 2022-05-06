import java.util.*;

/**
 * @author Gzy1112
 *  题目：任务调度器
 *  我们需要选择不在冷却中并且剩余执行次数最多的那个任务
 *  time 记录当前的时间
 *  二元组第i个任务(nextValid_i,rest_i)
 *  nextValid_i--其因冷却限制，最早可以执行的时间
 *  rest_i--其剩余执行次数
 *  我们需要找到满足 nextValid_i ≤time 并且 rest_i的最大的索引 i
 *
 */
public class LeetCode621 {
    public int leastInterval(char[] tasks, int n) {
        //统计任务出现次数
        Map<Character,Integer> freq = new HashMap<>(tasks.length+1);
        for(char ch : tasks){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        //任务总数
        int m = freq.size();
        //初始化nexValid和rest
        List<Integer> nextValid = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();
        //entrySet() 方法可以与 for-each 循环一起使用，用来遍历迭代 HashMap 中每一个映射项
        Set<Map.Entry<Character,Integer>> entrySet = freq.entrySet();
        for(Map.Entry<Character,Integer> entry : entrySet){
            int value = entry.getValue();
            nextValid.add(1);
            rest.add(value);
        }
        //time模拟时间片
        int time = 0;
        for(int i=0 ; i<tasks.length ; i++){
            time++;
            //寻找最近的时间
            int minNextValid = Integer.MAX_VALUE;
            for(int j=0 ; j<m ; j++){
                if(rest.get(j)!=0){
                    minNextValid = Math.min(minNextValid,nextValid.get(j));
                }
            }
            time = Math.max(time,minNextValid);
            //寻找频次最高的的合适的任务
            int best = -1;
            for(int j=0 ; j<m ; j++){
                if(rest.get(j)!=0 && nextValid.get(j)<=time){
                    if(best == -1 || rest.get(j)>rest.get(best)){
                        best = j;
                    }
                }
            }
            //更新执行任务后该任务的nextValid和rest
            nextValid.set(best,time+n+1);
            rest.set(best,rest.get(best)-1);
        }
        return time;
    }
}
