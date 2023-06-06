import java.util.HashSet;

public class P202_happyNumber {
    public boolean isHappy(int n){
        HashSet<Integer> sites=new HashSet<Integer>();//区别于hashmap
        while(n>0){
            if(n==1){
                return true;
            }
            int sum=0;
            while(n!=0){ //不断的取余数的过程，当n/10==0终止
                int i=n%10;
                n/=10;
                sum=sum+i*i;//求和
            }
            n=sum;//把求出的数赋值给n，判定是否存在，是否需要继续循环
            if(sites.contains(n)){
                return false;
            }
            else{
                sites.add(n);
            }
        }
        return false;//默认
    }
}
/*
        P202_happyNumber p202=new P202_happyNumber();
        System.out.println(p202.isHappy(19));
        System.out.println(p202.isHappy(2));
*/