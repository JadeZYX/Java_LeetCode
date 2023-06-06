public class P0680ValidPalindrome2 {
    
    public boolean validPalindrome(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            else{
                return isPalindrome(s,left+1,right)||isPalindrome(s,left,right-1);
               // return isValid(s.substring(left+1,right+1))
                //||isValid(s.substring(left,right));      
            
            }
        }
        return true;
    }
    boolean isPalindrome(String s,int left,int right){
         while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            else{
                return false;
            }
         }
        return true;
    }
}
//P0680ValidPalindrome2 p680=new P0680ValidPalindrome2();
//System.out.println(p680.validPalindrome("cbbcc"));

