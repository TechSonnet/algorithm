//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
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
// Related Topics链表 
//
// 👍 1197, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

/**
 * 删除排序链表中的重复元素
 * @author Chang Liu
 * @date 2025-04-09 10:45:15
 */
public class P83_RemoveDuplicatesFromSortedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P83_RemoveDuplicatesFromSortedList().new Solution();
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
    public ListNode deleteDuplicates(ListNode head) {

		if (head == null){
			return null;
		}

		ListNode fast = head, slow = head;

		while (fast != null){

			if (fast.val == slow.val){
				fast = fast.next;
				slow.next = fast;
			}else {
				fast = fast.next;
				slow = slow.next;
			}
		}

		return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
