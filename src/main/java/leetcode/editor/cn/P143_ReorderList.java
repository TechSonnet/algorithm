//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 1639, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

import java.util.ArrayDeque;

/**
 * 重排链表
 * @author Chang Liu
 * @date 2025-10-23 13:58:43
 */
public class P143_ReorderList{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P143_ReorderList().new Solution();
		 ListNode n1 = new ListNode(1);
		 ListNode n2 = new ListNode(2);
		 ListNode n3 = new ListNode(3);
		 ListNode n4 = new ListNode(4);
		 n1.next = n2;
		 n2.next = n3;
		 n3.next = n4;
		 solution.reorderList(n1);
		 while (n1 != null){
			 System.out.println(n1.val);
			 n1 = n1.next;
		 }
	 }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
//leetcode submit region end(Prohibit modification and deletion)
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
		public void reorderList(ListNode head) {

			ListNode p = head;
			ArrayDeque<ListNode> stack = new ArrayDeque<>();
			while (p != null){
				stack.push(p);
				p = p.next;
			}

			// 合并
			p = head;
			while (p != null){
				ListNode lastNode = stack.poll();
				ListNode next = p.next;
				// 这个结束条件，一定要想明白
				if (lastNode == next || lastNode.next == next){
					lastNode.next = null;
					break;
				}
				p.next = lastNode;
				lastNode.next = next;
				p = next;
			}


		}
	}

}
