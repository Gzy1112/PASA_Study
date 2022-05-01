/**
 * @author Gzy1112
 *  题目：搜索二维矩阵
 *  方法一：暴力
 *  方法二：二分
 *  因为每一行都是递增的，对每一行使用二分搜索（注意while（low<=high））
 *  方法三：z字形，从（0，n-1）开始
 */
public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row : matrix){
            int index = searchTarget(row,target);
            if(index>=0){
                return true;
            }
        }
        return false;
    }
     public int searchTarget(int[] row,int target){
         int low = 0;
         int high = row.length - 1;
         while(low<=high){
             int mid = low + (high - low) / 2;
             int num = row[mid];
             if(num == target){
                 return mid;
             }
             else if(num > target){
                 high = mid - 1;
             }
             else{
                 low = mid + 1;
             }
         }
         return -1;
     }
}
