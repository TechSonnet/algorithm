//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics数组 | 回溯 | 排序 
//
// 👍 1690, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II
 * @author Chang Liu
 * @date 2025-03-10 15:51:37
 */
public class P47_PermutationsIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P47_PermutationsIi().new Solution();
		 List<List<Integer>> res = solution.permuteUnique(new int[]{1, 1, 2});
		 System.out.println(res);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

		 List<List<Integer>> res = new LinkedList<>();
		 LinkedList<Integer> track = new LinkedList<>();
		 boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {

		Arrays.sort(nums);
		visited = new boolean[nums.length];
		backtrack(nums);

		return res;
    }

	void backtrack(int[] nums){

		if (track.size() == nums.length){
			res.add(new LinkedList<>(track));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (visited[i]){
				continue;
			}

			/**
			 * i > 0 防止数组越界
			 * nums[i-1] == nums[i] 剪枝逻辑
			 * !visited[i-1] 前一个元素没有被访问过，跳过这次循环，这放宽了剪枝的逻辑
			 * 如果去掉，只要前一个元素和这个元素相同，就直接剪掉，会造成某些树枝被误剪
			 */
			if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
				continue;
			}

			track.add(nums[i]);
			visited[i] = true;
			backtrack(nums);
			track.removeLast();
			visited[i] = false;

		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
