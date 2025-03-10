//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics回溯 
//
// 👍 1728, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * @author Chang Liu
 * @date 2025-02-23 17:44:58
 */
public class P77_Combinations{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P77_Combinations().new Solution();
		 int n = 3;
		 List<List<Integer>> combine = solution.combine(3,2);
		 System.out.println(combine);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	// 定义合适的数据结构，记录结果
	List<List<Integer>> res = new LinkedList<>();
	LinkedList<Integer> track = new LinkedList<>();

	// 主函数，调用回溯函数求结果
	public List<List<Integer>> combine(int n, int k) {

		backtrack(1,n,k);

		return res;
    }

	// 回溯函数，利用回溯法寻找答案
	void backtrack(int start, int n, int k){

		// 这里是添加结果的地方，不同的地方在于限制条件不同
		if(track.size() == k){
			res.add(new LinkedList<>(track));
		}

		// 开始执行回溯，寻找答案
		for (int i = start; i <= n; i++) {
			track.addLast(i);
			backtrack(i+1, n, k);
			track.removeLast();
		}

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
