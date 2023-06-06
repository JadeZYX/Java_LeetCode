public class P0125ValidPalindrome {

    public boolean isPalindrome0(String s) {
        if(s=="")return true;
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        String t=Palindrome(sb.toString());
        return sb.toString().equals(t);

    }
    public String Palindrome(String s){
        String res="";
        for(int i=s.length()-1;i>=0;i--){
            res+=s.charAt(i);
        }
        return res;
    }
    public boolean isPalindrome(String s) {//双向指针
        s=s.toLowerCase();
        int left=0;
        int right=s.length()-1;
        while(left<right){//不能只写成left！=right，因为如果是双数，取不到
           char charl=s.charAt(left);
           char charr=s.charAt(right);
           if(Character.isLetterOrDigit(charl)&& Character.isLetterOrDigit(charr)){
               // charl=Character.toLowerCase(charl);
                //charr=Character.toLowerCase(charr);
                if(charl!=charr){
                    return false;
                }
                left++;
                right--;
           }
           else if(Character.isLetterOrDigit(charl)){
               right--;
           }
           else if(Character.isLetterOrDigit(charr)){
               left++;
           }
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        String t=sb.toString();
        StringBuilder sb1=new StringBuilder(t);
        String palindrome=sb1.reverse().toString();
        return palindrome.equals(sb.toString());
    }

    public boolean isPalindrome3(String s){
        if(s.length()==1){
            return true;
        }
        s=s.toLowerCase();
        int leftP = 0;
        int rightP = s.length()-1;
        while(leftP < rightP){
            char leftchar = s.charAt(leftP);
            char rightchar = s.charAt(rightP);
            while(!Character.isLetterOrDigit(leftchar)&& leftP < rightP){
                leftP++;
                leftchar = s.charAt(leftP);
            }
            while(!Character.isLetterOrDigit(rightchar) && leftP < rightP){
                rightP--;
                rightchar = s.charAt(rightP);
            }
            if(leftchar != rightchar){
                return false;
            }
            leftP++;
            rightP--;
        }
        return true;
    }
}
/*
P0125ValidPalindrome p125=new P0125ValidPalindrome();
System.out.println(p125.isPalindrome("A man, a plan, a canal: Panama"));
System.out.println(p125.isPalindrome3(".,"));
*/