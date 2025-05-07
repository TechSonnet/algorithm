//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 输入 保证 数组 answer[i] 在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。） 
//
// Related Topics数组 | 前缀和 
//
// 👍 2029, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 * @author Chang Liu
 * @date 2025-05-07 10:22:25
 */
public class P238_ProductOfArrayExceptSelf{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P238_ProductOfArrayExceptSelf().new Solution();
         int[] nums = new int[]{1,2,3,4};
         int[] res = solution.productExceptSelf(nums);
         System.out.println(Arrays.toString(res));
     }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;

        // 1. 计算前缀积数组

        int[] prefix = new int[len];
        prefix[0] = nums[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i-1] * nums[i];
        }

        // 2. 计算后缀积数组

        int[] suffix = new int[len];
        suffix[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        // 3. 计算答案数组

        int[] answer = new int[len];
        answer[0] = suffix[1];
        answer[len - 1] = prefix[len - 2];
        for (int i = 1; i < len - 1; i++) {
            answer[i] = prefix[i - 1] * suffix[i + 1];
        }

        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
