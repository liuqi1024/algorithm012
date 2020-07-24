package com.cslp.ken.number105;

import java.util.HashMap;

//根据前序遍历和中序遍历，得到一个树
public class Solution_2nd {

  private HashMap<Integer, Integer> map = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    //1. push inorder to hashmap

    int n = inorder.length;
    for (int i = 0; i < n; i++) {
      map.put(inorder[i], i);
    }

    //2. drill down
    return  recursionBuildTree(preorder, inorder, 0, n - 1,  0, n - 1);
  }

  private TreeNode recursionBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
    //1.terminal
    if (preLeft > preRight) return null;

    //2.process
    int pIndex = map.get(preorder[preLeft]);
    TreeNode root = new TreeNode(preorder[preLeft]);

    //得到左子树的节点数目
    int size_lson = pIndex - inLeft;

    //3. drill down
    root.left = recursionBuildTree(preorder, inorder, preLeft + 1, preLeft + size_lson,
      inLeft, pIndex - 1);
    root.right = recursionBuildTree(preorder, inorder, preLeft + size_lson + 1, preRight,
      pIndex + 1, inRight);

    return root;
    //4. reverse
  }
}

