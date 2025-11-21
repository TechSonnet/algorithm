<p><code>nums1</code>&nbsp;中数字&nbsp;<code>x</code>&nbsp;的 <strong>下一个更大元素</strong> 是指&nbsp;<code>x</code>&nbsp;在&nbsp;<code>nums2</code> 中对应位置 <strong>右侧</strong> 的 <strong>第一个</strong> 比&nbsp;<code>x</code><strong>&nbsp;</strong>大的元素。</p>

<p>给你两个<strong> 没有重复元素</strong> 的数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code> ，下标从 <strong>0</strong> 开始计数，其中<code>nums1</code>&nbsp;是&nbsp;<code>nums2</code>&nbsp;的子集。</p>

<p>对于每个 <code>0 &lt;= i &lt; nums1.length</code> ，找出满足 <code>nums1[i] == nums2[j]</code> 的下标 <code>j</code> ，并且在 <code>nums2</code> 确定 <code>nums2[j]</code> 的 <strong>下一个更大元素</strong> 。如果不存在下一个更大元素，那么本次查询的答案是 <code>-1</code> 。</p>

<p>返回一个长度为&nbsp;<code>nums1.length</code> 的数组<em> </em><code>ans</code><em> </em>作为答案，满足<em> </em><code>ans[i]</code><em> </em>是如上所述的 <strong>下一个更大元素</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [4,1,2], nums2 = [1,3,4,2].
<strong>输出：</strong>[-1,3,-1]
<strong>解释：</strong>nums1 中每个值的下一个更大元素如下所述：
- 4 ，用加粗斜体标识，nums2 = [1,3,<strong>4</strong>,2]。不存在下一个更大元素，所以答案是 -1 。
- 1 ，用加粗斜体标识，nums2 = [<em><strong>1</strong></em>,3,4,2]。下一个更大元素是 3 。
- 2 ，用加粗斜体标识，nums2 = [1,3,4,<em><strong>2</strong></em>]。不存在下一个更大元素，所以答案是 -1 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [2,4], nums2 = [1,2,3,4].
<strong>输出：</strong>[3,-1]
<strong>解释：</strong>nums1 中每个值的下一个更大元素如下所述：
- 2 ，用加粗斜体标识，nums2 = [1,<em><strong>2</strong></em>,3,4]。下一个更大元素是 3 。
- 4 ，用加粗斜体标识，nums2 = [1,2,3,<em><strong>4</strong></em>]。不存在下一个更大元素，所以答案是 -1 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums1.length &lt;= nums2.length &lt;= 1000</code></li> 
 <li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>nums1</code>和<code>nums2</code>中所有整数 <strong>互不相同</strong></li> 
 <li><code>nums1</code> 中的所有整数同样出现在 <code>nums2</code> 中</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以设计一个时间复杂度为 <code>O(nums1.length + nums2.length)</code> 的解决方案吗？</p>

<details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 哈希表 | 单调栈</details><br>

<div>👍 1286, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/monotonic-stack/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

[单调栈模板](https://labuladong.online/algo/data-structure/monotonic-stack/) 实现了一个计算下一个更大元素的函数，这里可以直接复用。因为题目说 `nums1` 是 `nums2` 的子集，那么我们先把 `nums2` 中每个元素的下一个更大元素算出来存到一个映射里，然后再让 `nums1` 中的元素去查表即可。

**详细题解**：
  - [单调栈算法模板解决三道例题](https://labuladong.online/algo/data-structure/monotonic-stack/)

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
#include <stack>
#include <unordered_map>

class Solution {
public:
    std::vector<int> nextGreaterElement(std::vector<int>& nums1, std::vector<int>& nums2) {
        // 记录 nums2 中每个元素的下一个更大元素
        std::vector<int> greater = nextGreaterElement(nums2);
        // 转化成映射：元素 x -> x 的下一个最大元素
        std::unordered_map<int, int> greaterMap;
        for (int i = 0; i < nums2.size(); i++) {
            greaterMap[nums2[i]] = greater[i];
        }
        // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
        std::vector<int> res(nums1.size());
        for (int i = 0; i < nums1.size(); i++) {
            res[i] = greaterMap[nums1[i]];
        }
        return res;
    }

    // 计算 nums 中每个元素的下一个更大元素
    std::vector<int> nextGreaterElement(std::vector<int>& nums) {
        int n = nums.size();
        // 存放答案的数组
        std::vector<int> res(n);
        std::stack<int> s;
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.empty() && s.top() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的下一个更大元素
            res[i] = s.empty() ? -1 : s.top();
            s.push(nums[i]);
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
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # 记录 nums2 中每个元素的下一个更大元素
        greater = self.nextGreaterElementInternal(nums2)
        # 转化成映射：元素 x -> x 的下一个最大元素
        greater_map = {}
        for i in range(len(nums2)):
            greater_map[nums2[i]] = greater[i]
        # nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
        res = [greater_map[num] for num in nums1]
        return res

    # 计算 nums 中每个元素的下一个更大元素
    def nextGreaterElementInternal(self, nums: List[int]) -> List[int]:
        n = len(nums)
        # 存放答案的数组
        res = [-1] * n  # Initialize with -1 as specified in the problem statement
        stack = []
        # 倒着往栈里放
        for i in range(n - 1, -1, -1):
            # 判定个子高矮
            while stack and stack[-1] <= nums[i]:
                # 矮个起开，反正也被挡着了。。。
                stack.pop()
            # nums[i] 身后的下一个更大元素
            res[i] = stack[-1] if stack else -1
            stack.append(nums[i])
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 记录 nums2 中每个元素的下一个更大元素
        int[] greater = nextGreaterElement(nums2);
        // 转化成映射：元素 x -> x 的下一个最大元素
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            greaterMap.put(nums2[i], greater[i]);
        }
        // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }

    // 计算 nums 中每个元素的下一个更大元素
    int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的下一个更大元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func nextGreaterElement(nums1 []int, nums2 []int) []int {
    // 记录 nums2 中每个元素的下一个更大元素
    greater := nextGreaterElementSingle(nums2)
    // 转化成映射：元素 x -> x 的下一个最大元素
    greaterMap := make(map[int]int)
    for i, num := range nums2 {
        greaterMap[num] = greater[i]
    }
    // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
    res := make([]int, len(nums1))
    for i, num := range nums1 {
        res[i] = greaterMap[num]
    }
    return res
}

// 计算 nums 中每个元素的下一个更大元素
func nextGreaterElementSingle(nums []int) []int {
    n := len(nums)
    // 存放答案的数组
    res := make([]int, n)
    stack := []int{}
    // 倒着往栈里放
    for i := n - 1; i >= 0; i-- {
        // 判定个子高矮
        for len(stack) > 0 && stack[len(stack)-1] <= nums[i] {
            // 矮个起开，反正也被挡着了。。。
            stack = stack[:len(stack)-1]
        }
        // nums[i] 身后的下一个更大元素
        if len(stack) == 0 {
            res[i] = -1
        } else {
            res[i] = stack[len(stack)-1]
        }
        stack = append(stack, nums[i])
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var nextGreaterElement = function(nums1, nums2) {
    // 记录 nums2 中每个元素的下一个更大元素
    let greater = calculateNextGreaterElement(nums2);
    // 转化成映射：元素 x -> x 的下一个最大元素
    let greaterMap = new Map();
    for (let i = 0; i < nums2.length; i++) {
        greaterMap.set(nums2[i], greater[i]);
    }
    // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
    let res = new Array(nums1.length);
    for (let i = 0; i < nums1.length; i++) {
        res[i] = greaterMap.get(nums1[i]);
    }
    return res;
};

// 计算 nums 中每个元素的下一个更大元素
var calculateNextGreaterElement = function(nums) {
    let n = nums.length;
    // 存放答案的数组
    let res = new Array(n);
    let s = [];
    // 倒着往栈里放
    for (let i = n - 1; i >= 0; i--) {
        // 判定个子高矮
        while (s.length > 0 && s[s.length - 1] <= nums[i]) {
            // 矮个起开，反正也被挡着了。。。
            s.pop();
        }
        // nums[i] 身后的下一个更大元素
        res[i] = s.length === 0 ? -1 : s[s.length - 1];
        s.push(nums[i]);
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_next-greater-element-i"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_next-greater-element-i"></div></div>
</details><hr /><br />

</div>
</details>
</div>





