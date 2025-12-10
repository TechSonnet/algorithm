//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 2024, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;


import leetcode.editor.cn.structure.TreeNode;

/**
 * 翻转二叉树
 * @author Chang Liu
 * @date 2025-11-21 14:25:01
 */
public class P226_InvertBinaryTree{
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new P226_InvertBinaryTree().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {

        traverse(root);
        return root;

    }

    // 思路一：遍历一遍解决问题
    void traverse(TreeNode root){

        // 递归出口
        if (root == null){
            return ;
        }

        // 交换左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 遍历左右子树
        traverse(root.left);
        traverse(root.right);
    }

    // 思路二：拆解问题，使用分治策略
    TreeNode invertTree2(TreeNode root){

        if (root == null){
            return root;
        }

        TreeNode left = invertTree2(root.left);
       TreeNode right = invertTree2(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

}

//leetcode submit region end(Prohibit modification and deletion)

}