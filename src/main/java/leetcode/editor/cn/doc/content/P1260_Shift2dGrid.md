<p>给你一个 <code>m</code> 行 <code>n</code>&nbsp;列的二维网格&nbsp;<code>grid</code>&nbsp;和一个整数&nbsp;<code>k</code>。你需要将&nbsp;<code>grid</code>&nbsp;迁移&nbsp;<code>k</code>&nbsp;次。</p>

<p>每次「迁移」操作将会引发下述活动：</p>

<ul> 
 <li>位于 <code>grid[i][j]</code>（<code>j &lt; n - 1</code>）的元素将会移动到&nbsp;<code>grid[i][j + 1]</code>。</li> 
 <li>位于&nbsp;<code>grid[i][n&nbsp;- 1]</code> 的元素将会移动到&nbsp;<code>grid[i + 1][0]</code>。</li> 
 <li>位于 <code>grid[m&nbsp;- 1][n - 1]</code>&nbsp;的元素将会移动到&nbsp;<code>grid[0][0]</code>。</li> 
</ul>

<p>请你返回&nbsp;<code>k</code> 次迁移操作后最终得到的 <strong>二维网格</strong>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/16/e1-1.png" style="height: 158px; width: 400px;" /></p>

<pre>
<span><code><strong>输入：</strong>grid</code></span> = [[1,2,3],[4,5,6],[7,8,9]], k = 1
<strong>输出：</strong>[[9,1,2],[3,4,5],[6,7,8]]
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/16/e2-1.png" style="height: 166px; width: 400px;" /></p>

<pre>
<span><code><strong>输入：</strong>grid</code></span> = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
<strong>输出：</strong>[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<span><code><strong>输入：</strong>grid</code></span> = [[1,2,3],[4,5,6],[7,8,9]], k = 9
<strong>输出：</strong>[[1,2,3],[4,5,6],[7,8,9]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m ==&nbsp;grid.length</code></li> 
 <li><code>n ==&nbsp;grid[i].length</code></li> 
 <li><code>1 &lt;= m &lt;= 50</code></li> 
 <li><code>1 &lt;= n &lt;= 50</code></li> 
 <li><code>-1000 &lt;= grid[i][j] &lt;= 1000</code></li> 
 <li><code>0 &lt;= k &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 矩阵 | 模拟</details><br>

<div>👍 134, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
<!-- i_62b43720e4b07bd2d7b1b6dd -->

本题思路为 labuladong 网站会员专属，请 [点击这里](https://labuladong.online/algo/intro/site-vip/) 购买会员并「按照各个插件的解锁方法手动刷新数据」。

若之前已经购买会员并成功解锁插件，现在却突然出现这个问题，是因为添加了新的题解数据。请尝试重新手动刷新插件数据。进入 [会员购买页](https://labuladong.online/algo/intro/site-vip/) 向下翻即可查看各个插件刷新数据的方法。

若依然无法解决问题，可以在按照 [bug 反馈页面](https://labuladong.online/algo/intro/bug-report/) 的提示像我反馈问题，如是 bug 我会立即修复。</details>
</div>

