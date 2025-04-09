//给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 
//一致 。然后返回 nums 中唯一元素的个数。 
//
// 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过： 
//
// 
// 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不
//重要。 
// 返回 k 。 
// 
//
// 判题标准: 
//
// 系统会用下面的代码来测试你的题解: 
//
// 
//int[] nums = [...]; // 输入数组
//int[] expectedNums = [...]; // 长度正确的期望答案
//
//int k = removeDuplicates(nums); // 调用
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//} 
//
// 如果所有断言都通过，那么您的题解将被 通过。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：2, nums = [1,2,_]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非严格递增 排列 
// 
//
// Related Topics数组 | 双指针 
//
// 👍 3764, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

/**
 * 删除有序数组中的重复项
 * @author Chang Liu
 * @date 2025-04-09 10:08:59
 */
public class P26_RemoveDuplicatesFromSortedArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P26_RemoveDuplicatesFromSortedArray().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	/**
	 * 数组的双指针非常有意思，fast 指针可以不断地前进探索，找到对应的元素结合 slow 指针
	 * 做一些操作，比如赋值给 slow 指针所在的元素
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {

		int fast = 0, slow = 0;

		while (fast < nums.length){

			if (nums[slow] == nums[fast]){
				fast++;
			}else {
				nums[++slow] = nums[fast];
			}
		}

		return slow + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
