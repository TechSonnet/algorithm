//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。 
//
// 图示两个链表在节点 c1 开始相交： 
//
// 
//
// 题目数据 保证 整个链式结构中不存在环。 
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。 
//
// 自定义评测： 
//
// 评测系统 的输入如下（你设计的程序 不适用 此输入）： 
//
// 
// intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0 
// listA - 第一个链表 
// listB - 第二个链表 
// skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数 
// skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数 
// 
//
// 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视
//作正确答案 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, 
//skipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//— 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。换句话说，它们在内
//存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 
//输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：No intersection
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
// 
//
// 
//
// 提示： 
//
// 
// listA 中节点数目为 m 
// listB 中节点数目为 n 
// 1 <= m, n <= 3 * 10⁴ 
// 1 <= Node.val <= 10⁵ 
// 0 <= skipA <= m 
// 0 <= skipB <= n 
// 如果 listA 和 listB 没有交点，intersectVal 为 0 
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB] 
// 
//
// 
//
// 进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？ 
//
// Related Topics哈希表 | 链表 | 双指针 
//
// 👍 2638, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

/**
 * 相交链表
 * @author Chang Liu
 * @date 2025-03-27 09:27:52
 */
public class P160_IntersectionOfTwoLinkedLists{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P160_IntersectionOfTwoLinkedLists().new Solution();

		 // 测试用例 1: 两个链表相交
		 ListNode common = new ListNode(3);
		 common.next = new ListNode(4);
		 common.next.next = new ListNode(5);

		 ListNode headA = new ListNode(1);
		 headA.next = new ListNode(2);
		 headA.next.next = common; // 1 -> 2 -> 3 -> 4 -> 5

		 ListNode headB = new ListNode(6);
		 headB.next = common; // 6 -> 3 -> 4 -> 5

		 ListNode result1 = solution.getIntersectionNode(headA, headB);
		 System.out.println("测试 1 相交节点：" + (result1 != null ? result1.val : "null"));

		 // 测试用例 2: 两个链表不相交
		 ListNode headC = new ListNode(7);
		 headC.next = new ListNode(8);
		 headC.next.next = new ListNode(9); // 7 -> 8 -> 9

		 ListNode headD = new ListNode(10);
		 headD.next = new ListNode(11);
		 headD.next.next = new ListNode(12); // 10 -> 11 -> 12

		 ListNode result2 = solution.getIntersectionNode(headC, headD);
		 System.out.println("测试 2 相交节点：" + (result2 != null ? result2.val : "null"));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		ListNode p1 = headA, p2 = headB;

		while (p1 != p2){

			if (p1 == null){
				p1 = headB;
			}else {
				p1 = p1.next;
			}

			if (p2 == null) {
				p2 = headA;
			}else {
				p2 = p2.next;
			}

		}

		return p1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
