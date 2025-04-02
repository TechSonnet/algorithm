package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

public class ReverseN {

    /**
     * 迭代解法
     * @param head
     * @param n
     * @return
     */
    public ListNode reverseN(ListNode head, int n){

        if (head == null || head.next == null){
            return head;
        }

        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        nxt = head.next;

        while (n > 0){
            cur.next = pre;
            pre = cur;
            cur = nxt;

            if (nxt != null){
                nxt = nxt.next;
            }

            n--;
        }

        head.next = cur;

        return pre;
    }

    /**
     * 递归解法
     * @param head
     * @param n
     * @return
     */

    ListNode successor = null;
    public ListNode reverseN2(ListNode head, int n){

        if (n == 1){
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;

        return last;
    }

}
