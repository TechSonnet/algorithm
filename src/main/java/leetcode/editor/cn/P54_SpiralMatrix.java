//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 1911, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 螺旋矩阵
 * @author Chang Liu
 * @date 2025-04-20 15:52:01
 */
public class P54_SpiralMatrix{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P54_SpiralMatrix().new Solution();

		  int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		 List<Integer> res = solution.spiralOrder(matrix);
		 System.out.println(res);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> res = new ArrayList<>();

		int m = matrix.length, n = matrix[0].length;
		int upper_bound = 0, lower_bound = m - 1;
		int left_bound = 0, right_bound = n - 1;

		while (res.size() < m * n){

			if (upper_bound <= lower_bound){
				for (int j = left_bound; j <= right_bound; j++){
					res.add(matrix[upper_bound][j]);
				}
				upper_bound++;
			}

			if (left_bound <= right_bound){
				for (int i = upper_bound; i <= lower_bound; i++){
					res.add(matrix[i][right_bound]);
				}
				right_bound--;
			}

			if (upper_bound <= lower_bound){
				for (int j = right_bound; j >= left_bound; j--){
					res.add(matrix[lower_bound][j]);
				}
				lower_bound--;
			}

			if (left_bound <= right_bound){
				for (int i = lower_bound; i >= upper_bound; i--){
					res.add(matrix[i][left_bound]);
				}
				left_bound++;
			}
		}

		return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
