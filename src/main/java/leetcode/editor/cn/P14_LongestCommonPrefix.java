//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 如果非空，则仅由小写英文字母组成 
// 
//
// Related Topics字典树 | 字符串 
//
// 👍 3324, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

/**
 * 最长公共前缀
 * @author Chang Liu
 * @date 2025-04-25 10:28:13
 */
public class P14_LongestCommonPrefix{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P14_LongestCommonPrefix().new Solution();
		  String[] strs = new String[]{"dog","racecar","car"};
		 String res = solution.longestCommonPrefix(strs);
		 System.out.println(res);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {

		int p1 = 0, p2 = 0;

		StringBuilder res = new StringBuilder();

		int shortest_len = strs[0].length();
		for (String str : strs){
			if (shortest_len > str.length()){
				shortest_len = str.length();
			}
		}


		for (int i = 0; i < shortest_len; i++) {
			char cur = strs[0].charAt(i);
			for (String row : strs){
				if (cur != row.charAt(i)){
					return res.toString();
				}
			}
			res.append(cur);
		}

		return res.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
