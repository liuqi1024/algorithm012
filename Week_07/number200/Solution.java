package com.cslp.ken.number200;

public class Solution {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int rows = grid.length;
    int cols = grid[0].length;
    int result = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '1') {
          result++;
          dfs(grid, i, j);
        }
      }
    }
    return result;
  }

  private void dfs(char[][] grid, int r, int c) {
    int rows = grid.length;
    int cols = grid[0].length;

    if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
      return;
    }
    //凡是符合递归条件的全部置为'0'，而且不用恢复
    grid[r][c] = '0';
    //上 右 下 左 递归
    dfs(grid, r - 1, c);
    dfs(grid, r, c + 1);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
  }
}
