//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics递归 | 链表 
//
// 👍 3724, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

/**
 * 合并两个有序链表
 * @author Chang Liu
 * @date 2025-03-20 14:35:38
 */
public class P21_MergeTwoSortedLists{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P21_MergeTwoSortedLists().new Solution();

		 // 测试用例 1: 正常情况
		 ListNode l1 = new ListNode(1);
		 l1.next = new ListNode(2);
		 l1.next.next = new ListNode(4);

		 ListNode l2 = new ListNode(1);
		 l2.next = new ListNode(3);
		 l2.next.next = new ListNode(4);

		 System.out.println("Test Case 1:");
		 ListNode result1 = solution.mergeTwoLists(l1, l2);
		 printList(result1);  // 预期输出: 1->1->2->3->4->4

		 // 测试用例 2: 一个空链表
		 ListNode l3 = new ListNode(1);
		 l3.next = new ListNode(2);
		 ListNode l4 = null;

		 System.out.println("\nTest Case 2:");
		 ListNode result2 = solution.mergeTwoLists(l3, l4);
		 printList(result2);  // 预期输出: 1->2

		 // 测试用例 3: 两个空链表
		 ListNode l5 = null;
		 ListNode l6 = null;

		 System.out.println("\nTest Case 3:");
		 ListNode result3 = solution.mergeTwoLists(l5, l6);
		 printList(result3);  // 预期输出: (空)
	 }

	// 辅助方法：打印链表
	private static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val);
			if (current.next != null) {
				System.out.print("->");
			}
			current = current.next;
		}
		System.out.println();
	}



//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
class Solution {

	// 不必重新构造一条链表作为基础，直接选择一条链表作为基础不就可以了
	// 但是，这样的缺点在于，链表的切换会很麻烦
	// 因此，能使用 dummy 还是要用，有点类似于空间换时间的感觉

	// 实际上，虚拟头结点 dummy 可以视为一个技巧

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		ListNode p1 = list1, p2 = list2;

		while (p1 != null && p2 != null){
			if (p1.val <= p2.val){
				p.next = p1;
				// p = p.next;
				p1 = p1.next;
			}else {
				p.next = p2;
				// p = p.next;
				p2 = p2.next;
			}
			p= p.next; // 这一句可以提出来，简化代码
		}

		if (p1 != null){
			p.next = p1;
		}

		if (p2 != null){
			p.next = p2;
		}

		return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
