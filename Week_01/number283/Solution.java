package com.cslp.ken.number283;

import java.util.Arrays;

//移动零
public class Solution {
  //最优解，双指针，遇到0就交换
  public static int[] moveZeroes(int[] nums) {
    int j = 0;
    for(int i = 0; i < nums.length; i++) {
      if (nums == null) return null;
      if (nums[i] != 0) {
        if (i > j) {
          nums[j] = nums[i];
          nums[i] = 0;
        }
        j++;
      }
    }
    return nums;
  }

  //两次循环，第一次移动非0数字，第二次把后面的位数改为0
  public static int[] moveZeroes_twice_for(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if(nums[i] != 0) {
        nums[j] = nums[i];
        j++;
      }
    }
    for (int i = j; i < nums.length; i++) {
      nums[i] = 0;
    }
    return nums;
  }

  public static void main(String[] args) {
    int[][] nums = new int[4][];
    nums[0] = new int[]{8, 0, 1, 0, 6, 0};
    nums[1] = new int[]{0, 0, 0, 6, 6, 8, 1};
    nums[2] = new int[]{0};
    nums[3] = new int[]{4, 2, 3, 1};
    for (int i = 0; i < nums.length; i++) {
      System.out.println(Arrays.toString(nums[i]));
      System.out.println(Arrays.toString(moveZeroes(nums[i])));
//      System.out.println(Arrays.toString(moveZeroes_twice_for(nums[i])));
    }
  }
}
