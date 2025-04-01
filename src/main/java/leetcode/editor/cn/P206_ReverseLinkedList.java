//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics递归 | 链表 
//
// 👍 3845, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

import java.util.List;

/**
 * 反转链表
 * @author Chang Liu
 * @date 2025-04-01 11:30:38
 */
public class P206_ReverseLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P206_ReverseLinkedList().new Solution();

		 ListNode head = ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5});
		 ListNode res = solution.reverse01(head);
		 ListNode.printList(res);
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
    public ListNode reverseList(ListNode head) {

		ListNode res = reverse02(head);

		return res;
    }

	/**
	 * 递归解法
	 * @param head
	 * @return
	 */
	public ListNode reverse01(ListNode head){

		if (head == null || head.next == null){
			return head;
		}

		ListNode last = reverse01(head.next);
		head.next.next = head;
		head.next = null;
		return last;
	}

	/**
	 * 迭代解法
	 */
	public ListNode reverse02(ListNode head){

		if (head == null || head.next == null){
			return head;
		}

		ListNode pre, cur, nxt;
		pre = null;
		cur = head;
		nxt = head.next;

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
}
//leetcode submit region end(Prohibit modification and deletion)

}
