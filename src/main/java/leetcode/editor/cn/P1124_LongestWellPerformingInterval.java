//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 示例 2： 
//
// 
//输入：hours = [6,6,6]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10⁴ 
// 0 <= hours[i] <= 16 
// 
//
// Related Topics栈 | 数组 | 哈希表 | 前缀和 | 单调栈 
//
// 👍 573, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 表现良好的最长时间段
 * @author Chang Liu
 * @date 2025-05-15 14:59:55
 */
public class P1124_LongestWellPerformingInterval{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P1124_LongestWellPerformingInterval().new Solution();
		 int[] hours = {6,6,6};
		 int res = solution.longestWPI(hours);
		 System.out.println(res);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestWPI(int[] hours) {

		int n = hours.length;
		int[] preSum = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			// 这里的归一化思路，应该仔细学习才好
			preSum[i] = preSum[i-1] + (hours[i-1] > 8 ? 1 : -1);
		}

		HashMap<Integer, Integer> valToIndex = new HashMap<>();

		int res = 0;
		for (int i = 0; i < preSum.length; i++){

			if (!valToIndex.containsKey(preSum[i])){
				valToIndex.put(preSum[i], i);
			} else {
				// 理清楚这里的逻辑，追求最长长度，所以此处什么都不用做，仅仅保留第一次的结果就可以
				// 如果更新，就无法确保为最长长度
			}

			if (preSum[i] > 0){
				res = Math.max(res, i);
			} else {
				int need = preSum[i] - 1;
				if (valToIndex.containsKey(need)){
					res = Math.max(res, i - valToIndex.get(need));
				}
			}

		}

		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
