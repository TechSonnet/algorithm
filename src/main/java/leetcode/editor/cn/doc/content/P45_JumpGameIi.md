<p>给定一个长度为 <code>n</code> 的 <strong>0 索引</strong>整数数组 <code>nums</code>。初始位置为 <code>nums[0]</code>。</p>

<p>每个元素 <code>nums[i]</code> 表示从索引 <code>i</code> 向后跳转的最大长度。换句话说，如果你在 <code>nums[i]</code> 处，你可以跳转到任意 <code>nums[i + j]</code> 处:</p>

<ul> 
 <li><code>0 &lt;= j &lt;= nums[i]</code>&nbsp;</li> 
 <li><code>i + j &lt; n</code></li> 
</ul>

<p>返回到达&nbsp;<code>nums[n - 1]</code> 的最小跳跃次数。生成的测试用例可以到达 <code>nums[n - 1]</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = [2,3,1,1,4]
<strong>输出:</strong> 2
<strong>解释:</strong> 跳到最后一个位置的最小跳跃数是 <span><code>2</code></span>。
&nbsp;    从下标为 0 跳到下标为 1 的位置，跳&nbsp;<span><code>1</code></span>&nbsp;步，然后跳&nbsp;<span><code>3</code></span>&nbsp;步到达数组的最后一个位置。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = [2,3,0,1,4]
<strong>输出:</strong> 2
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 1000</code></li> 
 <li>题目保证可以到达&nbsp;<code>nums[n-1]</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 动态规划</details><br>

<div>👍 2782, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/greedy/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

常规的思维就是暴力穷举，把所有可行的跳跃方案都穷举出来，计算步数最少的。穷举的过程会有重叠子问题，用备忘录消除一下，就成了自顶向下的动态规划。

不过直观地想一想，似乎不需要穷举所有方案，只需要判断哪一个选择最具有「潜力」即可，这就是贪心思想来做，比动态规划效率更高。

![](https://labuladong.online/algo/images/jumpGame/1.jpg)

比如上图这种情况，我们站在索引 0 的位置，可以向前跳 1，2 或 3 步，你说应该选择跳多少呢？

**显然应该跳 2 步调到索引 2，因为 `nums[2]` 的可跳跃区域涵盖了索引区间 `[3..6]`，比其他的都大**。

这就是思路，我们用 `i` 和 `end` 标记了可以选择的跳跃步数，`farthest` 标记了所有选择 `[i..end]` 中能够跳到的最远距离，`jumps` 记录跳跃次数。

**详细题解**：
  - [贪心算法解题套路框架](https://labuladong.online/algo/essential-technique/greedy/)

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

class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        end = 0
        farthest = 0
        jumps = 0
        for i in range(n - 1):
            farthest = max(nums[i] + i, farthest)
            if end == i:
                jumps += 1
                end = farthest
        return jumps
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func jump(nums []int) int {
    n := len(nums)
    end, farthest, jumps := 0, 0, 0
    for i := 0; i < n-1; i++ {
        farthest = max(nums[i]+i, farthest)
        if end == i {
            jumps++
            end = farthest
        }
    }
    return jumps
}

func max(a, b int) int {
    if a > b {
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

var jump = function(nums) {
    let n = nums.length;
    let end = 0, farthest = 0;
    let jumps = 0;
    for (let i = 0; i < n - 1; i++) {
        farthest = Math.max(nums[i] + i, farthest);
        if (end === i) {
            jumps++;
            end = farthest;
        }
    }
    return jumps;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_jump-game-ii"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_jump-game-ii"></div></div>
</details><hr /><br />

</div>
</details>
</div>

