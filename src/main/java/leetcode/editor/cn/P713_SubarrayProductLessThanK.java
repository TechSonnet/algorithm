//给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,5,2,6], k = 100
//输出：8
//解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2]、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 0
//输出：0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
//
// Related Topics数组 | 二分查找 | 前缀和 | 滑动窗口 
//
// 👍 863, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

/**
 * 乘积小于 K 的子数组
 * @author Chang Liu
 * @date 2025-06-04 15:14:06
 */
public class P713_SubarrayProductLessThanK{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P713_SubarrayProductLessThanK().new Solution();
		 int[] nums = {10,5,2,6};
		 System.out.println(solution.numSubarrayProductLessThanK(nums, 100));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

		int n = nums.length;
		int left = 0, right = 0;
		int product = 1, count = 0;

		while (right < nums.length){

			product *= nums[right++];


			while (product >= k && left < right){

				product /= nums[left++];

			}

			count += right - left;

		}

		return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
