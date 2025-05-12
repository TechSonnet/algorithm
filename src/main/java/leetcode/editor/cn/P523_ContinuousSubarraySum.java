//给你一个整数数组 nums 和一个整数 k ，如果 nums 有一个 好的子数组 返回 true ，否则返回 false： 
//
// 一个 好的子数组 是： 
//
// 
// 长度 至少为 2 ，且 
// 子数组元素总和为 k 的倍数。 
// 
//
// 注意： 
//
// 
// 子数组 是数组中 连续 的部分。 
// 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终 视为 k 的一个倍数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [23,2,4,6,7], k = 6
//输出：true
//解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。 
//
// 示例 2： 
//
// 
//输入：nums = [23,2,6,4,7], k = 6
//输出：true
//解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
//42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [23,2,6,4,7], k = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= sum(nums[i]) <= 2³¹ - 1 
// 1 <= k <= 2³¹ - 1 
// 
//
// Related Topics数组 | 哈希表 | 数学 | 前缀和 
//
// 👍 615, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 连续的子数组和
 * @author Chang Liu
 * @date 2025-05-12 10:01:48
 */
public class P523_ContinuousSubarraySum{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P523_ContinuousSubarraySum().new Solution();
		 int[] nums = new int[]{23, 2, 6, 4, 7};
		 boolean res = solution.checkSubarraySum(nums, 13);
		 System.out.println(res);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

		int n = nums.length;
		int[] preSum = new int[n + 1];

		for (int i = 0; i < n; i++) {
			preSum[i + 1] = preSum[i] + nums[i];
		}

		/**
		 * 关于本题目的感悟就比较多，前缀和是一个主要练习的技巧，基础工具
		 * 此外，哈希表更是一个技巧，从 525 523 两个题目来看，
		 */

		HashMap<Integer, Integer> valToIndex = new HashMap<>();

		for (int i = 0; i < preSum.length; i++) {

			int val = preSum[i] % k;

			if (!valToIndex.containsKey(val)){
				valToIndex.put(val, i);
			}
		}

		for (int i = 0; i < preSum.length; i++) {

			int need = preSum[i] % k;

			if (valToIndex.containsKey(need)){
				if (i - valToIndex.get(need) >= 2){
					return true;
				}
			}

		}

		return false;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
