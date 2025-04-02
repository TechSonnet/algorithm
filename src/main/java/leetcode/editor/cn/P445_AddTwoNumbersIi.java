//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
//
// Related Topics栈 | 链表 | 数学 
//
// 👍 758, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 两数相加 II
 * @author Chang Liu
 * @date 2025-04-02 09:19:39
 */
public class P445_AddTwoNumbersIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P445_AddTwoNumbersIi().new Solution();

         ListNode l1 = ListNode.createLinkedList(new int[]{7,2,4,3});
         ListNode l2 = ListNode.createLinkedList(new int[]{5,6,4});

         ListNode res = solution.addTwoNumbers2(l1, l2);
         ListNode.printList(res);
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverseLinkList(l1);
        l2 = reverseLinkList(l2);
        ListNode p1 = l1, p2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        int carry = 0;

        // carry > 0 用于处理循环结束后，最后一位可能是进位（5+5=10），必须保留
        // 如果不在这里加上，就必须在循环外额外处理
        while (p1 != null || p2 != null || carry > 0){

            int val = carry;

            if (p1 != null){
                val += p1.val;
                p1 = p1.next;
            }

            if (p2 != null){
                val += p2.val;
                p2 = p2.next;
            }

            carry = val / 10;
            val = val % 10;

            p.next = new ListNode(val);
            p = p.next;
        }


        return reverseLinkList(dummy.next);
    }

    public ListNode reverseLinkList(ListNode head){

        if (head == null || head.next == null){
            return head;
        }

        ListNode last = reverseLinkList(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){

        LinkedList<ListNode> stack1 = new LinkedList<>();
        LinkedList<ListNode> stack2 = new LinkedList<>();

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (p1 != null){
            stack1.push(p1);;
            p1 = p1.next;
        }

        while (p2 != null){
            stack2.push(p2);
            p2 = p2.next;
        }

        int carry = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0){

            int val = carry;

            if (!stack1.isEmpty()){
                val += stack1.pop().val;
            }

            if (!stack2.isEmpty()) {
                val += stack2.pop().val;
            }

            carry = val / 10;
            val = val % 10;

            // 头插法
            ListNode res = new ListNode(val);
            res.next = dummy.next;
            dummy.next = res;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
