/**
 * @author Gzy1112
 * 题目：旋转图像
 * 方法一：使用辅助数组
 * 方法二：原地选转
 * 方法三：先水平翻转+再对角线翻转
 */


/**方法3：先水平翻转+再对角线翻转
水平(row,col) -> (n-row-1,col)
对角线(row,col) -> (col,row)
即(row,col) -> (n-row-1,col) -> (col,n-row-1)
 */
class LeetCode48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int a = 2;
        for(int i=0;i<n/a;i++){
            for(int j=0;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

//方法一：使用辅助数组
//matrix[i][j] = matrix[j][n-i-1]
// class Solution {
//     public void rotate(int[][] matrix) {
//         int n = matrix.length;
//         int[][] newMatrix = new int[n][n];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 newMatrix[j][n-i-1] = matrix[i][j];
//             }
//         }
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 matrix[i][j] = newMatrix[i][j];
//             }
//         }
//     }
// }

//方法二：原地选转
// (col,n-row-1) = (row,col)
// (n-row-1,n-col-1) = (col,n-row-1)
// (n-col-1,row) = (n-row-1,n-col-1)
// (row,col) = (n-col-1,row)
// class Solution {
//     public void rotate(int[][] matrix) {
//         int n = matrix.length;
//         for(int i=0;i<n/2;i++){
//             for(int j=0;j<(n+1)/2;j++){
//                 int temp = matrix[i][j];
//                 matrix[i][j] = matrix[n-j-1][i];
//                 matrix[n-j-1][i] =  matrix[n-i-1][n-j-1];
//                 matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
//                 matrix[j][n-i-1] = temp;

//             }
//         }
//     }
// }