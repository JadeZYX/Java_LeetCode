public class P0190_ReverseBits {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 1; i <= 32; i++) {//不能用while loop!=0,因为如果是负数，高位会一直补1，永远不会是0
            rev <<= 1;//进入循环要先将rev左移，如果在循环结尾左移，则相当于将最后一位变成了0
            int last = n & 1;
            rev = rev | last;//不能用rev=rev+last因为如果是负数，就会改变值。但是用位或运算，直接给赋值0或者是1
            n >>>= 1;
        }
        return rev;
    }
}
//P0190_ReverseBits p = new P0190_ReverseBits();
//System.out.println(p.reverseBits(0B00000010100101000001111010011100));
