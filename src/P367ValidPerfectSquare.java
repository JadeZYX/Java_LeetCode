public class P367ValidPerfectSquare {
    public boolean isPerfectSquare(int num){
        
        for(int i=1;i<=Math.sqrt(num);i++){
            if(num==i*i){
                return true;
            }
        }
        return false;
    }
    public boolean isPerfectSquare1(int num){
        
        if(num==1){
            return true;
        }
        int left=1;
       int right=num/2;
        while(left<=right){
          int mid=left+(right-left)/2;
          double product=1.0*mid*mid;
            if(product==num){
            //因为mid取到num/2,mid*mid=num*num/4,num最大到2^31-1，所以约2^30*2^30=2^60溢出，所以用long
                return true;
            }
            else if(product>num){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return false;
    }
}
