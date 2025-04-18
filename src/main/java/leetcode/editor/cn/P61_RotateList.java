//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 1132, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 旋转链表
 * @author Chang Liu
 * @date 2025-04-18 14:26:38
 */
public class P61_RotateList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P61_RotateList().new Solution();
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
    public ListNode rotateRight(ListNode head, int k) {

		if (head == null || head.next == null || k == 0){
			return head;
		}

		int n = 0;
		ListNode p = head;

		while (p != null){
			n++;
			p = p.next;
		}

		k = k % n;

		head = reverseBetween(head, 1, n);
		head = reverseBetween(head, 1, k);
		head = reverseBetween(head, k + 1, n);


		return head;

    }

	private ListNode reverse(ListNode head){

		if (head == null || head.next == null){
			return head;
		}

		ListNode last = reverse(head.next);

		head.next.next = head;
		head.next = null;

		return last;
	}

	ListNode successor = null;

	private ListNode reverseN(ListNode head, int n){

		if (head == null || head.next == null || n <= 0){
			return head;
		}

		if (n == 1){
			successor = head.next;
			return head;
		}

		ListNode last = reverseN(head.next, n - 1);

		head.next.next = head;
		head.next = successor;

		return last;
	}

	private ListNode reverseBetween(ListNode head, int start, int end){

		if (start == 1){
			return reverseN(head, end);
		}

        head.next = reverseBetween(head.next, start - 1, end - 1);
        return head;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
