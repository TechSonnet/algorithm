//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
//
// Related Topics数组 | 数学 | 矩阵 
//
// 👍 2045, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 旋转图像
 * @author Chang Liu
 * @date 2025-04-18 17:43:35
 */
public class P48_RotateImage{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P48_RotateImage().new Solution();

          int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

          for (int[] row : matrix){
              System.out.println(Arrays.toString(row));
          }

     }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        // 1. 先以主对角线镜像

        int length = matrix.length;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) { // 一定要注意这里，矩阵是如何找上右三角的
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. 再以主对称轴对称

        for (int[] row : matrix){
            int left = 0, right = row.length - 1;
            while (left < right){
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }
    }


    public void rotate2(int[][] matrix){

        int length = matrix.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] row : matrix){
            int left = 0, right = row.length - 1;
            while (left < right){
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
