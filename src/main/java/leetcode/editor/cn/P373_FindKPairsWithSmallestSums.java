//给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1 和 nums2 均为 升序排列 
// 
// 1 <= k <= 10⁴ 
// k <= nums1.length * nums2.length 
// 
//
// Related Topics数组 | 堆（优先队列） 
//
// 👍 655, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 查找和最小的 K 对数字
 * @author Chang Liu
 * @date 2025-03-31 10:02:41
 */
public class P373_FindKPairsWithSmallestSums{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P373_FindKPairsWithSmallestSums().new Solution();

          int[] nums1 = new int[]{1,7,11};
          int[] nums2 = new int[]{2,4,6};

         List<List<Integer>> res = solution.kSmallestPairs(nums1, nums2, 3);
         System.out.println(res);
     }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        /**
         * 这里类似 378 题，同样用一个数组来表示一个元素（题目需要的元素），其实这就是
         * 元组的概念，妙啊
         *
         * 此外，这道题目虚拟出来的链表数量，更是重量级的
         */

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return (a[0] + a[1]) - (b[0] + b[1]);
        });

        for (int i = 0; i < nums1.length; i++){
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }

        List<List<Integer>> res = new ArrayList<>();

        while (!pq.isEmpty() && k > 0) {

            int[] cur = pq.poll();
            k--;
            int next_index = cur[2] + 1;

            if (next_index < nums2.length){
                pq.add(new int[]{cur[0], nums2[next_index], next_index});
            }

            List<Integer> pair = new ArrayList<>();
            pair.add(cur[0]);
            pair.add(cur[1]);
            res.add(pair);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
