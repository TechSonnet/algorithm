//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 说明： 
//
// 为什么返回数值是整数，但输出的答案是数组呢？ 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// 
//// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,2,2,3]
//输出：5, nums = [1,1,2,2,3]
//解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,1,2,3,3]
//输出：7, nums = [0,0,1,1,2,3,3]
//解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素
//。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按升序排列 
// 
//
// Related Topics数组 | 双指针 
//
// 👍 1253, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

/**
 * 删除有序数组中的重复项 II
 * @author Chang Liu
 * @date 2025-04-22 10:02:47
 */
public class P80_RemoveDuplicatesFromSortedArrayIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P80_RemoveDuplicatesFromSortedArrayIi().new Solution();

		  int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
		 System.out.println(solution.removeDuplicates(nums));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int removeDuplicates(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}

		int fast = 0, slow = 0;
		int count = 0; // 统计重复元素的个数

		while (fast < nums.length) {

			/**
			 * 体会这一步，这两个 if，就是需要移动 slow 的两种情况
			 */
			if (nums[slow] != nums[fast]) {
				slow++;
				nums[slow] = nums[fast];
			} else if (slow < fast && count < 2) {
				slow++;
				nums[slow] = nums[fast];
			}

			fast++;
			count++;

			if (fast < nums.length && nums[fast] != nums[fast - 1]) {
				count = 0;
			}

		}

		return slow + 1;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
