package com.cslp.ken.number387;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Solution {

  public int firstUniqChar(String s) {
    char[] sc = s.toCharArray();
    LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap();
    for (int i = 0; i < sc.length; i++) {
      hashMap.put(sc[i], hashMap.getOrDefault(sc[i], 0) + 1);
    }
    for (Character c : hashMap.keySet()) {
      if (hashMap.get(c) == 1) {
        return s.indexOf(c);
      }
    }
    return  -1;
  }

  public static void main(String[] args) {
    String s = "loveleetcode";
    Solution solution = new Solution();
    System.out.println(solution.firstUniqChar(s));
  }
}
