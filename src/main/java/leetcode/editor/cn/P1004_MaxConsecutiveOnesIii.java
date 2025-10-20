//给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释：[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 0 <= k <= nums.length 
// 
//
// Related Topics数组 | 二分查找 | 前缀和 | 滑动窗口 
//
// 👍 785, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

/**
 * 最大连续1的个数 III
 * @author Chang Liu
 * @date 2025-06-05 10:10:17
 */
public class P1004_MaxConsecutiveOnesIii{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P1004_MaxConsecutiveOnesIii().new Solution();

		 int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		 int k = 2;
		 System.out.println(solution.longestOnes(nums, k));

	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestOnes(int[] nums, int k) {

		// 初始化变量
		int left = 0, right = 0;
		int oneCount = 0; // 包含 1 的个数
		int max = 0; // 结果

		// 扩大窗口 nums[i] == 1 or k > 0
		while (right < nums.length){

			// 更新 max 和 k
			if (nums[right] == 1){
				oneCount ++;
			}

			right++;

			// 缩小窗口 ？ 这个条件要学习一下
			if (right - left - oneCount > k){
				if (nums[left] == 1){
					oneCount--;
				}
				left++;
			}

			max = Math.max(max, right - left);
		}

		return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
