//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//
// Related Topics数组 | 哈希表 
//
// 👍 19650, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author Chang Liu
 * @date 2025-04-27 10:30:52
 */
public class P1_TwoSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1_TwoSum().new Solution();

		 int[] ints = solution.twoSum(new int[]{3,2,4}, 6);

		 System.out.println(Arrays.toString(ints));
	 }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum2(int[] nums, int target) {

		/**
		 * 仅适用无重复元素的情况
		 */
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		Arrays.sort(nums);

		int left = 0, right = nums.length - 1;
	   while (left <= right){
		   if (nums[left] + nums[right] == target){
			   return new int[]{map.get(nums[left]), map.get(nums[right])};
		   }else if (nums[left] + nums[right] < target){
			   left++;
		   }else if (nums[left] + nums[right] > target){
			   right--;
		   }
	   }
	   return new int[]{0, 0};
    }

	public int[] twoSum(int[] nums, int target){

		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			if (hashMap.containsKey(target - nums[i])){
				return new int[]{hashMap.get(target - nums[i]), i};
			}

			hashMap.put(nums[i], i);
		}

		return new int[]{0, 0};
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
