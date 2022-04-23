/**
 * @author Gzy1112
 *题目：合并区间
 * 先排序
 * 第一个区间加入merged
 * 后序遍历区间
 * 当前区间的左端点大于merged中最右端的点，说明不重合，当前区间加入merged
 * 当前区间的左端点小于merged中最右端的点，说明不重合，更新merged中右端的点（选较大值）
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][2];
        }
        //对二维数组进行排序
        Arrays.sort(intervals,new Comparator<>(){
            @Override
            public int compare(int[] interval1,int[] interval2){
                //[0]代表对左端点进行排序 [1]代表右端点进行排序
                //interval1-interval2代表升序
                //interval2-interval1代表降序
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for(int[] x : intervals){
            int left = x[0];
            int right = x[1];
            if(merged.size() == 0 || merged.get(merged.size()-1)[1] < left){
                merged.add(new int[]{left,right});
            }
            else{
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],right);
            }
        }
        //toArray() 方法将 Arraylist 对象转换为数组
        return merged.toArray(new int[merged.size()][]);
    }
}