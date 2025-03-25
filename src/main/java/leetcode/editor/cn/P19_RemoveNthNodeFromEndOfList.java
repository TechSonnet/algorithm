//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics链表 | 双指针 
//
// 👍 3074, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 * @author Chang Liu
 * @date 2025-03-25 09:51:45
 */
public class P19_RemoveNthNodeFromEndOfList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {

		// 修正，定义虚拟头结点，否则无法处理

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		// 1. 定义两个指针，第一个指针先走 k 步
		ListNode p1  = dummy, p2 = dummy;

		for (int i = 0; i <= n; i++) {
			p1 = p1.next;
		}


		// 2. 两个指针同时移动，直到先出发的指针走到末尾

		while (p1 != null){
			p1 = p1.next;
			p2 = p2.next;
		}

		// 3. 删除倒数第 k 个节点
		p2.next = p2.next.next;

		return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
