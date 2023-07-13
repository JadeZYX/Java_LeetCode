public class P0191_hammingdistance {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) { // while(n)typescript
            int last = n & 1;
            if (last == 1) {
                sum++;
            }
            n >>>= 1;
        }
        return sum;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        while(n !=0){
            n=n&(n-1);//先进行操作，消耗掉一个1，在对count进行更新
            count++;
        }
        return count;
    }
    /**因为每次n-1都会消耗掉一个1，所以把N从N变成0需要进行几次N-1的操作，每进行一次count+1
 */
}
