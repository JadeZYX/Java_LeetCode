public class P0009PalindromeNumber {
    public boolean isPalindrome(int x){
        if(x<0)return false;
        if(x==0)return true;
        int res=0;
        int y=x;
        while(y!=0){
            int remain=y%10;
            res=res*10+remain;
            y/=10;
        }
        return res==x;
    }
    public boolean isPalindrome1(int x) {
        if(x<0)return false;
        int y=palindrome(x);
         return x==y;
     }
     int palindrome(int x){
         int res=0;
         while(x!=0){
             int remain=x%10;
             res=res*10+remain;
             x/=10;
         }
         return res;
     }
     /*
     P0009PalindromeNumber p9=new P0009PalindromeNumber();
     System.out.println(p9.isPalindrome(121));
     */
}
