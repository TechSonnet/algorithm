//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 1448, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 螺旋矩阵 II
 * @author Chang Liu
 * @date 2025-04-20 16:08:41
 */
public class P59_SpiralMatrixIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P59_SpiralMatrixIi().new Solution();

		 int[][] matrix = solution.generateMatrix(3);

		 System.out.println(Arrays.deepToString(matrix));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {

		int[][] matrix = new int[n][n];
		int upper_bound = 0, lower_bound = n - 1;
		int left_bound = 0, right_bound = n - 1;

		int num = 1;
		while (num <= n * n){

			if (upper_bound <= lower_bound){
				for (int j = left_bound; j <= right_bound; j++){
					matrix[upper_bound][j] = num++;
				}
				upper_bound++;
			}

			if (left_bound <= right_bound){
				for (int i = upper_bound; i <= lower_bound; i++){
					matrix[i][right_bound] = num++;
				}
				right_bound--;
			}

			if (upper_bound <= lower_bound){
				for (int j = right_bound; j >= left_bound; j--){
					matrix[lower_bound][j] = num++;
				}
				lower_bound--;
			}

			if (left_bound <= right_bound){
				for (int i = lower_bound; i >= upper_bound; i--){
					matrix[i][left_bound] = num++;
				}
				left_bound++;
			}

		}

		return matrix;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
