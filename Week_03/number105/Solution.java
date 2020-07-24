package com.cslp.ken.number105;

import java.util.HashMap;

public class Solution {

  private HashMap<Integer, Integer> map = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    //1. push inorder to hashmap
    int n = preorder.length;

    for (int i = 0; i < n; i++) {
      map.put(inorder[i], i);
    }

    //2. drill down
    return  recursionBuildTree(preorder, inorder, 0, n - 1,  0, n - 1);
  }

  private TreeNode recursionBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
    //1.terminal
    if (preLeft > preRight) {
      return null;
    }

    //2.process
    int inRoot = map.get(preorder[preLeft]);
    TreeNode root = new TreeNode(preorder[preLeft]);

    //得到左子树的节点数目
    int size_left_subtree = inRoot - inLeft;

    //3. drill down
    root.left = recursionBuildTree(preorder, inorder, preLeft + 1, preLeft + size_left_subtree,
      inLeft, inRoot - 1);

    root.right = recursionBuildTree(preorder, inorder, preLeft + size_left_subtree + 1, preRight,
      inRoot + 1, inRight);

    return root;

    //4. reverse

  }


}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
