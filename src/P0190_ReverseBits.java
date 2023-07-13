public class P0190_ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0;i<32;i++){//不能用while loop!=0,因为如果是负数，高位会一直补1，永远不会是0
            int last = n&1;//全1才为1
            res<<=1;//一定要在位或操作前左移动，如果先与last位或后再移动，则得到的res最后一位是0
            res=res|last;//不能用rev=rev+last因为如果是负数，就会改变值。但是用位或运算，直接给赋值0或者是1
           n >>>= 1;//不补0
        }
        return res;
    }
}
//P0190_ReverseBits p = new P0190_ReverseBits();
//System.out.println(p.reverseBits(0B00000010100101000001111010011100));
/*对于原数N的操作应该用&求出最后一位，再向右移动，使原来的高位不断的变成低位
对于结果应该是左移动，使原数里不断得出的低位不断左移动变成高位,使用｜运算
*/