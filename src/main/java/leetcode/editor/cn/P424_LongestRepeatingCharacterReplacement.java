//给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。 
//
// 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
//可能存在其他的方法来得到同样的结果。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 仅由大写英文字母组成 
// 0 <= k <= s.length 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 935, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

/**
 * 替换后的最长重复字符
 * @author Chang Liu
 * @date 2025-10-20 21:10:46
 */
public class P424_LongestRepeatingCharacterReplacement{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P424_LongestRepeatingCharacterReplacement().new Solution();

		 // case one
		 String s = "ABAB";
		 int k = 2;
		 System.out.println(solution.characterReplacement(s, k));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int characterReplacement(String s, int k) {

		int left = 0, right = 0;
		int max = 0;
		int[] windows = new int[28];
		int winCharCount = 0;

        // 扩大窗口
		while (right < s.length()){

			int c = s.charAt(right) - 'A';
			windows[c]++;
			winCharCount = Math.max(winCharCount, windows[c]); // 仔细思考这里的更新
			right++;

			// 缩小窗口
			while (right - left - winCharCount > k){
				windows[s.charAt(left) - 'A']--;
				left++;
			}

			// 记录结果
			max = Math.max(max, right - left);
		}

		return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
