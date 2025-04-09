//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics链表 
//
// 👍 1950, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

import java.util.List;

/**
 * 反转链表 II
 * @author Chang Liu
 * @date 2025-04-07 15:25:50
 */
public class P92_ReverseLinkedListIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P92_ReverseLinkedListIi().new Solution();
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

	/**
	 * 一般来说，线性结构递推更简单，树形结构递归更简单，这是很有意思的
	 * 这里的简单，等价于更好理解
	 */
	class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

		if (left == 1){
			return reverseN01(head, right);
		}

		ListNode pre = head;

		for (int i = 1; i < left - 1; i++) {
			pre = pre.next;
		}

		pre.next = reverseN02(pre.next, right - left + 1);

		return head;
    }

	public ListNode reverseN01(ListNode head, int n){

		if (head == null || head.next == null){
			return head;
		}

		ListNode pre = null;
		ListNode cur = head;
		ListNode nxt = head.next;

		while (n > 0){
			cur.next = pre;
			pre = cur;
			cur = nxt;
			if (nxt != null){
				nxt = nxt.next;
			}
			n--;
		}

		head.next = cur;

		return pre;

	}

	ListNode successor = null;
	public ListNode reverseN02(ListNode head, int n){

		if (n == 1){
			successor = head.next;
			return head;
		}

		ListNode last = reverseN02(head.next, n-1);
		head.next.next = head;
		head.next = successor;

		return last;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
