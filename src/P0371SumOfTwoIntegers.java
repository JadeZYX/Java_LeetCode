public class P0371SumOfTwoIntegers {
  public int getSum(int a, int b){
    while(b != 0){//借助b来记录carry进位
      int carry = (a & b ) << 1;//进位  更新carry
      a = a ^ b;//a处理不进位的
      b = carry ;//b是进位
    }
    return a;
  }
}
/*
思路总结
a+b的问题拆分成（a和b无进位的结果）和 （a和b的进位结果）
无进位的加法使用位异或运算，因为0+1 = 1, 1+0 = 1, 0+0 = 0, 1+1 = 0 相同为0，不同为1
进位结果使用位与运算和移位运算计算得出 & <<=1因为低位变高位 比如a=1,b=1,应该求出10，其实是(a&b)<<1
循环此过程，直到进位 = 0 为止
在Java里，int类型的整数是32位的
比如 a = 5(101) b=2(10) 应该返回7（111）
           carry                  a               b
           (101 & 010)<<1 ->0    111(101 ^ 10)    0
    由于b=0跳出while 循环
比如 a = 2(10)    b = 3(11) 应该返回5（101）
          carry                      a              b
          (10 & 11)<<1 -> 100        01(10^11)     100
          (1 & 100)<<1 ->  0         101(1 ^ 100)   0
      由于b = 0， 所以退出循环 返回当前的a=101


P0371SumOfTwoIntegers p371 = new P0371SumOfTwoIntegers();
System.out.println(p371.getSum(2, 3));
*/