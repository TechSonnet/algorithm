<p>给你一个整数数组 <code>nums</code> 和两个整数 <code>indexDiff</code> 和 <code>valueDiff</code> 。</p>

<p>找出满足下述条件的下标对 <code>(i, j)</code>：</p>

<ul> 
 <li><code>i != j</code>,</li> 
 <li><code>abs(i - j) &lt;= indexDiff</code></li> 
 <li><code>abs(nums[i] - nums[j]) &lt;= valueDiff</code></li> 
</ul>

<p>如果存在，返回 <code>true</code><em> ；</em>否则，返回<em> </em><code>false</code><em> </em>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
<strong>输出：</strong>true
<strong>解释：</strong>可以找出 (i, j) = (0, 3) 。
满足下述 3 个条件：
i != j --&gt; 0 != 3
abs(i - j) &lt;= indexDiff --&gt; abs(0 - 3) &lt;= 3
abs(nums[i] - nums[j]) &lt;= valueDiff --&gt; abs(1 - 1) &lt;= 0
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
<strong>输出：</strong>false
<strong>解释：</strong>尝试所有可能的下标对 (i, j) ，均无法满足这 3 个条件，因此返回 false 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
 <li><code>1 &lt;= indexDiff &lt;= nums.length</code></li> 
 <li><code>0 &lt;= valueDiff &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 桶排序 | 有序集合 | 排序 | 滑动窗口</details><br>

<div>👍 777, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
<!-- i_62b43720e4b07bd2d7b1b6dd -->

本题思路为 labuladong 网站会员专属，请 [点击这里](https://labuladong.online/algo/intro/site-vip/) 购买会员并「按照各个插件的解锁方法手动刷新数据」。

若之前已经购买会员并成功解锁插件，现在却突然出现这个问题，是因为添加了新的题解数据。请尝试重新手动刷新插件数据。进入 [会员购买页](https://labuladong.online/algo/intro/site-vip/) 向下翻即可查看各个插件刷新数据的方法。

若依然无法解决问题，可以在按照 [bug 反馈页面](https://labuladong.online/algo/intro/bug-report/) 的提示像我反馈问题，如是 bug 我会立即修复。</details>
</div>

