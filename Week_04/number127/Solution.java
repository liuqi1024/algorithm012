package com.cslp.ken.number127;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    /**
     * 1. 创建一个空队列，并且把beginword加进去
     * 2. 枚举beginword可能的变种单词，并且跟wordlist做比较，如果存在，就放在wordset里，同时也放在queue里
     * 3. 循环遍历这个queue，如果wordlist跟endword比较，相同，就退出。如果不相同，遍历一层后，step+1
     * 4. 直到queue为空，再退出
     */
    Set<String> wordSet = new HashSet<>(wordList);
    if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
      return 0;
    }
    wordSet.remove(beginWord);

    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    int wordLen = beginWord.length();
    int step = 1;

    while (!queue.isEmpty()) {
     int currentSize = queue.size();
      for (int i = 0; i < currentSize; i++) {
         String word = queue.poll();
         char[] charArray = word.toCharArray();

        for (int j = 0; j < wordLen; j++) {
           char orginChar = charArray[j];

          for (char k = 'a'; k <= 'z'; k++) {
            if (k == orginChar) {
              continue;
            }
            charArray[j] = k;
            String nextWord = String.valueOf(charArray);
            if (wordSet.contains(nextWord)) {
              if (nextWord.equals(endWord)) {
                return step + 1;
              }

              if (!visited.contains(nextWord)) {
                queue.add(nextWord);
                visited.add(nextWord);
              }
            }
          }
          charArray[j] = orginChar;
        }
      }
      step ++;
    }
    return 0;
  }

  public static void main(String[] args) {
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = new ArrayList<>();
    String[] wordListArray = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
    Collections.addAll(wordList, wordListArray);
    Solution solution = new Solution();
    int res = solution.ladderLength(beginWord, endWord, wordList);
    System.out.println(res);
  }
}
