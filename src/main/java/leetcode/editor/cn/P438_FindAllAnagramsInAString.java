//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 1678, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * @author Chang Liu
 * @date 2025-05-20 11:34:38
 */
public class P438_FindAllAnagramsInAString{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P438_FindAllAnagramsInAString().new Solution();
		 String s = "abab", p = "ab";
		 List<Integer> res = solution.findAnagrams(s, p);
		 System.out.println(res);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

		HashMap<Character, Integer> window = new HashMap<Character, Integer>();
		HashMap<Character, Integer> need = new HashMap<Character, Integer>();
		ArrayList<Integer> res = new ArrayList<>();

		for (char c : p.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}

		int left = 0, right = 0;
		int valid = 0;
		int start = 0, len = 0;


		while (right < s.length()){

			char c = s.charAt(right);
			right++;
			if (need.containsKey(c)){
				window.put(c, window.getOrDefault(c, 0) + 1);
				if (window.get(c).intValue() == need.get(c).intValue()){
					valid++;
				}
			}

			// 这里是很妙的一招，保证了窗口大小 (right - left) 永远不会超过 p.length()
			// 因为长度一但超过 p.length()，窗口会立即收缩，这和 p76 的条件 valid == need.size() 有着很大的区别
			// 一开始，就没想明白如何保证异位词的长度是符合要求的，而不是找到符合要求的包含异位词的子串
			// 而这里的逻辑在于，一旦窗口等于 p.length()，窗口会立即收缩，而后无论是否符合异位此要求，都要缩小窗口
			while (right - left >= p.length()){

				if (valid == need.size()){
					res.add(left);
				}

				char d = s.charAt(left);
				left++;
				if (need.containsKey(d)){
					if (window.get(d).intValue() == need.get(d).intValue()){
						valid--;
					}
					window.put(d, window.get(d) - 1);
				}


			}

		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
