package com.cslp.ken.number026;

import java.util.Arrays;

//删除排序数组的重复项
public class Solution {
  public static int removeDuplicates(int[] nums) {
    int j = 0;
    for(int i = 1; i < nums.length; i++) {
      if (nums == null || nums.length == 0)  {
        return 0;
      }
      if (nums[j] != nums[i]) {
        j++;
        if (i - j > 1) {
          nums[j] = nums[i];
        }
      }
    }
    return j + 1;
  }

  public static void main(String[] args) {
    int[][] nums = new int[4][];
    nums[0] = new int[]{1, 2, 2, 2, 4, 5};
    nums[1] = new int[]{0, 0, 0, 6, 6, 8, 8};
    nums[2] = new int[]{0};
    nums[3] = new int[]{1, 2, 3, 4};
    for (int i = 0; i < nums.length; i++) {
      System.out.println(Arrays.toString(nums[i]));
      System.out.println("length = " + removeDuplicates(nums[i]));
    }
  }

}
