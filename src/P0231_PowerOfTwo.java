public class P0231_PowerOfTwo {
    public boolean isPowerOfTwo2(int n) {
        if(n<=0)return false;
        return (n&(n-1))==0;
    }

    public boolean isPowerOfTwo0(int n){  //求汉明距离
        int sum=0;
        while(n>0){
            n&=(n-1);
            sum++;
        }
        if(sum==1){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isPowerOfTwo(int n){ //减1+位与运算，看结果是否为0
            if(n<=0)return false;
            if(n==1)return true;
            if(n%2!=0)return false;
            return isPowerOfTwo(n/2);
    }

}
//这道题要注意循环条件 当n<=0的时候是false 因为如果是负数，则不止一个1，至少符号位也是1.