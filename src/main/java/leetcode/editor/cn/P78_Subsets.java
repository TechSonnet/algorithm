//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 2438, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * @author Chang Liu
 * @date 2025-02-23 16:26:04
 */
public class P78_Subsets{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P78_Subsets().new Solution();

		 int[] nums = {1, 2, 3};
         List<List<Integer>> subsets = solution.subsets(nums);
		 System.out.println(subsets);

	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	// 定义辅助数据结构
	List<List<Integer>> res = new LinkedList<>();
	LinkedList<Integer> track = new LinkedList<>();

	// 主函数，调用回溯算法寻找答案
    public List<List<Integer>> subsets(int[] nums) {

		backtrack(0, nums);

		return res;
    }

	// 回溯算法，借助外部条件找到答案
	// start 为选择， nums 为选择列表
	void backtrack(int start, int[] nums){

		// 每一个节点都是结果，没有结束条件，直接添加到结果集
		res.add(new LinkedList<>(track));

		// 在选择列表中寻找答案
		for (int i = start; i < nums.length; i++) {
			track.addLast(nums[i]);
			backtrack(i + 1, nums);
			track.removeLast();
		}

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
