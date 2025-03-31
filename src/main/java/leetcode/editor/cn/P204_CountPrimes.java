//给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
//
// Related Topics数组 | 数学 | 枚举 | 数论 
//
// 👍 1211, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 计数质数
 * @author Chang Liu
 * @date 2025-03-28 09:35:16
 */
public class P204_CountPrimes{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P204_CountPrimes().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {

		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);

		for (int i = 2; i * i < n; i++){
			if (isPrime[i]){
				for (int j = i * i; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i]){
				count++;
			}
		}

		return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
