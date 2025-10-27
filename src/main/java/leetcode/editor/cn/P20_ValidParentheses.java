//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "()" 
// 
//
// 输出：true 
//
// 示例 2： 
//
// 
// 输入：s = "()[]{}" 
// 
//
// 输出：true 
//
// 示例 3： 
//
// 
// 输入：s = "(]" 
// 
//
// 输出：false 
//
// 示例 4： 
//
// 
// 输入：s = "([])" 
// 
//
// 输出：true 
//
// 示例 5： 
//
// 
// 输入：s = "([)]" 
// 
//
// 输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics栈 | 字符串 
//
// 👍 4823, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 有效的括号
 * @author Chang Liu
 * @date 2025-10-23 19:21:48
 */
public class P20_ValidParentheses{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P20_ValidParentheses().new Solution();

		 String s = "()";
		 System.out.println(solution.isValid(s));

		 String s1 = "()[]{}";
		 System.out.println(solution.isValid(s1));

	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {

		ArrayList<Character> characters = new ArrayList<>();
		characters.add('(');
		characters.add('[');
		characters.add('{');

		ArrayDeque<Character> stack = new ArrayDeque<>();

		for (char c : s.toCharArray()) {
			if (characters.contains(c)){
				stack.push(c);
			} else {
				if (!getChar(c).equals(stack.poll())){
					return false;
				}
			}
		}

		return stack.isEmpty();
    }

	private Character getChar(char c){
		if (c == ')'){
			return '(';
		}
		if (c == ']'){
			return '[';
		}
		if (c == '}'){
			return '{';
		}
		return null;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
