<p>给你一个&nbsp;<code>m x n</code>&nbsp;的矩阵&nbsp;<code>mat</code>&nbsp;和一个整数 <code>k</code> ，请你返回一个矩阵&nbsp;<code>answer</code>&nbsp;，其中每个&nbsp;<code>answer[i][j]</code>&nbsp;是所有满足下述条件的元素&nbsp;<code>mat[r][c]</code> 的和：&nbsp;</p>

<ul> 
 <li><code>i - k &lt;= r &lt;= i + k, </code></li> 
 <li><code>j - k &lt;= c &lt;= j + k</code> 且</li> 
 <li><code>(r, c)</code>&nbsp;在矩阵内。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
<strong>输出：</strong>[[12,21,16],[27,45,33],[24,39,28]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
<strong>输出：</strong>[[45,45,45],[45,45,45],[45,45,45]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m ==&nbsp;mat.length</code></li> 
 <li><code>n ==&nbsp;mat[i].length</code></li> 
 <li><code>1 &lt;= m, n, k &lt;= 100</code></li> 
 <li><code>1 &lt;= mat[i][j] &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 矩阵 | 前缀和</details><br>

<div>👍 213, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题可以直接套用前文 [前缀和数组技巧](https://labuladong.online/algo/data-structure/prefix-sum/) 中讲 [✔ ✨304. 二维区域和检索](/problems/range-sum-query-2d-immutable/) 时实现的 `NumMatrix` 类，没什么难度。主要注意下通过 `min, max` 函数优雅避免索引越界的技巧，这个还是蛮常用的。

**详细题解**：
  - [【强化练习】前缀和技巧经典习题](https://labuladong.online/algo/problem-set/perfix-sum/)

</div>





<div id="solution">

## 解法代码



<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

#include <vector>
#include <algorithm>
using namespace std;

class NumMatrix {
public:
    // 定义：preSum[i][j] 记录 matrix 中子矩阵 [0, 0, i-1, j-1] 的元素和
    vector<vector<int>> preSum;

    NumMatrix(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        preSum.resize(m + 1, vector<int>(n + 1, 0));
        // 构造前缀和矩阵
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 计算每个矩阵 [0, 0, i, j] 的元素和
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }
    }

    // 计算子矩阵 [x1, y1, x2, y2] 的元素和
    int sumRegion(int x1, int y1, int x2, int y2) {
        // 目标矩阵之和由四个相邻矩阵运算获得
        return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
    }
};

class Solution {
public:
    vector<vector<int>> matrixBlockSum(vector<vector<int>>& mat, int k) {
        int m = mat.size(), n = mat[0].size();
        NumMatrix numMatrix(mat);
        vector<vector<int>> res(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 左上角的坐标
                int x1 = max(i - k, 0);
                int y1 = max(j - k, 0);
                // 右下角坐标
                int x2 = min(i + k, m - 1);
                int y2 = min(j + k, n - 1);

                res[i][j] = numMatrix.sumRegion(x1, y1, x2, y2);
            }
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def matrixBlockSum(self, mat, k):
        m, n = len(mat), len(mat[0])
        numMatrix = NumMatrix(mat)
        res = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                # 左上角的坐标
                x1 = max(i - k, 0)
                y1 = max(j - k, 0)
                # 右下角坐标
                x2 = min(i + k, m - 1)
                y2 = min(j + k, n - 1)

                res[i][j] = numMatrix.sumRegion(x1, y1, x2, y2)
        return res


class NumMatrix:
    # 定义：preSum[i][j] 记录 matrix 中子矩阵 [0, 0, i-1, j-1] 的元素和
    def __init__(self, matrix):
        m, n = len(matrix), len(matrix[0])
        # 构造前缀和矩阵
        self.preSum = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # 计算每个矩阵 [0, 0, i, j] 的元素和
                self.preSum[i][j] = (self.preSum[i - 1][j] + self.preSum[i][j - 1] +
                                     matrix[i - 1][j - 1] - self.preSum[i - 1][j - 1])

    # 计算子矩阵 [x1, y1, x2, y2] 的元素和
    def sumRegion(self, x1, y1, x2, y2):
        # 目标矩阵之和由四个相邻矩阵运算获得
        return (self.preSum[x2 + 1][y2 + 1] - self.preSum[x1][y2 + 1] -
                self.preSum[x2 + 1][y1] + self.preSum[x1][y1])
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        NumMatrix numMatrix = new NumMatrix(mat);
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 左上角的坐标
                int x1 = Math.max(i - k, 0);
                int y1 = Math.max(j - k, 0);
                // 右下角坐标
                int x2 = Math.min(i + k, m - 1);
                int y2 = Math.min(j + k, n - 1);

                res[i][j] = numMatrix.sumRegion(x1, y1, x2, y2);
            }
        }
        return res;
    }
}

class NumMatrix {
    // 定义：preSum[i][j] 记录 matrix 中子矩阵 [0, 0, i-1, j-1] 的元素和
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) return;
        // 构造前缀和矩阵
        preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 计算每个矩阵 [0, 0, i, j] 的元素和
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }
    }

    // 计算子矩阵 [x1, y1, x2, y2] 的元素和
    public int sumRegion(int x1, int y1, int x2, int y2) {
        // 目标矩阵之和由四个相邻矩阵运算获得
        return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

type NumMatrix struct {
    // 定义：preSum[i][j] 记录 matrix 中子矩阵 [0, 0, i-1, j-1] 的元素和
    preSum [][]int
}

func Constructor(matrix [][]int) NumMatrix {
    m, n := len(matrix), len(matrix[0])
    if m == 0 || n == 0 {
        return NumMatrix{}
    }
    // 构造前缀和矩阵
    preSum := make([][]int, m+1)
    for i := range preSum {
        preSum[i] = make([]int, n+1)
    }
    for i := 1; i <= m; i++ {
        for j := 1; j <= n; j++ {
            // 计算每个矩阵 [0, 0, i, j] 的元素和
            preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i-1][j-1] - preSum[i-1][j-1]
        }
    }
    return NumMatrix{preSum}
}

// 计算子矩阵 [x1, y1, x2, y2] 的元素和
func (this *NumMatrix) SumRegion(x1, y1, x2, y2 int) int {
    // 目标矩阵之和由四个相邻矩阵运算获得
    return this.preSum[x2+1][y2+1] - this.preSum[x1][y2+1] - this.preSum[x2+1][y1] + this.preSum[x1][y1]
}

func matrixBlockSum(mat [][]int, k int) [][]int {
    m, n := len(mat), len(mat[0])
    numMatrix := Constructor(mat)
    res := make([][]int, m)
    for i := range res {
        res[i] = make([]int, n)
    }
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            // 左上角的坐标
            x1 := max(i-k, 0)
            y1 := max(j-k, 0)
            // 右下角坐标
            x2 := min(i+k, m-1)
            y2 := min(j+k, n-1)

            res[i][j] = numMatrix.SumRegion(x1, y1, x2, y2)
        }
    }
    return res
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var matrixBlockSum = function(mat, k) {
    const m = mat.length, n = mat[0].length;
    const numMatrix = new NumMatrix(mat);
    const res = Array.from({length: m}, () => Array(n).fill(0));
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            // 左上角的坐标
            const x1 = Math.max(i - k, 0);
            const y1 = Math.max(j - k, 0);
            // 右下角坐标
            const x2 = Math.min(i + k, m - 1);
            const y2 = Math.min(j + k, n - 1);
            res[i][j] = numMatrix.sumRegion(x1, y1, x2, y2);
        }
    }
    return res;
};

class NumMatrix {
    constructor(matrix) {
        const m = matrix.length, n = matrix[0].length;
        // 定义：preSum[i][j] 记录 matrix 中子矩阵 [0, 0, i-1, j-1] 的元素和
        this.preSum = Array.from({length: m + 1}, () => Array(n + 1).fill(0));
        // 构造前缀和矩阵
        for (let i = 1; i <= m; i++) {
            for (let j = 1; j <= n; j++) {
                // 计算每个矩阵 [0, 0, i, j] 的元素和
                this.preSum[i][j] = this.preSum[i - 1][j] + this.preSum[i][j - 1] + matrix[i - 1][j - 1] - this.preSum[i - 1][j - 1];
            }
        }
    }

    sumRegion(x1, y1, x2, y2) {
        // 计算子矩阵 [x1, y1, x2, y2] 的元素和
        // 目标矩阵之和由四个相邻矩阵运算获得
        return this.preSum[x2 + 1][y2 + 1] - this.preSum[x1][y2 + 1] - this.preSum[x2 + 1][y1] + this.preSum[x1][y1];
    }
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_matrix-block-sum"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_matrix-block-sum"></div></div>
</details><hr /><br />

</div>
</details>
</div>

