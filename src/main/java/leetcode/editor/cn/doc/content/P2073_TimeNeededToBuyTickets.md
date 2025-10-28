<p>有 <code>n</code> 个人前来排队买票，其中第 <code>0</code> 人站在队伍 <strong>最前方</strong> ，第 <code>(n - 1)</code> 人站在队伍 <strong>最后方</strong> 。</p>

<p>给你一个下标从 <strong>0</strong> 开始的整数数组 <code>tickets</code> ，数组长度为 <code>n</code> ，其中第 <code>i</code> 人想要购买的票数为 <code>tickets[i]</code> 。</p>

<p>每个人买票都需要用掉 <strong>恰好 1 秒</strong> 。一个人 <strong>一次只能买一张票</strong> ，如果需要购买更多票，他必须走到&nbsp; <strong>队尾</strong> 重新排队（<strong>瞬间 </strong>发生，不计时间）。如果一个人没有剩下需要买的票，那他将会 <strong>离开</strong> 队伍。</p>

<p>返回位于位置 <code>k</code>（下标从 <strong>0</strong> 开始）的人完成买票需要的时间（以秒为单位）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong>tickets = [2,3,2], k = 2</p> 
</div>

<p><strong>输出：</strong>6</p>

<p><strong>解释：</strong></p>

<ul> 
 <li>队伍一开始为 [2,3,2]，第 k 个人以下划线标识。</li> 
 <li>在最前面的人买完票后，队伍在第 1 秒变成 [3,<u>2</u>,1]。</li> 
 <li>继续这个过程，队伍在第 2 秒变为[<u>2</u>,1,2]。</li> 
 <li>继续这个过程，队伍在第 3 秒变为[1,2,<u>1</u>]。</li> 
 <li>继续这个过程，队伍在第 4 秒变为[2,<u>1</u>]。</li> 
 <li>继续这个过程，队伍在第 5 秒变为[<u>1</u>,1]。</li> 
 <li>继续这个过程，队伍在第 6 秒变为[1]。第 k 个人完成买票，所以返回 6。</li> 
</ul>

<p><strong>示例 2：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong>tickets = [5,1,1,1], k = 0</p> 
</div>

<p><strong>输出：</strong>8</p>

<p><strong>解释：</strong></p>

<ul> 
 <li>队伍一开始为 [<u>5</u>,1,1,1]，第 k 个人以下划线标识。</li> 
 <li>在最前面的人买完票后，队伍在第 1 秒变成 [1,1,1,<u>4</u>]。</li> 
 <li>继续这个过程 3 秒，队伍在第 4&nbsp;秒变为[<u>4</u>]。</li> 
 <li>继续这个过程 4 秒，队伍在第 8&nbsp;秒变为[]。第 k 个人完成买票，所以返回 8。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == tickets.length</code></li> 
 <li><code>1 &lt;= n &lt;= 100</code></li> 
 <li><code>1 &lt;= tickets[i] &lt;= 100</code></li> 
 <li><code>0 &lt;= k &lt; n</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>队列 | 数组 | 模拟</details><br>

<div>👍 86, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
<!-- i_62b43720e4b07bd2d7b1b6dd -->

本题思路为 labuladong 网站会员专属，请 [点击这里](https://labuladong.online/algo/intro/site-vip/) 购买会员并「按照各个插件的解锁方法手动刷新数据」。

若之前已经购买会员并成功解锁插件，现在却突然出现这个问题，是因为添加了新的题解数据。请尝试重新手动刷新插件数据。进入 [会员购买页](https://labuladong.online/algo/intro/site-vip/) 向下翻即可查看各个插件刷新数据的方法。

若依然无法解决问题，可以在按照 [bug 反馈页面](https://labuladong.online/algo/intro/bug-report/) 的提示像我反馈问题，如是 bug 我会立即修复。</details>
</div>

