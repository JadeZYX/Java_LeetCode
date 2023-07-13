public class P0415AddStrings {
  public String addStrings(String num1, String num2) {
    String res = "";
    int index1 = num1.length() - 1;
    int index2 = num2.length() - 1;
    int carry = 0;// 进位
    while (index1 >= 0 || index2 >= 0) {// 只要满足其一即可，不满足的index也就是越界，则取0
      int num1Last = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
      int num2Last = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
      int tempSum = num1Last + num2Last + carry;
      carry = tempSum / 10;
      int remain = tempSum % 10;
      res = String.valueOf(remain) + res;
      index1--;
      index2--;
    }
    if (carry == 1)
      res = String.valueOf(carry) + res;
    return res;
  }
}
/*
 * 从字符串的末尾开始，逐位添加。得出来的和/10作为进位，得出来的和%10也就是余数要添加到结果里。
 * "456" "77" carry = 0 res = ""
 * index1 index2 tempSum carry remain res
 * 2 1 13(6+7+0) 1(13/10) 3(13%10) "3"
 * 1 0 13(5+7+1) 1 3 "33"
 * 0 -1 5(4+0+1) 0(5/10) 5(5%10) "533"
 *
 *      P0415AddStrings p415 = new P0415AddStrings();
        System.out.println(p415.addStrings("11", "123"));
 */