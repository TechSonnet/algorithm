//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics贪心 | 数组 | 动态规划 
//
// 👍 3018, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

/**
 * 跳跃游戏
 * @author Chang Liu
 * @date 2025-03-13 18:08:44
 */
public class P55_JumpGame{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P55_JumpGame().new Solution();
         boolean res = solution.canJump(new int[]{3,2,1,0,4});
         System.out.println(res);
     }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 使用贪心策略

    public boolean canJump(int[] nums) {

        int n = nums.length;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            // 遇到了 0，卡住了
            if (farthest <= i){
                return false;
            }

        }

        return farthest >= n - 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
//class Solution {
//
//    // 使用动态规划思路
//
//    public boolean canJump(int[] nums) {
//
//        boolean isReached = dp(nums, 0);
//
//        return isReached;
//    }
//
//    boolean dp(int[] nums, int location){
//
//        if (location == nums.length - 1){
//            return true;
//        }
//
//        for (int i = 1; i < nums[location]+1; i++) {
//
//            boolean subProblem = dp(nums, location + i);
//
//            if (subProblem){
//                return true;
//            }
//
//        }
//
//        return false;
//    }
//}

}
