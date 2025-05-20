//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的 排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics哈希表 | 双指针 | 字符串 | 滑动窗口 
//
// 👍 1055, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 字符串的排列
 * @author Chang Liu
 * @date 2025-05-20 10:22:03
 */
public class P567_PermutationInString{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P567_PermutationInString().new Solution();
		 String s1 = "ab", s2 = "eidboaoo";
		 boolean res = solution.checkInclusion(s1, s2);
		 System.out.println(res);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {

		// 这里需要注意， window 并非是包括所有的字符，而是仅包括有需要的字符
		HashMap<Character, Integer> window = new HashMap<>();
		HashMap<Character, Integer> need = new HashMap<>();

		// need 表一旦赋值完成，就没必要再更改
		for (char c : s1.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}

		int left = 0, right = 0;
		int valid = 0;
		int start = 0, len = Integer.MAX_VALUE;

		while (right < s2.length()){

			char c = s2.charAt(right);
			right++;

			if (need.containsKey(c)){
				window.put(c, window.getOrDefault(c, 0) + 1);
				// 这里的将 Integer -> int，写法更加简洁明了
				if (window.get(c).intValue() == need.get(c).intValue()){
					valid++;
				}
			}

			while (right - left >= s1.length()){

				if (valid == need.size()){
					return true;
				}

				// 这一段代码的意义在哪里？
				// 保持当前窗口的长度为 s1.length()，确保比较的是一个长度和 s1 一样的子串
				char d = s2.charAt(left);
				left++;
				if (need.containsKey(d)){
					if (window.get(d).intValue() == need.get(d).intValue()){
						valid--;
					}
					window.put(d, window.get(d) - 1);
				}

			}

		}
		return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
