//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 题目保证可以到达 nums[n-1] 
// 
//
// Related Topics贪心 | 数组 | 动态规划 
//
// 👍 2782, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 跳跃游戏 II
 * @author Chang Liu
 * @date 2025-03-18 15:14:50
 */
public class P45_JumpGameIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P45_JumpGameIi().new Solution();
		 int jump = solution.jump(new int[]{2,3,1,1,4});
		 System.out.println(jump);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//
//		 // 动态规划解法（暴力解）
//
//    public int jump(int[] nums) {
//
//		int minSteps = dp(nums, 0);
//
//		return minSteps;
//    }
//
//	int dp(int[] nums, int position){
//
//		if (position >= nums.length - 1){
//			return 0;
//		}
//
//		int res = Integer.MAX_VALUE;
//
//		for (int i = 1; i <= nums[position]; i++) {
//
//			int subProblem = dp(nums, position + i);
//
//			if (subProblem != Integer.MAX_VALUE){
//				res = Math.min(res, subProblem + 1);
//			}
//
//		}
//
//		return res;
//	}
//}

	class Solution {

		// 动态规划解法（备忘录解法）

		int[] memo;

		public int jump(int[] nums) {

			memo = new int[nums.length];
			// 这里使用 Integer.MAX_VALUE - 100 是很冒险的，一开始用了 Integer.MAX_VALUE ，直接溢出了
			Arrays.fill(memo, Integer.MAX_VALUE - 100);
			int res = dp(nums, 0);

			return res;
		}

		int dp(int[] nums, int position){

			if (position >= nums.length - 1){
				return 0;
			}

			if (memo[position] != Integer.MAX_VALUE - 100){
				return memo[position];
			}

			for (int i = 1; i <= nums[position]; i++) {

				int subProblem = dp(nums, position + i);
				memo[position] = Math.min(memo[position], subProblem + 1);

			}
			return memo[position];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
