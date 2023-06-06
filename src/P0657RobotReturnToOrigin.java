public class P0657RobotReturnToOrigin {
    public boolean judgeCircle(String moves){
        int leftright=0,updown=0;
        for(int i=0;i<moves.length();++i){
            if(moves.charAt(i)=='U'){
                updown++;
            }
            else if(moves.charAt(i)=='D'){
                updown--;
            }
            else if(moves.charAt(i)=='L'){
                leftright++;
            }
            else{
                leftright--;
            }
        }
        return leftright==0 && updown==0;
    }//学会利用（0，0）这个提示
}
       //P0657RobotReturnToOrigin p657=new P0657RobotReturnToOrigin();
       //System.out.println(p657.judgeCircle("LL"));
