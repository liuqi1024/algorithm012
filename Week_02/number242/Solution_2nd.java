package com.cslp.ken.number242;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_2nd {

  //1. 暴力求解
  public boolean isAnagram_violence(String s, String t) {
    char[] char1 = s.toCharArray();
    char[] char2 = t.toCharArray();
    Arrays.sort(char1);
    Arrays.sort(char2);
    return Arrays.equals(char1, char2);
  }

  //2. hashmap,小写字母范围
  public boolean isAnagram_atoz(String s, String t) {
    if (s.length() != t.length()) return false;

    char[] counter = new char[26];
    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a']++;
      counter[t.charAt(i) - 'a']--;
    }

    for (int i : counter) {
      if (i != 0) return false;
    }

    return true;
  }

  //3. hashmap,不局限于小写字母的
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    HashMap<Character, Integer> hashMap = new HashMap();

    for (char c : s.toCharArray()) {
      int v = hashMap.get(c) == null ? 0 : hashMap.get(c);
      hashMap.put(c, ++v);
    }

    for (char c : t.toCharArray()) {
      if (!hashMap.containsKey(c)) return false;
      int v = hashMap.get(c);
      hashMap.put(c, --v);
    }

    for (int value : hashMap.values()) {
      if (value != 0) return false;
    }
    return true;
  }
  /**
   * TODO:
   * 1.如何对一个字符串进行排序
   * 2.
   * @param args
   */
  public static void main(String[] args) {
    String first = "abca";
    String two = "bcaa";
    System.out.println(new Solution_2nd().isAnagram_violence(first, two));
    System.out.println(new Solution_2nd().isAnagram(first, two));
  }

}
