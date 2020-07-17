package com.cslp.ken.number049;

import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List> hashMap = new HashMap();
    List<List<String>> resultList = new ArrayList<>();
    //1. 字符串数组循环进行排序
    for (String str : strs) {
      String key = getAnagrams(str);
      if (!hashMap.containsKey(key)) {
         hashMap.put(getAnagrams(str), new ArrayList<>());
      }
      hashMap.get(key).add(str);
    }

    resultList = new ArrayList(hashMap.values());
    return resultList;
  }

  // 排序法，直接调用sort方法，复杂度nlogn
  private String getAnagrams_by_sort(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    String target = new String(chars);
    return target;
  }

  // 利用hash，复杂度n
  private String getAnagrams(String s) {
    int[] nums = new int[26];
    for (char c : s.toCharArray()) {
      nums[c - 'a']++;
    }

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      stringBuilder.append("#");
      stringBuilder.append(nums[i]);
    }

    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    args = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//    args = new String[]{"",""};
    Solution solution = new Solution();

    System.out.println(solution.groupAnagrams(args));
//    System.out.println(solution.isAnagrams("",""));
  }

}
