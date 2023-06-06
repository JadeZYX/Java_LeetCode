public class P0342PowerOfFour {
    public boolean isPowerOfFour(int n){
        if(n<=0) return false;
        int m=(int)Math.sqrt(n);
        if(m*m!=n){
           return false; 
        }
        else{
            return (m&(m-1))==0;
        }
    }

    public boolean isPowerOfFour0(int n){
        if(n<=0)return false;
        while(n>=4){
            if(n%4!=0){
                return false;
            }
            n/=4;
        }
        return n==1;
    }
    public boolean isPowerOfFour2(int n) {//recuision
        if(n==1)return true;
        if(n<=0)return false;
        if(n%4!=0)return false;
        return isPowerOfFour(n/4);
    }
}
