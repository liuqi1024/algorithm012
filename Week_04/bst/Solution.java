package com.cslp.ken.sample.bst;

/**
 * 用二分法查找值等于给定值的索引
 * 循环数组特性：以数组中间点为分区，会将数组分成一个有序数组和一个循环有序数组
 * 判断下面要搜索左半段还是右半段，如果中间的数小于最右边的数，则右半段是有序的，
 * 若中间数大于最右边数，则左半段是有序的，我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，
 * 这样就可以确定保留哪半边了
 * 时间复杂度为 O(logN)
 *
 * @param data  循环有序数组，例如 [4，5，6，1，2，3]
 * @param value
 * @return
 */
public class Solution {
  public int loopFirstEqualSqrt(int[] data, int value) {
    int low = 0;
    int high = data.length - 1;

    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (data[mid] == value) return mid;
      // 如果中间元素小于尾元素，说明后半部分是有序的，前半部分是循环有序数组
      if (data[mid] < data[high]) {
        // 如果目标元素在有序数组范围中，使用二分查找
        if (data[mid] < value && data[high] >= value)
          low = mid + 1;
        else
          high = mid - 1;
      } else { // 如果中间元素大于尾元素，说明前半部分是有序的，后半部分是循环有序数组
        if (data[low] <= value && data[mid] > value)
          high = mid - 1;
        else
          low = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] a = new int[]{4, 5, 6, 7, 0, 1, 2};
    Solution solution = new Solution();
    System.out.println(solution.loopFirstEqualSqrt(a, 6));
  }
}
