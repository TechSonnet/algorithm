//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics数组 | 哈希表 | 前缀和 
//
// 👍 2755, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 和为 K 的子数组
 * @author Chang Liu
 * @date 2025-05-14 16:18:58
 */
public class P560_SubarraySumEqualsK{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P560_SubarraySumEqualsK().new Solution();
         int[] nums = new int[]{1, 1, 1};
         int res = solution.subarraySum(nums, 2);
         System.out.println(res);
     }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        int[] preSum = new int[n + 1];

        int res = 0;

        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        for (int i = 1; i <= n; i++) {

            preSum[i] = preSum[i - 1] + nums[i - 1];

            // 深刻理解这句代码，可以翻译为 preSum_现在 - preSum_以前 = k， 中间是符合要求的数组
            int need = preSum[i] - k;

            if (count.containsKey(need)){
                res  += count.get(need);
            }

            if (!count.containsKey(preSum[i])){
                count.put(preSum[i], 1);
            } else {
                count.put(preSum[i], count.get(preSum[i]) + 1);
            }

        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
