//给你单链表的头结点 head ，请你找出并返回链表的中间结点。 
//
// 如果有两个中间结点，则返回第二个中间结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[3,4,5]
//解释：链表只有一个中间结点，值为 3 。
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2,3,4,5,6]
//输出：[4,5,6]
//解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
// 
//
// 
//
// 提示： 
//
// 
// 链表的结点数范围是 [1, 100] 
// 1 <= Node.val <= 100 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 1052, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

/**
 * 链表的中间结点
 * @author Chang Liu
 * @date 2025-03-25 10:14:26
 */
public class P876_MiddleOfTheLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P876_MiddleOfTheLinkedList().new Solution();
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
    public ListNode middleNode(ListNode head) {

		// 此处不能加虚拟头结点，否则会改变链表奇偶性。
		// 在偶数个节点时，返回偏左的节点。不过，如果是要求偶数个节点时，返回偏左的节点，反而可以这样做。

		ListNode p1 = head, p2 = head;

		while (p2 != null && p2.next != null){
			p1 = p1.next;
			p2 = p2.next.next;
		}

		return p1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
