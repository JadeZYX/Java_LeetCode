
public class P1614MaxNestingDepthOfParentheses {
    public int maxDepth(String s){
        int dep=0;
        int count=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                count++;
                dep=Math.max(count, dep);
            }
            else if(ch==')'){
                count--;
            }
        }
        return dep;
    }
}
