package com.cslp.ken.number236;

//二叉树的最近公共祖先
public class Solution_2nd {

  private TreeNode ans;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //1.递归判断条件，满足条件就设置ans;
    dfs(root, p, q);
    //2.返回ans
    return ans;
  }

  private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
    //1.terminal
    if (root == null) return false;
    boolean lson = dfs(root.left, p, q);
    boolean rson = dfs(root.right, p, q);
    //2.process
    if (lson && rson || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
      ans = root;
    }

    //3.drill down
    return (lson || rson || (root.val == p.val || root.val == q.val) );

    //4.reverse
  }
}

