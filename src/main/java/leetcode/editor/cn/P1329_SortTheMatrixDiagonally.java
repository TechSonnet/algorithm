//矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2
//][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。 
//
// 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
//输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,2
//5,68,4],[84,28,14,11,5,50]]
//输出：[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66]
//,[84,28,75,33,55,68]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 100 
// 1 <= mat[i][j] <= 100 
// 
//
// Related Topics数组 | 矩阵 | 排序 
//
// 👍 140, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.*;

/**
 * 将矩阵按对角线排序
 * @author Chang Liu
 * @date 2025-04-23 11:56:44
 */
public class P1329_SortTheMatrixDiagonally{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1329_SortTheMatrixDiagonally().new Solution();

          int[][] mat = new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}};
         int[][] res = solution.diagonalSort(mat);
         System.out.println(Arrays.deepToString(res));
     }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] diagonalSort(int[][] mat) {

        int m = mat.length, n = mat[0].length;

        // 1. 按对角线取出元素 extra elements along diagonals
        Map<Integer, ArrayList<Integer>> diagonals = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diagonalId = i - j;
                diagonals.putIfAbsent(diagonalId, new ArrayList<>());
                diagonals.get(i-j).add(mat[i][j]);
            }

        }

        // 2. 对每条对角线上的元素进行排序 sort the elements on each diagonals

        for (ArrayList diagonal : diagonals.values()){
            Collections.sort(diagonal, Collections.reverseOrder());
        }

        // 3. 将元素放回矩阵 put the elements back into matrix

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> res = diagonals.get(i - j);
                mat[i][j] = res.remove(res.size() - 1);
            }
        }

        return mat;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
