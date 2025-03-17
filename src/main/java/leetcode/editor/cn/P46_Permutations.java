//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 3053, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * @author Chang Liu
 * @date 2025-03-06 15:00:08
 */
public class P46_Permutations{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P46_Permutations().new Solution();

		  int[] nums = {1,2,3};

		 List<List<Integer>> permute = solution.permute(nums);
		 System.out.println(permute);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

		 List<List<Integer>> res = new LinkedList<>();
		 LinkedList<Integer> track = new LinkedList<>();

		 boolean[] used;

    public List<List<Integer>> permute(int[] nums) {

		used = new boolean[nums.length];
		backtrack(nums, nums.length);
        return res;
    }

	void backtrack(int[] nums, int k){
		// 收集满足条件的结果
		if (track.size() == k){
			res.add(new LinkedList<>(track));
			return;
		}

		// 回溯寻找结果
		for (int i = 0; i < nums.length; i++) {
			if (used[i]){
				continue;
			}
			used[i] = true;
			track.addLast(nums[i]);
			backtrack(nums, nums.length);
			track.removeLast();
			used[i] = false;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
