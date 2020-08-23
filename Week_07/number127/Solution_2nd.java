package com.cslp.ken.number127;

import java.util.*;

public class Solution_2nd {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordset = new HashSet<>(wordList);
    if (wordset.size() == 0 || !wordset.contains(endWord)) {
      return 0;
    }
    //总的 visited 数组
    Set<String> visited = new HashSet();
    Set<String> beginVisited = new HashSet();
    beginVisited.add(beginWord);

    Set<String> endVisited = new HashSet<>();
    endVisited.add(endWord);

    int len = beginWord.length();
    int step = 1;

    while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
      System.out.println("beginviseted => " + beginVisited);
      System.out.println("end viseted => " + endVisited + "\n");

      // 优先选择小的哈希表进行扩散
      if (beginVisited.size() > endVisited.size()) {
        Set<String> temp = beginVisited;
        beginVisited = endVisited;
        endVisited = temp;
      }

      // nextLevelVisited 在扩散完成以后，会成为新的 beginVisited
      Set<String> nextLevelVisited = new HashSet<>();
      for (String word : beginVisited) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < len; i++) {
          char orginChar = charArray[i];
          for (char c = 'a'; c <= 'z'; c++) {
            if (orginChar == c) continue;
            charArray[i] = c;
            String nextWord = String.valueOf(charArray);
            if (wordset.contains(nextWord)) {
              if (endVisited.contains(nextWord)) {
                return step + 1;
              }

              if (!visited.contains(nextWord)) {
                nextLevelVisited.add(nextWord);
                visited.add(nextWord);
              }
            }
          }
          // 恢复，下次再用
          charArray[i] = orginChar;
        }
      }
      beginVisited = nextLevelVisited;
      step++;
    }
    return 0;
  }

  public static void main(String[] args) {
    String beginWord = "ymain";
    String endWord = "oecij";
    List<String> wordList = new ArrayList<>();
//    String[] wordListArray = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
    String[] wordListArray = new String[]{"ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"};

    Collections.addAll(wordList, wordListArray);
    Solution_2nd solution = new Solution_2nd();
    int res = solution.ladderLength(beginWord, endWord, wordList);
    System.out.println(res);
    System.out.println(String.format("从 %s 到 %s 的最短转换序列的长度：%d。", beginWord, endWord, res));
  }
}
