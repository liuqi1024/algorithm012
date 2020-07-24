package com.cslp.ken.number236;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//二叉树的最近公共祖先
public class Solution_4th {

  Map<Integer, TreeNode> parents = new HashMap();
  Set<Integer> visited = new HashSet<>();

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    dfs(root);
    while (p != null) {
      visited.add(p.val);
      p = parents.get(p.val);
    }
    while (q != null) {
      if (visited.contains(q.val)) {
        return q;
      }
      q = parents.get(q.val);
    }
    return null;
  }

  /**
   * 向上循环找到所有节点的父节点，然后加入到parents里面，hash里存放的是当前节点的key，和他的父节点
   * @param root
   */
  private void dfs(TreeNode root) {
    if (root.left != null) {
      parents.put(root.left.val, root);
      dfs(root.left);
    }
    if (root.right != null) {
      parents.put(root.right.val, root);
      dfs(root.right);
    }
  }
}

