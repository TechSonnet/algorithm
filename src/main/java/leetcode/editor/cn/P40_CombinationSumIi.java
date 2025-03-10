//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 1658, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 II
 * @author Chang Liu
 * @date 2025-03-07 17:28:02
 */
public class P40_CombinationSumIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P40_CombinationSumIi().new Solution();
         List<List<Integer>> res = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
         System.out.println(res);
     }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

          List<List<Integer>> res = new LinkedList<>();
          LinkedList<Integer> track = new LinkedList<>();

          int trackSum = 0; // 记录 track 元素中的和


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        backtrack(0, candidates, target);

        return res;
    }

    void backtrack(int start, int[] candidates, int target){

        if (trackSum == target){
            res.add(new LinkedList<>(track));
            return;
        }

        if (trackSum > target){
            return;
        }

        for (int i = start; i < candidates.length; i++){

            /**
             *  i > start 的作用在于 确保只在同一层递归中跳过重复数字
             * 当 i == start 时：
             * 表示这是当前层第一个考虑的数字，不需要检查重复，直接使用。
             * 当 i > start 时：
             * 表示已经在同一层处理了前面的数字，如果当前数字和前一个相同，则跳过，避免重复组合。
             */
            if (i > start && candidates[i] == candidates[i-1]){
                continue;
            }

            track.addLast(candidates[i]);
            trackSum += candidates[i];
            backtrack(i+1, candidates, target);
            trackSum -= candidates[i];
            track.removeLast();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
