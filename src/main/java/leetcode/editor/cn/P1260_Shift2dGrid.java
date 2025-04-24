//给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。 
//
// 每次「迁移」操作将会引发下述活动： 
//
// 
// 位于 grid[i][j]（j < n - 1）的元素将会移动到 grid[i][j + 1]。 
// 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。 
// 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。 
// 
//
// 请你返回 k 次迁移操作后最终得到的 二维网格。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//输出：[[9,1,2],[3,4,5],[6,7,8]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
//输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
//输出：[[1,2,3],[4,5,6],[7,8,9]]
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m <= 50 
// 1 <= n <= 50 
// -1000 <= grid[i][j] <= 1000 
// 0 <= k <= 100 
// 
//
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 134, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二维网格迁移
 * @author Chang Liu
 * @date 2025-04-24 10:49:27
 */
public class P1260_Shift2dGrid{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1260_Shift2dGrid().new Solution();

		  int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		 List<List<Integer>> res = solution.shiftGrid(matrix, 1);

		 System.out.println(res);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	/**
	 * 这道题目是非常有意义的一道题目，其意义在于，第一次将高位数据结构转换为了一维数据结构
	 * 在以往做题过程中，总是喜欢将使用一维数据结构来转换为高维数据结构，如二维数组、树甚至图
	 * 这次确实反了过来
	 * @param grid
	 * @param k
	 * @return
	 */
	public List<List<Integer>> shiftGrid(int[][] grid, int k) {

		int m = grid.length, n = grid[0].length;
		int mn = m * n;
		k = k % mn;

		reverse(grid, 0, mn - k - 1);
		reverse(grid, mn - k, mn - 1);
		reverse(grid, 0, mn - 1);

		List<List<Integer>> res = new ArrayList<>();

		for (int[] row : grid){

			List<Integer> rowList = new ArrayList<>();

			for (int e : row){
				rowList.add(e);
			}

			res.add(rowList);

		}

		return res;

    }

	private void reverse(int[][] grid, int i, int j){

		while (i < j){
			int temp = get(grid, i);
			set(grid, i, get(grid, j));
			set(grid, j, temp);
			i++;
			j--;
		}

	}

	private int get(int[][] grid, int index){

		int n = grid[0].length;
		int i = index / n;
		int j = index % n;
		return grid[i][j];

	}

	private void set(int[][] grid, int index, int val){
		int n = grid[0].length;
		int i = index / n;
		int j = index % n;
		grid[i][j] = val;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
