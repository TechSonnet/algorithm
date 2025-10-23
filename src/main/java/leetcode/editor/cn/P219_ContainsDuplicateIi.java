//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i 
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
//
// Related Topics数组 | 哈希表 | 滑动窗口 
//
// 👍 822, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 存在重复元素 II
 * @author Chang Liu
 * @date 2025-10-21 13:26:22
 */
public class P219_ContainsDuplicateIi{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P219_ContainsDuplicateIi().new Solution();

		 int[] nums = new int[]{1,2,3,1};
		 int k = 3;
		 System.out.println(solution.containsNearbyDuplicate(nums, k));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

		int left = 0, right = 0;
		HashSet<Integer> window = new HashSet<>(); // 窗口类型的选择，十分灵活，看需要什么样的窗口，选择合适的数据结构

		while (right < nums.length){


			if (window.contains(nums[right])){
				return true;
			}
			// 扩大窗口 right < nums.length
			window.add(nums[right]);
            right++;

			while (right - left > k){
				window.remove(nums[left]);
				left++;
			}

		}

		// 缩小窗口 right - left > k

		return false;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
