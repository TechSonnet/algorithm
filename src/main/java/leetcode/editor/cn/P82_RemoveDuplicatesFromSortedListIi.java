//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 1346, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

/**
 * 删除排序链表中的重复元素 II
 * @author Chang Liu
 * @date 2025-03-27 09:46:31
 */
public class P82_RemoveDuplicatesFromSortedListIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P82_RemoveDuplicatesFromSortedListIi().new Solution();

		 ListNode head = ListNode.createLinkedList(new int[]{1,2,2});
		 ListNode listNode = solution.deleteDuplicates2(head);
		 ListNode.printList(listNode);
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
	// 分解链表解法
    public ListNode deleteDuplicates2(ListNode head) {

		ListNode dummyUniq = new ListNode(101);
		ListNode dummyDup = new ListNode(101);

		ListNode p = head;
		ListNode pUniq = dummyUniq, pDup = dummyDup;

		while (p != null){
			if (p.next != null && p.val == p.next.val || pDup.val == p.val){
				// 重复节点
				pDup.next = p;
				pDup = pDup.next;
			}else {
				// 非重复节点
				pUniq.next = p;
				pUniq = pUniq.next;
			}
			// 跳过所有重复值
			p = p.next;

			// 链表断开，防止循环引用
			pUniq.next = null;
			pDup.next = null;
		}


		return dummyUniq.next;
    }

	// 快慢指针技巧
	public ListNode deleteDuplicates(ListNode head) {

		ListNode dummy = new ListNode(101);
		ListNode fast = head, slow = dummy;

		while (fast != null){

			if (fast.next != null && fast.val == fast.next.val){
				while (fast.next != null && fast.val == fast.next.val){
					fast = fast.next;
				}
				fast = fast.next; // 跳过最后一个重复元素

				// 不加这段代码，部分案例会报错如 {1,2,2}
				// 在这个案例下，最外层循环会直接结束，相当于对链表没有进行操作
				if (fast == null){
					slow.next = null;
				}
			}else {
				// 处理不重复元素的情况
				slow.next = fast;
				slow = slow.next;
				fast = fast.next;
			}

		}

		return dummy.next;
	}

	// 递归解法
	public ListNode deleteDuplicates3(ListNode head) {

		return null;
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}
