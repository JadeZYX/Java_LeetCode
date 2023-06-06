import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P0022GenerateParentheses_Recursion {
    ArrayList<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        helper(n, "", 0);
        return list;
    }
//count 是左括号的相对值，左括号-右括号的结果 所以当count小于0肯定不能配对
    public void helper(int n, String s, int count) {
        if (count < 0) {
            return;
        }
        if (s.length() == 2 * n) {
            if (count == 0) {
                list.add(s);
            }
            return;
        }
        helper(n, s + "(", count + 1);
        helper(n, s + ")", count - 1);
    }

    public boolean isValid(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    public boolean isValid1(String s) {
        Stack<Character> res = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                res.push(ch);
            } else {
                if (res.isEmpty()) {
                    return false;
                }
                res.pop();
            }
        }
        return res.isEmpty();
    }
}
