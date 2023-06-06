public class P0693_BinaryNumber {
    public boolean hasAlternatingBits0(int n){
        if(n<=0){
            return false;
        }
        String binary=Integer.toBinaryString(n);//将int类型转换成对应二进制的string类型
        for(int i=0;i<binary.length()-1;i++){
            if(binary.charAt(i)==binary.charAt(i+1)){//看相邻元素是否一致
                return false;
            }
        }
        return true;
    }
    public boolean hasAlternatingBits1(int n){
        if(n<=0){   //这道题目数字为1判定也是true
            return false;
        }
        int temp=n&1;//先求出最后一位记录为临时变量，因为如果要跟前一个比较，它是需要不断改变的
        while(n!=0){
            n>>=1;//上面求过最后一位，所以右移
            int last=n&1;
            if(temp==last){
                return false;
            }
            temp=last;//如果不同，更新temp值以变下一次与最后一位的比较
        }
        return true;
    }
    public boolean hasAlternatingBits2(int n){
        if(n<=0){
            return false;
        }
        while(n!=0){
            int popnumber=n%2;//求出末位是0还是1；
            n>>=1;
            if(popnumber==n%2){//判定不断右移后的末位是否跟前一位相同
                return false;
            } 
        }
        return true;
    }  //奇数%2为1，偶数%2为0，且n%2相当于n&1;n/2相当于n>>=1
    public boolean hasAlternatingBits(int n){
        if(n<=0){
            return false;
        }
        do{
           int last=n%2;
           n>>=1;
           if(last==n%2){ //看last值是否和位移后的n%2相同
               return false;
           }
        }
        while(n!=0);
        return true;
    }
    //do while 进循环之前就要做一些事情。
}
/*
        P0693_BinaryNumber p693=new P0693_BinaryNumber();
        System.out.println(p693.hasAlternatingBits(5));
        System.out.println(p693.hasAlternatingBits(7));
        System.out.println(p693.hasAlternatingBits(11));
        System.out.println(p693.hasAlternatingBits(10));
        System.out.println(p693.hasAlternatingBits0(1));
*/

