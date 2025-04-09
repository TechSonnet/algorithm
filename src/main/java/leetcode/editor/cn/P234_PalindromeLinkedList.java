//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 2048, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

import java.util.List;

/**
 * 回文链表
 * @author Chang Liu
 * @date 2025-04-08 10:25:35
 */
public class P234_PalindromeLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P234_PalindromeLinkedList().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {

        return false;
    }

	/**
	 * 前置，寻找回文字符串
	 * 寻找时，左右指针从中间向外边找
	 */
	public String searchPalindrome (String str, int left, int right){

		if (str == null){
			return null;
		}

		while (left >= 0 && right < str.length()
				&& str.charAt(left) == str.charAt(right)){

				left--;
				right++;
		}

		return str.substring(left + 1, right);
	}

	/**
	 * 前置，判断回文字符串
	 * 判断时，从两边往里找
	 */

	public boolean isPalindrome (String s){
		int left = 0;
		int right = s.length()-1;

		while (left < right ){
			if (s.charAt(left) == s.charAt(right)){
				left++;
				right--;
			}else {
				return false;
			}
		}

		return true;
	}

	/**
	 * 方法一：递归法判断
	 */

	ListNode left = null;
	ListNode right = null;
	boolean res = true;

	public boolean isPalindrome01(ListNode head){
		left = head;
		traverse(head);
		return res;
	}

	public void traverse(ListNode right){
		if (right == null){
			return;
		}

		traverse(right.next);

		if (left.val != right.val){
			res = false;
		}

		left = left.next;

	}

	/**
	 * 方法二：优化存储空间，从中间原地翻转链表
	 */


	public boolean isPalindrome02(ListNode head){

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}

		/**
		 * 如果 fast 不为空，则说明链表节点个数为奇数个，slow 指针需要再次前进
		 */
		if (fast != null){
			slow = slow.next;
		}

		ListNode left = head;
		ListNode right = recurrentReverse02(slow);

		while (right != null){
			if (left.val != right.val){
				return false;
			}
			left = left.next;
			right = right.next;
		}

		return true;

	}

	public ListNode recursiveReverse(ListNode head){

		if (head == null || head.next == null){
			return head;
		}

		ListNode last = recursiveReverse(head.next);

		head.next.next = head;
		head.next = null;

		return last;
	}

	/**
	 * 这个写法不太标准，可以参考以下写法递推翻转链表
	 * @param head
	 * @return
	 */
	public ListNode recurrentReverse(ListNode head){

		if (head == null || head.next == null){
			return head;
		}

		ListNode pre = null;
		ListNode cur = head;
		ListNode nxt = head.next;

		while (cur != null){
			cur.next = pre;
			pre = cur;
			cur = nxt;
			if (nxt != null){
				nxt = nxt.next;
			}
		}

		return pre;
	}

	/**
	 * 这个写法，是最标准和简洁的链表翻转写法
	 * @param head
	 * @return
	 */

	public ListNode recurrentReverse02(ListNode head){

		ListNode pre = null;
		ListNode cur = head;

		while (cur != null){
			ListNode nxt = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nxt;
		}

		return pre;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
