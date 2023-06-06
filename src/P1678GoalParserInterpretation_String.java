public class P1678GoalParserInterpretation_String {
    public String interpret(String command){
        StringBuilder sb=new StringBuilder(command.length());
        for(int i=0;i<command.length();++i){
            if(command.charAt(i)=='G'){
                sb.append('G');
            }
            else if(command.charAt(i)=='('&& command.charAt(i+1)==')'){
                sb.append('o');
                i=i+1;
            }
            else{//command.charAt(i)=='('&& command.charAt(i+1)=='a'
                sb.append("al");
                i=i+3;
            }
        }
        return sb.toString();
    }

    public String interpret1(String command){
        StringBuilder sb=new StringBuilder(command.length());
        for(int i=0;i<command.length();i++){
            if(command.charAt(i)=='G'){
                sb.append('G');
            }
            if(command.charAt(i)=='('){
                if(command.charAt(i+1)==')'){
                    sb.append('o');
                    ++i;
                }
                else{
                    sb.append("al");
                    i+=3;
                }
            }
        }
        return sb.toString();
    }
}
