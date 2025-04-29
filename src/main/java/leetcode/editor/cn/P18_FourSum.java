//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 2052, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * @author Chang Liu
 * @date 2025-04-29 10:05:24
 */
public class P18_FourSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P18_FourSum().new Solution();

		 List<List<Integer>> res = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
		 System.out.println(res);


	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, long target) {

		// 每次只需要排序一次就够了
		Arrays.sort(nums);

		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < len; i++){

			List<List<Integer>> tuples = treeSumTarget(nums, i + 1, target - nums[i]);

			for (List<Integer> tuple : tuples){
				tuple.add(nums[i]);
				res.add(tuple);
			}

			// 仔细体会，此处是怎么避免数组越界的，这是一个很常见的情况
			while (i < len - 1 && nums[i] == nums[i + 1]) i++;
		}


		return res;
    }

	private List<List<Integer>> treeSumTarget(int[] nums, int start, long target){

		// 已经排过序，此处不必再次排序

		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();

		for (int i = start; i < len; i++){

			List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);

			for (List<Integer> tuple : tuples) {
				tuple.add(nums[i]);
				res.add(tuple);
			}

			while (i < len - 1 && nums[i] == nums[i + 1]) i++;
		}

		return res;
	}

	private List<List<Integer>> twoSumTarget(int[] nums, int start, long target){

		List<List<Integer>> res = new ArrayList<>();
		int len = nums.length;
		int left = start, right = len - 1;

		while (left < right){

			int lo = nums[left], hi = nums[right];
			int sum = lo + hi;

			if (sum == target){
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(lo);
				temp.add(hi);
				res.add(temp);
				while (left < right && lo == nums[left]) left++;
				while (left < right && hi == nums[right]) right--;
			}else if (sum < target){
				left++;
			}else if (sum > target){
				right--;
			}
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
