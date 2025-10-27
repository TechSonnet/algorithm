//给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。 
//
// 请你计算该表达式。返回一个表示表达式值的整数。 
//
// 注意： 
//
// 
// 有效的算符为 '+'、'-'、'*' 和 '/' 。 
// 每个操作数（运算对象）都可以是一个整数或者另一个表达式。 
// 两个整数之间的除法总是 向零截断 。 
// 表达式中不含除零运算。 
// 输入是一个根据逆波兰表示法表示的算术表达式。 
// 答案及所有中间计算结果可以用 32 位 整数表示。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：tokens = ["2","1","+","3","*"]
//输出：9
//解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
// 
//
// 示例 2： 
//
// 
//输入：tokens = ["4","13","5","/","+"]
//输出：6
//解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
// 
//
// 示例 3： 
//
// 
//输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//输出：22
//解释：该算式转化为常见的中缀算术表达式为：
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22 
//
// 
//
// 提示： 
//
// 
// 1 <= tokens.length <= 10⁴ 
// tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数 
// 
//
// 
//
// 逆波兰表达式： 
//
// 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。 
//
// 
// 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。 
// 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。 
// 
//
// 逆波兰表达式主要有以下两个优点： 
//
// 
// 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。 
// 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中 
// 
//
// Related Topics栈 | 数组 | 数学 
//
// 👍 1040, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 逆波兰表达式求值
 * @author Chang Liu
 * @date 2025-10-24 13:08:38
 */
public class P150_EvaluateReversePolishNotation{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P150_EvaluateReversePolishNotation().new Solution();
		 String[] tokens = {"2","1","+","3","*"};
		 System.out.println(solution.evalRPN(tokens));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {


		ArrayList<String> operators = new ArrayList<>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");


		ArrayDeque<String> stack = new ArrayDeque<>();

		for (String token : tokens) {

			if (operators.contains(token)){
				String n2 = stack.pop();
				String n1 = stack.pop();
				int temp = compute(n1, n2, token);
				stack.push(String.valueOf(temp));
			}else {
				stack.push(token);
			}



		}

		return Integer.parseInt(stack.peek());
	}

	private int compute(String n1, String n2, String token){
		Integer num1 = Integer.valueOf(n1);
		Integer num2 = Integer.valueOf(n2);

		if (token.equals("*")){
			return num1 * num2;
		}

		if (token.equals("/")){
			return num1 / num2;
		}

		if (token.equals("-")){
			return num1 - num2;
		}

		if (token.equals("+")){
			return num1 + num2;
		}

		return -1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
