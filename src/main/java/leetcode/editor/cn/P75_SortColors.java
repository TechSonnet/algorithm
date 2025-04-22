//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 1909, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 颜色分类
 * @author Chang Liu
 * @date 2025-04-22 11:38:51
 */
public class P75_SortColors{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P75_SortColors().new Solution();

		  int[] nums = {2,0,1};
		  solution.sortColors(nums);

		 System.out.println(Arrays.toString(nums));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {


		int p0 = 0, p1 = 0, p2 = nums.length - 1;

		while (p1 <= p2){ // 是不是需要用等号，需要非常小心的斟酌

			if (nums[p1] == 0){
				swap(nums, p0, p1);
				p0++;
			} else if (nums[p1] == 2) {
				swap(nums, p1, p2);
				p2--;
			} else if (nums[p1] == 1){
				p1++;
			}

			/**
			 * 必须要有此步骤来调整 p1 指针的位置
			 */
			if (p1 < p0){
				p1 = p0;
			}

		}

    }

	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
