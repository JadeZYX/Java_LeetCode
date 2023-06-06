public class P0326PowerOfThree {
    
    public boolean isPowerOfThree1(int n) {//除法取余思想
        while(n>=3){
          if(n%3==0){
              n/=3;
          } 
            else{
                return false;
            }
         }
        return n==1;
    }
    public boolean isPowerOfThree2(int n) {
        if(n == 1) return true;//第一行和第二行顺序不能换
        if(n % 3 != 0 || n == 0) return false;
        return isPowerOfThree2(n/3);
    }
    
}
