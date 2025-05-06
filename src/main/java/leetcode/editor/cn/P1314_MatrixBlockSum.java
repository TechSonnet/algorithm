//给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素
//mat[r][c] 的和： 
//
// 
// i - k <= r <= i + k, 
// j - k <= c <= j + k 且 
// (r, c) 在矩阵内。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//输出：[[12,21,16],[27,45,33],[24,39,28]]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
//输出：[[45,45,45],[45,45,45],[45,45,45]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n, k <= 100 
// 1 <= mat[i][j] <= 100 
// 
//
// Related Topics数组 | 矩阵 | 前缀和 
//
// 👍 213, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 矩阵区域和
 * @author Chang Liu
 * @date 2025-05-05 16:27:44
 */
public class P1314_MatrixBlockSum{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P1314_MatrixBlockSum().new Solution();
		 int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		 int[][] res = solution.matrixBlockSum(matrix, 1);
		 System.out.println(Arrays.deepToString(res));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {

		int m = mat.length, n = mat[0].length;
		int[][] res = new int[m][n];
		NumMatrix numMatrix = new NumMatrix(mat);

		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++){
				int x1 = Math.max(i - k, 0);
				int y1 = Math.max(j - k, 0);
				int x2 = Math.min(i + k, m - 1);
				int y2 = Math.min(j + k, n - 1);
				res[i][j] = numMatrix.sumRegion(x1, y1, x2, y2);
			}
		}

		return res;
    }
}

class NumMatrix{

		 public int[][] preSum;

		 public NumMatrix(int[][] matrix){

			 int m = matrix.length, n = matrix[0].length;
			 if (m == 0 || n == 0) return;

			 preSum = new int[m + 1][n + 1];

			 for (int i = 1; i <= m; i++){
				 for (int j = 1; j <= n; j++) {
					 preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1]
							 + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
				 }
			 }

		 }

		 public int sumRegion(int x1, int y1, int x2, int y2){
			 return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1]
					 + preSum[x1][y1];
		 }
}
//leetcode submit region end(Prohibit modification and deletion)

}
