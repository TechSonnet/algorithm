//请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。 
//
// 请你完成 FrontMiddleBack 类： 
//
// 
// FrontMiddleBack() 初始化队列。 
// void pushFront(int val) 将 val 添加到队列的 最前面 。 
// void pushMiddle(int val) 将 val 添加到队列的 正中间 。 
// void pushBack(int val) 将 val 添加到队里的 最后面 。 
// int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。 
// int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。 
// int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。 
// 
//
// 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说： 
//
// 
// 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。 
// 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", 
//"popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
//[[], [1], [2], [3], [4], [], [], [], [], []]
//输出：
//[null, null, null, null, null, 1, 3, 4, 2, -1]
//
//解释：
//FrontMiddleBackQueue q = new FrontMiddleBackQueue();
//q.pushFront(1);   // [1]
//q.pushBack(2);    // [1, 2]
//q.pushMiddle(3);  // [1, 3, 2]
//q.pushMiddle(4);  // [1, 4, 3, 2]
//q.popFront();     // 返回 1 -> [4, 3, 2]
//q.popMiddle();    // 返回 3 -> [4, 2]
//q.popMiddle();    // 返回 4 -> [2]
//q.popBack();      // 返回 2 -> []
//q.popFront();     // 返回 -1 -> [] （队列为空）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= val <= 10⁹ 
// 最多调用 1000 次 pushFront， pushMiddle， pushBack， popFront， popMiddle 和 popBack 。 
//
// 
//
// Related Topics设计 | 队列 | 数组 | 链表 | 数据流 
//
// 👍 106, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.LinkedList;

/**
 * 设计前中后队列
 * @author Chang Liu
 * @date 2025-10-27 14:37:19
 */
public class P1670_DesignFrontMiddleBackQueue{
	 public static void main(String[] args) {
         //测试代码
     }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class FrontMiddleBackQueue {

         LinkedList<Integer> left = new LinkedList<>();
         LinkedList<Integer> right = new LinkedList<>();


    public FrontMiddleBackQueue() {
        
    }

    /**
     * 始终保持队列是合法的：左边=右边，左边=右边+1
     */
    private void balance(){
        // 左边比右边多一个
        if (left.size() > right.size()){
            right.addFirst(left.removeLast());
        }
        // 右边比左边多两个
        if (left.size() + 1 < right.size()){
            left.addLast(right.removeFirst());
        }
    }
    
    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }
    
    public void pushMiddle(int val) {
        if (size() % 2 == 0){
            right.addFirst(val);
        } else {
            left.addLast(val);
        }
        balance();
    }

    private int size(){
        return left.size() + right.size();
    }
    
    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }
    
    public int popFront() {
        if (size() == 0){
            return -1;
        }
        if (size() == 1){
            return right.removeFirst();
        }
        int val = left.removeFirst();
        balance();
        return val;
    }
    
    public int popMiddle() {

        if (size() == 0){
            return -1;
        }

        int e;
        if (size() % 2 == 0){
            e = left.removeLast();
        } else {
            e = right.removeFirst();
        }

        balance();

        return e;
    }
    
    public int popBack() {
        if (size() == 0){
            return -1;
        }
        int val = right.removeLast();
        balance();
        return val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
//leetcode submit region end(Prohibit modification and deletion)

}