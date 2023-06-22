import java.util.Stack;

public class P0020ValidParenthesesStack {

    public boolean isValid(String s) {
         //corner case
         if(s.length()%2 !=0){//由于括号都是成对出现pair
            return false;
        }
        Stack<Character>stack = new Stack<>();
        char[]charS = s.toCharArray();
        //s consists of parentheses only '()[]{}'. 本题目的限制条件仅包含这三种
        for(char c:charS){
            if(c=='('|| c=='[' || c=='{'){//左边括号进栈
                stack.push(c);
            }
            //if,else 只进一个，所以在else语句里要判定栈是否为空
            else{//分别列出右边括号且与出栈元素进行配对
            if(stack.isEmpty()){// 比如"))"这种情况，所有元素都不需要进栈只有右侧括号
                return false;
            }
              else if(c==')' && !stack.isEmpty()){
                  char popE = stack.pop();//出栈元素应该是与之配对的符号（
                  if(popE != '('){
                      return false;
                  }
              }
              else if(c==']' && !stack.isEmpty()){
                  char popE = stack.pop();
                  if(popE != '['){
                      return false;
                  }
              }
             else if(c =='}' && !stack.isEmpty()){
                 char popE = stack.pop();
                 if(popE != '{'){
                     return false;
                 }
             }
            }
        }
        return stack.isEmpty();//要去check stack里的元素是否已经被全部清空，如果还没有，则false
    }



    public boolean isValid1(String s){
        if(s.length() % 2 !=0){
            return false;
        }
        Stack<Character>stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }
            else if(c==')'){
                if(stack.isEmpty() || stack.peek() !='('){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
            else if(c=='}'){
                if(stack.isEmpty() || stack.peek() !='{'){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
            else if(c==']'){
                if(stack.isEmpty() || stack.peek() !='['){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
//stack是先进后出原则，所以括号的一类题目可以用栈来做，每逢左括号就进栈，每逢右括号就让进站的左括号出栈，然后跟当前的右括号进行配对
/*
 P0020ValidParenthesesStack p20 = new P0020ValidParenthesesStack();
 System.out.println(p20.isValid("))"));
 */