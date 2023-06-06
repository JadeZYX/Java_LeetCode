import java.util.Stack;

public class P0917ReverseOnlyLetters {
    public String reverseOnlyLetters(String s){
        Stack<Character> letters=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){//把所有的字母添加到栈里
            if(Character.isLetter(c)){
                letters.push(c);
            }
        }
        for(char c:s.toCharArray()){
            if(Character.isLetter(c)){
                sb.append(letters.pop());
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String reverseOnlyLetters0(String s) {// O(n)+S(N)
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        char[] s_array = s.toCharArray();
        while (leftPointer <= rightPointer) {
            if (Character.isLetter(s_array[leftPointer]) && Character.isLetter(s_array[rightPointer])) {
                char temp = s_array[leftPointer];
                s_array[leftPointer] = s_array[rightPointer];
                s_array[rightPointer] = temp;
                leftPointer++;
                rightPointer--;
            } else if (!Character.isLetter(s_array[leftPointer])) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return String.valueOf(s_array);
    }
}
//P0917ReverseOnlyLetters p917=new P0917ReverseOnlyLetters();
//System.out.println(p917.reverseOnlyLetters( "Test1ng-Leet=code-Q!"));
