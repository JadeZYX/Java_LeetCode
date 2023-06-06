public class P762_PrimeNumberBinary {
    public int countPrimeSetBits(int left, int right) {
    int sum=0;
    for(int i=left;i<=right;i++){
        int count=hammingWeight(i);
        if(isPrime(count)){
            sum++;
        }
    }
    return sum;
} 
int hammingWeight(int n){//求汉明重量
    int count=0;
    while(n!=0){
        n&=(n-1);
        count++;
    }
    return count;
}
boolean isPrime(int n){//判断是否是质数
    if(n<=3) return n>1;
    int i=2;
    while(i<n){
        if(n%i==0){
            return false;
        }
    }
    return true;
}


    /*
    public int countPrimeSetBits(int left,int right){
        int count=0;
        for(int i=left;i<=right;i++){
          P0191_hammingdistance p191=new P0191_hammingdistance();//调用其他类下的函数 实例化
          int bits=p191.hammingWeight(i); //调用
          if(isPrime(bits)){
              count++;
          }
        }
        return count;
    }
    public boolean isPrime(int n){//判定是否是质数
        if(n<=1){//1不是质数，质数是只能被自己整除的数，如2，3，5，7，11，13，17，19，23，29，31等
            return false;
        }
        for(int i=2;i<n;i++){//看数N能否被从2到N-1之间的数整除，若可以则不是质数
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public int hamming(int n){
        int sum=0;
        while(n!=0){
            n&=(n-1);
            sum++;
        }
        return sum;
    }
    */
}
/*
       P762_PrimeNumberBinary p762=new P762_PrimeNumberBinary();
       System.out.println(p762.countPrimeSetBits(10, 15));
       System.out.println(p762.countPrimeSetBits(6, 10));
*/