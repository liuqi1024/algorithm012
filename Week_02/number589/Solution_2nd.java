package com.cslp.ken.number589;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//前序遍历N叉树
public class Solution_2nd {

  //1. 递归法
  public List<Integer> preorder_recursion(Node root) {
    if (root == null) return null;
    LinkedList<Integer> linkedList = new LinkedList();
    linkedList.add(root.val);
    for (Node node : root.children) {
      linkedList.addAll(preorder_recursion(node));
    }
    return linkedList;
  }


  //2. 栈
  public List<Integer> preorder(Node root) {
    LinkedList<Node> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) return output;
    //根节点入栈
    stack.add(root);

    while (!stack.isEmpty()) {
      //弹出栈顶，并且放置到输出的数组里
      Node node = stack.pollLast();
      output.add(node.val);

      Collections.reverse(node.children);
      //子节点入栈
      for (Node item : node.children) {
        stack.add(item);
      }
    }
    return output;
  }

  public static void main(String[] args) {

  }
}



