package com.cslp.ken.number001;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

  //1.暴力求解
  public int[] twoSum_violent(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (i + j == target) {
          return new int[]{i,j};
        }
      }
    }
    return null;
  }

  //2.两遍hash
  public int[] twoSum_twice_hash(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      hashMap.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      if (hashMap.containsKey(target - nums[i]) && hashMap.get(target - nums[i]) != i) {
        return new int[]{i, hashMap.get(target - nums[i])};
      }
    }
    return null;
  }

  //3.一遍Hash
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      if (hashMap.containsKey(target - nums[i])) {
        return new int[]{hashMap.get(target - nums[i]), i};
      }
      hashMap.put(nums[i], i);
    }
    return null;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1, 3, 3, 8, 4, 7};
    int[] nums = new int[]{3, 2, 4};
    int target = 6;
    int[] result = new Solution().twoSum(nums, target);
    System.out.println(Arrays.toString(result));
  }
}
