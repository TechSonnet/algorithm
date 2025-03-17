//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 1298, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集 II
 * @author Chang Liu
 * @date 2025-03-06 15:21:45
 */
public class P90_SubsetsIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P90_SubsetsIi().new Solution();
         List<List<Integer>> res = solution.subsetsWithDup(new int[]{1, 2, 2});
         System.out.println(res);

     }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

// 这道题目，要仔细体会是怎么进行剪枝的
class Solution {

         List<List<Integer>> res = new LinkedList<>();
         LinkedList<Integer> track = new LinkedList<>();


    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        backtrack(0, nums);

        return res;
    }

    void backtrack(int start, int[] nums){
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i-1]){
                continue;
            }

            track.addLast(nums[i]);
            backtrack(i+1, nums);
            track.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
