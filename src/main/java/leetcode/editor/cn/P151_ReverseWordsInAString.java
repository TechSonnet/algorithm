//给你一个字符串 s ，请你反转字符串中 单词 的顺序。
//
// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
//
// 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
//
// 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
//
//
//
// 示例 1：
//
//
//输入：s = "the sky is blue"
//输出："blue is sky the"
//
//
// 示例 2：
//
//
//输入：s = "  hello world  "
//输出："world hello"
//解释：反转后的字符串中不能存在前导空格和尾随空格。
//
//
// 示例 3：
//
//
//输入：s = "a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 包含英文大小写字母、数字和空格 ' '
// s 中 至少存在一个 单词
//
//
//
//
//
//
//
// 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
//
// Related Topics双指针 | 字符串
//
// 👍 1300, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 反转字符串中的单词
 * @author Chang Liu
 * @date 2025-04-17 10:37:04
 */
public class P151_ReverseWordsInAString{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P151_ReverseWordsInAString().new Solution();
	 }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {

		String res = reverseWords02(s);

		return res;
    }

	/**
	 * API 选手，按照空格分割每个单词，利用栈先进后出的特性拼出结果
	 * @param s
	 * @return
	 */
	public String reverseWords01(String s) {

		// 1. 去处字符串首尾的空格，并按照空格分割字符串为单词数组

		String[] words = s.trim().split("\\s+");

		// 2. 拼接为最终结果

		StringBuffer res = new StringBuffer();

		for (int i = words.length - 1; i >= 0; i--) {
			res.append(words[i]);
			if (i > 0){
				res.append(' ');
			}
		}

		return res.toString();
	}

	public String reverseWords02(String s) {

		// 1. 去处字符串首尾空格
		char[] chars = removeExtraSpaces(s).toCharArray();

		// 2. 翻转整个字符串
		int left = 0, right = chars.length - 1;
		reverseStr(chars, left, right);


		// 3. 翻转字符串中的每个单词
		reverseEachWords(chars);

		return new String(chars);
	}


	public String removeExtraSpaces(String s){

		// 1. trim leading and trailing spaces

		int left = 0, right = s.length() - 1;

		while (left <= right && s.charAt(left) == ' ') left++;
		while (right >= left && s.charAt(right) == ' ') right--;

		// 2. reduce multiple spaces to a single space

		StringBuilder subStr = new StringBuilder();
		while (left <= right){
			char c = s.charAt(left);
            if (c != ' ') {
                subStr.append(c);
            }else if (subStr.length() > 0 && subStr.charAt(subStr.length() - 1) != ' '){
				subStr.append(' ');
			}
			left++;
		}

		return subStr.toString();
	}

	public void reverseStr(char[] chars, int left, int right){

		while (left < right){
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;
			left++;
			right--;
		} 

	}

	public void reverseEachWords(char[] chars){
		int start = 0, end = 0;

		while (start < chars.length){
			while (end < chars.length && chars[end] != ' ') end++;
			reverseStr(chars, start, end - 1);
			start = end + 1;
			end = start;
		}
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
