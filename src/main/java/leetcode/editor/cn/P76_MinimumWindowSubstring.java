//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 3250, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 最小覆盖子串
 * @author Chang Liu
 * @date 2025-05-19 10:11:18
 */
public class P76_MinimumWindowSubstring{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P76_MinimumWindowSubstring().new Solution();

		 String s = "ADOBECODEBANC", t = "ABC";
		 String res = solution.minWindow(s, t);
		 System.out.println(res);


	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {

		HashMap<Character, Integer> window = new HashMap<>();
		HashMap<Character, Integer> need = new HashMap<>();

		for (char c : t.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}

		int left = 0, right = 0;
		int valid = 0;
		int start = 0, len = Integer.MAX_VALUE;

		while (right < s.length()){

			// 扩大窗口

			char c = s.charAt(right);
			right++;

			if (need.containsKey(c)){
				window.put(c, window.getOrDefault(c, 0) + 1);
				if (window.get(c).equals(need.get(c))){
					valid++;
				}
			}

			// 缩小窗口

			// 这里也很妙，valid 和 need.size() 是否相等，看似屏蔽了相同字符出现的频率，其实从一开始就考虑到了这个问题
			// 只有频率对了（即出现的次数对了）， valid 才会 ++ 或者 --
 			while (valid == need.size()){


				if (right - left < len){
					start = left;
					len = right - left;
				}


				char d = s.charAt(left);
				left++;

				if (need.containsKey(d)){
					if (window.get(d).equals(need.get(d))){
						valid--;
					}
					window.put(d, window.get(d) - 1);
				}


			}

		}


		// 这个 left + len 很好，可以避免考虑 right 的问题，该怎么计算，是否需要 +- 1
		return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
