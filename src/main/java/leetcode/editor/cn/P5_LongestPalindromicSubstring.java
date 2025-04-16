//给你一个字符串 s，找到 s 中最长的 回文 子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics双指针 | 字符串 | 动态规划 
//
// 👍 7654, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

/**
 * 最长回文子串
 * @author Chang Liu
 * @date 2025-04-16 10:27:34
 */
public class P5_LongestPalindromicSubstring{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P5_LongestPalindromicSubstring().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

		 String res = "";
    public String longestPalindrome(String s) {

		for (int i = 0; i < s.length(); i++){

			String s1 = searchPalindrome(s, i, i);
			String s2 = searchPalindrome(s, i, i + 1);

			res = res.length() > s1.length() ? res : s1;
			res = res.length() > s2.length() ? res : s2;
		}

		return res;
    }

	public String searchPalindrome(String s, int left, int right){

		while (left >= 0 && right < s.length()
			&& s.charAt(left) == s.charAt(right)){

			left--;
			right++;

		}

		return s.substring(left + 1, right);
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
