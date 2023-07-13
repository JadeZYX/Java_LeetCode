public class P0067AddBinary {
  //这道题目与415题 add strings类似，一个是针对二进制，一个是针对十进制 /，%
  public String addBinary0(String a, String b){
    String res = "";
    int index_a = a.length()-1;
    int index_b = b.length()-1;
    int carry = 0;//进位初始值
    while(index_a>=0 || index_b>=0){
      int aNum = index_a>=0? a.charAt(index_a)-'0':0;
      //如果index没有out of boundary,则取对应位置上的字符，然后转成int类型，否则取0
      int bNum = index_b>=0?b.charAt(index_b)-'0':0;
      int tempSum = aNum + bNum + carry;
      carry = tempSum/2;
      int remain = tempSum % 2;
      res = String.valueOf(remain)+res;
      index_a--;
      index_b--;
    }
    if(carry ==1) res = String.valueOf(carry)+res;
    return res;
  }

  public String addBinary(String a, String b){//StringBuilder的效率会更高
    StringBuilder sb = new StringBuilder();
    int i = a.length()-1;
    int j = b.length()-1;
    int carry = 0;
    while(i>=0 || j>=0){
      int numA = i>=0?a.charAt(i)-'0':0;
      int numB = j>=0?b.charAt(j)-'0':0;
      int sum = numA + numB + carry;
      carry = sum /2;
      int remain = sum % 2;
      sb.append(remain);
      i--;
      j--;
    }
    if(carry ==1) sb.append(carry);
    return sb.reverse().toString();
  }

}
/*

P0067AddBinary p67 = new P0067AddBinary();
System.out.println(p67.addBinary("11", "1"));
System.out.println(p67.addBinary("1010", "1011"));
 */
