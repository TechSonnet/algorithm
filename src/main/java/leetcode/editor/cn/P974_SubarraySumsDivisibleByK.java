//给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的非空 子数组 的数目。 
//
// 子数组 是数组中 连续 的部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,0,-2,-3,1], k = 5
//输出：7
//解释：
//有 7 个子数组满足其元素之和可被 k = 5 整除：
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// 示例 2: 
//
// 
//输入: nums = [5], k = 9
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 2 <= k <= 10⁴ 
// 
//
// Related Topics数组 | 哈希表 | 前缀和 
//
// 👍 550, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 和可被 K 整除的子数组
 * @author Chang Liu
 * @date 2025-05-14 17:18:21
 */
public class P974_SubarraySumsDivisibleByK{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P974_SubarraySumsDivisibleByK().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {

		// 利用前缀和数组中的元素余数相同，这中间的数组之和加起来相等，来优化暴力解算法


		int n = nums.length;
		int[] preSum = new int[n + 1];

		HashMap<Integer, Integer> reminderToCount = new HashMap<>();
		reminderToCount.put(0, 1);

		int res = 0;

		for (int i = 1; i <= n; i++) {

			preSum[i] = preSum[i - 1] + nums[i - 1];

			// 避免余数为 负数
			int curReminder = ((preSum[i] % k) + k ) % k;

			if (reminderToCount.containsKey(curReminder)){

				res += reminderToCount.get(curReminder);
				reminderToCount.put(curReminder, reminderToCount.get(curReminder) + 1);

			} else {

				reminderToCount.put(curReminder, 1);

			}


		}

		return res;


    }

	public int subarraysDivByK2(int[] nums, int k) {

		int n = nums.length;
		int[] preSum = new int[n + 1];

		for (int i = 0; i < n; i++) {
			preSum[i + 1] = preSum[i] + nums[i];
		}

		int res = 0;

		// 暴力解，但是超出了时间限制
		// 这也给了我们一个提示，哈希表是用来替换第二层循环的，使用哈希表的特性，避免了一次循环
		for (int i = 0; i < preSum.length; i++){
			for (int j = i + 1; j < preSum.length; j++) {
				if ((preSum[j] - preSum[i]) % k == 0){
					res++;
				}
			}
		}

		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
