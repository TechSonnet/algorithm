//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 7450, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三数之和
 * @author Chang Liu
 * @date 2025-04-28 12:05:21
 */
public class P15_ThreeSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P15_ThreeSum().new Solution();

		  int[] nums = new int[]{-1,0,1,2,-1,-4};
		  List<List<Integer>> res = solution.threeSum(nums);
		 System.out.println(res);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumTarget(nums, 0);
    }

	public List<List<Integer>> threeSumTarget(int[] nums, int target){

		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < len; i++) {

			List<List<Integer>> tuples = twoSumTarget(nums,i + 1,  target - nums[i]);

			for (List<Integer> tuple : tuples){
				tuple.add(nums[i]);
				res.add(tuple);
			}

			while (i < len - 1 && nums[i] == nums[i+1]) i++; // 这个语句设计的太妙了，利用了两次 i++
		}

		return res;
	}

	public List<List<Integer>> twoSumTarget(int[] nums,int start, int target){

        int left = start, right = nums.length - 1;
		List<List<Integer>> res = new ArrayList<>();

		while (left < right){

			int sum = nums[left] + nums[right];
			int lo = nums[left], hi = nums[right];

			if(sum == target){
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(lo);
				temp.add(hi);
				res.add(temp);
				while (left < right && lo == nums[left]) left++;
				while (left < right && hi == nums[right]) right--;
			} else if (sum < target) {
				left++;
			} else if (sum > target){
				right--;
			}
		}

		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
