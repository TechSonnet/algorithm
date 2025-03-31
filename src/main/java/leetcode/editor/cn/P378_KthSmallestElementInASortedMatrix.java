//给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 请注意，它是 排序后 的第 k 小元素，而不是第 
//k 个 不同 的元素。 
//
// 你必须找到一个内存复杂度优于 O(n²) 的解决方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//输出：13
//解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[-5]], k = 1
//输出：-5
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length 
// n == matrix[i].length 
// 1 <= n <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列 
// 1 <= k <= n² 
// 
//
// 
//
// 进阶： 
//
// 
// 你能否用一个恒定的内存(即 O(1) 内存复杂度)来解决这个问题? 
// 你能在 O(n) 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（ this paper ）很有趣。 
// 
//
// Related Topics数组 | 二分查找 | 矩阵 | 排序 | 堆（优先队列） 
//
// 👍 1112, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * 有序矩阵中第 K 小的元素
 * @author Chang Liu
 * @date 2025-03-31 11:45:48
 */
public class P378_KthSmallestElementInASortedMatrix{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P378_KthSmallestElementInASortedMatrix().new Solution();

		  int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};

		 int res = solution.kthSmallest(matrix, 8);
		 System.out.println(res);

	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {

		/**
		 * 这里使用了一种十分巧妙的思路，用数组来表达一个元素 {matrix[i][j], i, j}
		 * 对于这一招，我只能给个 good
		 */

		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
			return a[0] - b[0];
		});

		for (int i = 0; i < matrix.length; i++){
			pq.add(new int[]{matrix[i][0], i, 0});
		}

		int res = -1;
		while (!pq.isEmpty() && k > 0){

			int[] cur = pq.poll();
			k--;
			res = cur[0];
			int i = cur[1], j = cur[2];

			if (j + 1 < matrix[i].length){
				pq.add(new int[]{matrix[i][j + 1], i, j+1});
			}

		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
