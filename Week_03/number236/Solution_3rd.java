package com.cslp.ken.number236;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//二叉树的最近公共祖先
public class Solution_3rd {

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

  private void dfs(TreeNode root) {
    //1.terminal
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

