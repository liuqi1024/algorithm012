package com.cslp.ken.number208;

public class Trie {
  private TrieNode root;
  /**
   * Initialize your data structure here.
   */
  public Trie() {
    root = new TrieNode();
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      //1. 把i变成char对象
      char currentChar = word.charAt(i);
      //2. 判断是否存在于当前的node中
      if (!node.containsKey(currentChar)) {
        node.put(currentChar, new TrieNode());
      }
      //3. 重新获得node对象
      node = node.get(currentChar);
    }
    //4. 设置结尾
    node.setEnd();
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    TrieNode node = searchPrefix(prefix);
    return node != null;
  }

  private TrieNode searchPrefix(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char currentChar = word.charAt(i);
      if (node.containsKey(currentChar)) {
        node = node.get(currentChar);
      } else {
        return null;
      }
    }
    return node;
  }

  public static void main(String[] args) {
    char c = 'a';
    System.out.println(c - 'a');
  }

}

class TrieNode {

  // R links to node children
  private TrieNode[] links;

  private final int R = 26;

  private boolean isEnd;

  public TrieNode() {
    links = new TrieNode[R];
  }

  public boolean containsKey(char ch) {
    return links[ch - 'a'] != null;
  }

  public TrieNode get(char ch) {
    return links[ch - 'a'];
  }

  public void put(char ch, TrieNode node) {
    links[ch - 'a'] = node;
  }

  public void setEnd() {
    isEnd = true;
  }

  public boolean isEnd() {
    return isEnd;
  }
}
