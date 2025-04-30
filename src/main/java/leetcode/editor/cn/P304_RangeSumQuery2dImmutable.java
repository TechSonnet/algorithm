//给定一个二维矩阵 matrix，以下类型的多个请求： 
//
// 
// 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。 
// 
//
// 实现 NumMatrix 类： 
//
// 
// NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化 
// int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下
//角 (row2, col2) 所描述的子矩阵的元素 总和 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: 
//["NumMatrix","sumRegion","sumRegion","sumRegion"]
//[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,
//1,2,2],[1,2,2,4]]
//输出: 
//[null, 8, 11, 12]
//
//解释:
//NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,
//0,1,7],[1,0,3,0,5]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200
// 
// -10⁵ <= matrix[i][j] <= 10⁵ 
// 0 <= row1 <= row2 < m 
// 0 <= col1 <= col2 < n 
// 
// 最多调用 10⁴ 次 sumRegion 方法 
// 
//
// Related Topics设计 | 数组 | 矩阵 | 前缀和 
//
// 👍 603, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

/**
 * 二维区域和检索 - 矩阵不可变
 * @author Chang Liu
 * @date 2025-04-30 10:25:02
 */
public class P304_RangeSumQuery2dImmutable{
	 public static void main(String[] args) {
	     //测试代码
         int[][] matrix = new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
         NumMatrix solution = new P304_RangeSumQuery2dImmutable().new NumMatrix(matrix);
         int res = solution.sumRegion(1, 1, 2, 2);
         System.out.println(res);
     }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {

         int[][] preMatrix = null;

    public NumMatrix(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        preMatrix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                /**
                 * 这个式子，要和下面的式子进行区别
                 * 这个式子计算的是递增的总和，计算逻辑为利用区域和差与当前元素的和相加
                 * 而下面的式子则是计算一个区域的值，并非从(0,0)坐标开始的，计算逻辑为单纯利用区域的和差
                 *
                 * 需不需要 - 1，要看需不需要被保留
                 */
                preMatrix[i][j] = preMatrix[i - 1][j] + preMatrix[i][j - 1] +
                        matrix[i - 1][j - 1] - preMatrix[i - 1][j - 1];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        /**
         * 这里可以这么理解，row1 col1 两行，是需要保留的，故所减去的区域应为 row1-1, co1l-1,所以 + 1 后保持了 row1,col1
         * 而 cow2 和 col2 属于应该被减掉的面积，所以应为 cow2+1,col2+1
         */
        return preMatrix[row2 + 1][col2 + 1] - preMatrix[row1][col2 + 1] - preMatrix[row2 + 1][col1] + preMatrix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
