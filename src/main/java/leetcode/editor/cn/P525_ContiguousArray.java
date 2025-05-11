//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1]
//输出：2
//说明：[0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0]
//输出：2
//说明：[0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 3： 
//
// 
//输入：nums = [0,1,1,1,1,1,0,0,0]
//输出：6
//解释：[1,1,1,0,0,0] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 
//
// Related Topics数组 | 哈希表 | 前缀和 
//
// 👍 789, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 连续数组
 * @author Chang Liu
 * @date 2025-05-09 10:57:44
 */
public class P525_ContiguousArray{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P525_ContiguousArray().new Solution();
		 int[] nums = new int[]{0, 1, 0};
		 int maxLength = solution.findMaxLength(nums);
		 System.out.println(maxLength);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {

		int n = nums.length;
		int[] preSum = new int[n + 1];

		for (int i = 0; i < n; i++) {
			preSum[i+1] = preSum[i] + (nums[i] == 0 ? -1 : 1);
		}

		Map<Integer, Integer> valToIndex = new HashMap<>();
		int res = 0;

		for (int i = 0; i < preSum.length; i++) {
			if (!valToIndex.containsKey(preSum[i])){
				valToIndex.put(preSum[i], i);
			}else {
				// 这里有一个非常绕的逻辑：如果前缀和出现过，就代表这中间的所有元素的和为 0
				// 非常妙的逻辑
				res = Math.max(res, i - valToIndex.get(preSum[i]));
			}
		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
