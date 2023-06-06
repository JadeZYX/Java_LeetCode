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

    public int hammingWeight1(int n){
        int sum=0;
        while(n!=0){
           int m=n&(n-1);//n&=(n-1)
           n=m;
           sum++;
        }
        return sum;
    }
}
