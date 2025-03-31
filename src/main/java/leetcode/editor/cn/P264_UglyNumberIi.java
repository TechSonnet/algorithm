//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是质因子只包含 2、3 和 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
//
// Related Topics哈希表 | 数学 | 动态规划 | 堆（优先队列） 
//
// 👍 1252, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

/**
 * 丑数 II
 * @author Chang Liu
 * @date 2025-03-28 09:32:53
 */
public class P264_UglyNumberIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P264_UglyNumberIi().new Solution();

         int res = solution.nthUglyNumber(10);
         System.out.println(res);
     }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {

        int p1 = 1, p2 = 1, p3 = 1;
        int product1 = 1, product2 = 1, product3 = 1;

        int p = 1;
        int[] ugly = new int[n+1];

        while (p <= n){

            int min = Math.min(Math.min(product1, product2), product3);
            ugly[p++] = min;

            /**
             * 注意这里，一个数组当四个链表去用，是我万万没有想到的
             */
            if (min == product1){
                product1 = 2 * ugly[p1++];
            }

            if (min == product2){
                product2 = 3 * ugly[p2++];
            }

            if (min == product3){
                product3 = 5 * ugly[p3++];
            }

        }

        return ugly[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
