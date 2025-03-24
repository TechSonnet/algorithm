//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 896, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

import static leetcode.editor.cn.structure.ListNode.createLinkedList;

/**
 * 分隔链表
 * @author Chang Liu
 * @date 2025-03-24 14:13:51
 */
public class P86_PartitionList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P86_PartitionList().new Solution();

		 // 测试用例 1: 正常情况
		 ListNode head1 = createLinkedList(new int[]{1, 4, 3, 2, 5, 2});
		 int x1 = 3;
		 System.out.println("Test Case 1:");
		 ListNode result1 = solution.partition(head1, x1);
		 ListNode.printList(result1);  // 预期输出: 1->2->2->4->3->5

		 // 测试用例 2: 全部小于 x
		 ListNode head2 = createLinkedList(new int[]{1, 2, 2});
		 int x2 = 3;
		 System.out.println("\nTest Case 2:");
		 ListNode result2 = solution.partition(head2, x2);
		 ListNode.printList(result2);  // 预期输出: 1->2->2
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
    public ListNode partition(ListNode head, int x) {

		ListNode dummy1 = new ListNode(-1);
		ListNode dummy2 = new ListNode(-1);
		ListNode p1 = dummy1, p2 = dummy2, p = head;

		while (p != null){
			if (p.val < x){
				p1.next = p;
				p1 = p1.next;
			}else {
				p2.next = p;
				p2 = p2.next;
			}
			p = p.next;
		}

		// 避免出现环
		p2.next = null;

		p1.next = dummy2.next;

		return dummy1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
