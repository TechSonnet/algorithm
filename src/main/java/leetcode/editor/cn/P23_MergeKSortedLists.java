//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics链表 | 分治 | 堆（优先队列） | 归并排序 
//
// 👍 2983, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

import java.util.PriorityQueue;

import static leetcode.editor.cn.structure.ListNode.createLinkedList;

/**
 * 合并 K 个升序链表
 * @author Chang Liu
 * @date 2025-03-24 14:38:18
 */
public class P23_MergeKSortedLists{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P23_MergeKSortedLists().new Solution();

		 // 测试用例 1: 正常情况
		 ListNode[] lists1 = {
				 createLinkedList(new int[]{1, 4, 5}),
				 createLinkedList(new int[]{1, 3, 4}),
				 createLinkedList(new int[]{2, 6})
		 };
		 System.out.println("Test Case 1:");
		 ListNode result1 = solution.mergeKLists(lists1);
		 ListNode.printList(result1); // 预期输出: 1->1->2->3->4->4->5->6

		 // 测试用例 2: 部分链表为空
		 ListNode[] lists2 = {
				 createLinkedList(new int[]{1, 2, 3}),
				 null,
				 createLinkedList(new int[]{4, 5, 6})
		 };
		 System.out.println("\nTest Case 2:");
		 ListNode result2 = solution.mergeKLists(lists2);
		 ListNode.printList(result2); // 预期输出: 1->2->3->4->5->6

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
    public ListNode mergeKLists(ListNode[] lists) {

		/**
		 * 此道题目使用了优先队列，这是一个从未想到过得点。我总是习惯了借助一些非常常用的
		 * 数据结构，很少思考能否利用一些高级数据结构来解决自己的问题。
		 */

		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;

		if (lists.length == 0){
			return null;
		}

		PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a,b)->(a.val - b.val));

		for (ListNode head : lists) {
			if (head != null){
				pq.add(head);
			}
		}

		while (!pq.isEmpty()){
			ListNode node = pq.poll();
			p.next = node;
			if (node.next != null){
				pq.add(node.next);
			}
			p = p.next;
		}

		return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
