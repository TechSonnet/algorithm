//设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”
//。 
//
// 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环
//队列，我们能使用这些空间去存储新的值。 
//
// 你的实现应该支持如下操作： 
//
// 
// MyCircularQueue(k): 构造器，设置队列长度为 k 。 
// Front: 从队首获取元素。如果队列为空，返回 -1 。 
// Rear: 获取队尾元素。如果队列为空，返回 -1 。 
// enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。 
// deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。 
// isEmpty(): 检查循环队列是否为空。 
// isFull(): 检查循环队列是否已满。 
// 
//
// 
//
// 示例： 
//
// MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
//circularQueue.enQueue(1);  // 返回 true
//circularQueue.enQueue(2);  // 返回 true
//circularQueue.enQueue(3);  // 返回 true
//circularQueue.enQueue(4);  // 返回 false，队列已满
//circularQueue.Rear();  // 返回 3
//circularQueue.isFull();  // 返回 true
//circularQueue.deQueue();  // 返回 true
//circularQueue.enQueue(4);  // 返回 true
//circularQueue.Rear();  // 返回 4 
//
// 
//
// 提示： 
//
// 
// 所有的值都在 0 至 1000 的范围内； 
// 操作数将在 1 至 1000 的范围内； 
// 请不要使用内置的队列库。 
// 
//
// Related Topics设计 | 队列 | 数组 | 链表 
//
// 👍 571, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

/**
 * 设计循环队列
 * @author Chang Liu
 * @date 2025-10-25 10:05:18
 */
public class P622_DesignCircularQueue{
	 public static void main(String[] args) {
	     //测试代码

	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 这是一道非常有意思，也非常具有借鉴意义的题目
     * 注意下面的写法，这是一种设计数据结构的写法，属性、方法等如何设置，都是很有借鉴意义的
     * 当然，这道题目中如何世界循环队列还是有一定借鉴意义的。
     */
    class MyCircularQueue {

        // 定义合适的属性
        int front = 0;
        int rear = 0;
        int cap = 0;
        int[] myArray = {};


    public MyCircularQueue(int k) {

        // 这里设置数组的 cap 为 k+1, 这样做可以更好的判断队空和队满
        // 队空：rear = front
        // 队满：(rear + 1) % cap == front
        this.cap = k + 1;
        this.myArray = new int[cap];

    }
    
    public boolean enQueue(int value) {

        if (!isFull()){
            rear = (rear + 1) % cap;
            myArray[rear] = value;
            return true;
        }

        return false;
    }
    
    public boolean deQueue() {
        if (!isEmpty()){
            front = (front+1) % cap;
            return true;
        }
        return false;
    }
    
    public int Front() {

        if (isEmpty()){
            return -1;
        }

        return myArray[(front + 1) % cap];
    }
    
    public int Rear() {

        if (isEmpty()){
            return -1;
        }

        return myArray[rear];
    }
    
    public boolean isEmpty() {

        return front == rear;
    }
    
    public boolean isFull() {

        return (rear + 1) % cap == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
