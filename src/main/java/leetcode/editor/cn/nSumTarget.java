package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nSumTarget {

    public static void main(String[] args) {
        //测试代码
        nSumTarget.Solution solution = new nSumTarget().new Solution();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        Arrays.sort(nums);
        List<List<Integer>> res = solution.nSum(nums, 4, 0, 0);
        System.out.println(res);


    }

    class Solution {

        /**
         * @param nums：此处是一个通用方法，调用此方法前应该就对此数组排序
         * @param n
         * @param start
         * @param target
         * @return
         */
        public List<List<Integer>> nSum(int[] nums,int  n, int start,  long target) {

            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();

            if (nums.length < 2 || n < 2){
                return res;
            }

            if (n == 2){

                int left = start, right = nums.length - 1;

                while (left < right){

                    int lo = nums[left], hi = nums[right];
                    int sum = lo + hi;

                    if (sum == target){

                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(lo);
                        temp.add(hi);
                        res.add(temp);
                        while (left < right && lo == nums[left]) left++;
                        while (left < right && hi == nums[right]) right--;

                    } else if (sum < target){
                        left++;
                    } else if (sum > target){
                        right--;
                    }
                }

            } else {

                for (int i = start; i < len; i++) {
                    List<List<Integer>> tuples = nSum(nums, n - 1, i + 1, target - nums[i]);

                    for (List<Integer> tuple : tuples) {
                        tuple.add(nums[i]);
                        res.add(tuple);
                    }

                    while (i < len - 1 && nums[i] == nums[i+1]) i++;
                }
            }

            return res;
        }
    }
}
