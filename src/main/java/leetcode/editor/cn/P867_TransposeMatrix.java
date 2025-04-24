//给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。 
//
// 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[1,4,7],[2,5,8],[3,6,9]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6]]
//输出：[[1,4],[2,5],[3,6]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 1000 
// 1 <= m * n <= 10⁵ 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 
//
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 286, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 转置矩阵
 * @author Chang Liu
 * @date 2025-04-24 11:23:04
 */
public class P867_TransposeMatrix{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P867_TransposeMatrix().new Solution();

		  int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		 int[][] newMat = solution.transpose(matrix);
		 System.out.println(Arrays.deepToString(newMat));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] transpose(int[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;
		int[][] newMatrix = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <m; j++) {
				newMatrix[i][j] = matrix[j][i];
			}
		}

		return newMatrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
