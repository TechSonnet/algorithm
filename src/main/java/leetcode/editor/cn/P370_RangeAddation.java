package leetcode.editor.cn;

/*
描述：
给定一个初始全为0的长度n的数组，进行k次更新操作。每次操作以三元组 [startIndex, endIndex, inc] 表示，
要求将子数组 A[startIndex...endIndex]（包含两端）增加inc，最终返回操作后的数组。
输入说明：
length: 数组长度，n >= 1
updates: 操作数组，每个元素为三元组 [startIndex, endIndex, inc]
其中 0 <= startIndex <= endIndex < n，inc为整数
输出说明：
最终数组，以整型列表形式返回
示例：
输入：length=5, updates=[[1,3,2],[2,4,3],[0,2,-2]]
输出：[-2, 0, 3, 5, 3]
解释：
初始状态： [0, 0, 0, 0, 0]
        1. 操作[1,3,2] → [0,2,2,2,0]
        2. 操作[2,4,3] → [0,2,5,5,3]
        3. 操作[0,2,-2] → [-2,0,3,5,3]
要求：时间复杂度需优化至 O(n + k)，避免直接模拟每个操作
*/


import java.util.Arrays;

/**
 * 跳跃游戏
 * @author Chang Liu
 * @date 2025-03-13 18:08:44
 */
public class P370_RangeAddation{
    public static void main(String[] args) {
        //测试代码
        int[] nums = new int[]{0, 0, 0 ,0 ,0};
        Difference diff = new P370_RangeAddation().new Difference(nums);
        int[][] updates = new int[][]{{1,3,2},{2,4,3},{0,2,-2}};
        for (int[] update : updates) {
            diff.increment(update[0], update[1], update[2]);
        }
        int[] result = diff.result();
        System.out.println(Arrays.toString(result));

    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Difference {

        private int[] diff;

        public Difference(int[] nums){

            assert nums.length > 0;

            diff = new int[nums.length];
            diff[0] = nums[0];

            for (int i = 1; i < diff.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public int[] result(){

            int[] res = new int[diff.length];
            res[0] = diff[0];

            for (int i = 1; i < res.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }

            return res;
        }

        public void increment(int i, int j, int val){
            diff[i] += val;
            if (j + 1 < diff.length){
                diff[j + 1] -= val;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}
