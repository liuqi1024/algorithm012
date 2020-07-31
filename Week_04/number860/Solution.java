package com.cslp.ken.number860;

public class Solution {
  public boolean lemonadeChange(int[] bills) {
    int five = 0, ten = 0;

    for (int i = 0; i < bills.length; i++) {
      if (bills[i] != 5 && bills[i] != 10 && bills[i] != 20) return false;

      //分开5、10、20元的情况处理，对于20元面值，能找10元的不找两个5元的。
      if (bills[i] == 5) {
        five++;
      } else if (bills[i] == 10) {
        if (five == 0) return false;
        five--;
        ten++;
      } else {
        if (five > 0 && ten > 0) {
          five--;
          ten--;
        } else if (five >= 3) {
          five -= 3;
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
