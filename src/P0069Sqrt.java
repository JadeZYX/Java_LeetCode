public class P0069Sqrt {
    public int mySqrt(int x){
        if(x<=1)return x;
        int left=1;
        int right=x;
        int res=-1;
        while(left<right){
            int mid=left+(right-left)/2;
            double product=1.0*mid*mid;
            if(product==x){
                return mid;
            }
            else if(product>x){
                right=mid;
            }
            else{
                res=mid;//记录当前接近答案的值
                left=mid+1;
            }
        }
        return res;
    }
    public int mySqrt1(int x){//bf
        if(x<=1)return x;
        if(x==2)return 1;
      int i=1;
      while(i<x){
          double product=1.0*i*i;
          if(product==x){
              return i;
          }
          else if(product>x){
              return i-1;
          }
          i++;
      }
      return 1;
  }
  public int mySqrt2(int x) {
      if(x==0)return 0;
      int res=1;
      for(int i=1;i<x;i++){
          double product=1.0*i*i;
          if(product<=x){
              res=i;
          }
          else{
              break;
          }
       }
       return res;
   } 
}
//P0069Sqrt p69=new P0069Sqrt();
//System.out.println(p69.mySqrt(2147483646));
