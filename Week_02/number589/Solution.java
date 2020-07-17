package com.cslp.ken.number589;

import java.util.ArrayList;
import java.util.List;

//前序遍历N叉树
public class Solution {

  private List<Integer> list = new ArrayList();

  public List<Integer> preorder(Node root) {
    dfs(root);
    return list;
  }

  private void dfs(Node root) {
    if (root == null) return;
    list.add(root.val);
    for (Node child : root.children) {
      dfs(child);
    }
  }

  public static void main(String[] args) {

  }
}

class Node {
  public int val;
  public List<Node> children;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
};

//class Solution {
//  public List<Integer> preorder(Node root) {
//    List<Integer> res  =  new ArrayList<Integer>();
//    if(root == null) return res;
//    res.add(root.val);
//    for(Node cur:root.children){
//      res.addAll(preorder(cur));
//    }
//    return res;
//  }
//}
