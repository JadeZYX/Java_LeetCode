import java.util.Stack;

public class P0020ValidParenthesesStack {
    public boolean isValid(String s){
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
               st.push(c);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char ch=st.pop();
                if(c==')'){
                    if(ch!='(') {
                        return false;
                    }
                }
                else if(c=='}'){
                    if(ch!='{'){
                        return false;
                    }
                }
                else{
                    if(ch!='['){
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();
    }
}
//stack是先进后出原则，所以括号的一类题目可以用栈来做，每逢左括号就进栈，每逢右括号就让进站的左括号出栈，然后跟当前的右括号进行配对
