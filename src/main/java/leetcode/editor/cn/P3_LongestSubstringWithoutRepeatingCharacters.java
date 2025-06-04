//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 10845, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 * @author Chang Liu
 * @date 2025-05-26 21:08:55
 */
public class P3_LongestSubstringWithoutRepeatingCharacters{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
		 String s = "bbbbb";
		 System.out.println(solution.lengthOfLongestSubstring(s));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {

		int left = 0, right = 0;
		int len = s.length();
		int res = 0;
		HashMap<Character, Integer> window = new HashMap<>();

		while (right < len){

			char c = s.charAt(right);
			right++;
			window.put(c, window.getOrDefault(c, 0) + 1);

			while (window.get(c) > 1){
				char d = s.charAt(left);
				left++;
				window.put(d, window.get(d) - 1);
			}

			res = (right - left > res ? right - left : res);

		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
