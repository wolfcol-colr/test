import java.util.Scanner;

public class Solution {

//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    int total = 300;
//    while (scanner.hasNext()) {
//      String str = scanner.nextLine();
//      String[] num = str.split(",", 3);
//      int price = Integer.parseInt(num[0]);
//      int expect = Integer.parseInt(num[1]);
//      int value = Integer.parseInt(num[2]);
//      if (total < price) {
//        continue;
//      }
//      total -= cost(price, expect, value);
//    }
//    System.out.println(total);
//  }
//
//  public static int cost(int price, int expect, int value) {
//    int cost;
//    int beyond = value > expect ? value - expect : 0;
//    if (price < 50) {
//      cost = value;
//    } else if (price >= 100) {
//      if (value > 15) {
//        cost = 15 * 5 + (value - 15) * 3;
//      } else {
//        cost = value * 5;
//      }
//    } else {
//      if (value > 15) {
//        cost = 15 * 3 + value - 15;
//      } else {
//        cost = value * 3;
//      }
//    }
//    return cost + beyond > price ? price : cost + beyond;
//  }
}
