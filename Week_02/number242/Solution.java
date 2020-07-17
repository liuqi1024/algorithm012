package com.cslp.ken.number242;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Solution {

  //1. 暴力求解
  public boolean isAnagram_violence(String s, String t) {
    String[] array_first = s.split("");
    Arrays.sort(array_first);
    String first = String.join("", array_first);

    String[] array_two = t.split("");
    Arrays.sort(array_two);
    String two = String.join("", array_two);

    return first.equals(two);
  }

  //2. hashmap,不局限于小写字母的
  public boolean isAnagram(String s, String t) {
    HashMap<String, Integer> hashMap = new HashMap();
    String[] array_first = s.split("");
    String[] array_two = t.split("");
    int size = 0;
    for (int i = 0; i < array_first.length; i++) {
      if (!hashMap.containsKey(array_first[i])) {
        hashMap.put(array_first[i], 1);
      } else {
        hashMap.put(array_first[i], hashMap.get(array_first[i]) + 1);
      }
    }
    for (int i = 0; i < array_two.length; i++) {
      if (!hashMap.containsKey(array_two[i])) {
        return false;
      } else {
        hashMap.put(array_two[i], hashMap.get(array_two[i]) - 1);
      }
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
    String first = "aacc";
    String two = "ccac";
    System.out.println(new Solution().isAnagram(first, two));
  }

}
