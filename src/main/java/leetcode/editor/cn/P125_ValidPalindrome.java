//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。 
//
// 字母和数字都属于字母数字字符。 
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
// 
//
// 示例 3： 
//
// 
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s 仅由可打印的 ASCII 字符组成 
// 
//
// Related Topics双指针 | 字符串 
//
// 👍 812, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

/**
 * 验证回文串
 * @author Chang Liu
 * @date 2025-04-22 11:06:42
 */
public class P125_ValidPalindrome{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P125_ValidPalindrome().new Solution();

          String str = "A man, a plan, a canal: Panama";

         System.out.println(solution.isPalindrome(str));
     }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {

		StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)){
                str.append(Character.toLowerCase(c));
            }

        }

        int left = 0, right = str.length() - 1;

        while (left < right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
