public class P0058LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[]s_arr=s.split(" ");
        String word=s_arr[s_arr.length-1];
        return word.length();
    }
    public int lengthOfLastWord1(String s){//从后往前找 最优解
        int i=s.length()-1;
        while(s.charAt(i)==' '){
           i--;
        }
        int len=0;
        while(i>=0&&s.charAt(i)!=' '){
           len++;
           i--;
        }
        return len;
    }
}
