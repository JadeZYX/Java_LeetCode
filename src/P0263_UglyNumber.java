public class P0263_UglyNumber {
    public boolean isUgly(int n){
        if(n<=0){
            return false;
        }
        int[] primfactors=new int[]{2,3,5};
        for(int divide:primfactors){
            while(n%divide==0){
                n/=divide;
            }  
        }
        return n==1;
    }
    public boolean isUgly1(int n){  //递归
        if(n<=0) {return false;}
        if(n==1){return true;}
        if(n%2==0){
            return isUgly1(n/=2);
        }
        if(n%3==0){
            return isUgly1(n/=3);
        }
        if(n%5==0){
            return isUgly1(n/=5);
        }
        return false;
    }
    public boolean isUgly2(int n){
        if(n<=0) return false;
        if(n==1) return true;
        while(n%2==0) n/=2;
        while(n%3==0) n/=3;
        while(n%5==0) n/=5;
        return n==1;
    }
}
/*
        P0263_UglyNumber p263 = new P0263_UglyNumber();
        System.out.println(p263.isUgly(6));
        System.out.println(p263.isUgly1(8));
        System.out.println(p263.isUgly1(14));
        System.out.println(p263.isUgly(1));
        System.out.println(p263.isUgly(0));//0不是正整数，所以不是丑数
        System.out.println(p263.isUgly2(20));
*/
