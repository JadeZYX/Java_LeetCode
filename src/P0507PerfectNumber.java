
public class P0507PerfectNumber {
    public boolean checkPerfectNumber(int num){
        if(num<=1){ //1的非自身正因子一个都没有，所以是false
            return false;
        }
        int sum=1;//正整数的正因子一定包含1，但题目说不包含数本身，所以单独处理
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                sum+=i;
                if(num/i!=i){//比如9&3=3，这里两个3，但只需要加一个3，所以单独处理
                    sum+=(num/i);
                }
            }
        }
        return sum==num;
    }
}
/* 通过遍历前一半的数字拿到后一半的数字，且sum+=i，看和是否与原数相同
      P0507PerfectNumber p507=new P0507PerfectNumber();
      System.out.println(p507.checkPerfectNumber(28));
      System.out.println(p507.checkPerfectNumber(2));
      System.out.println(p507.checkPerfectNumber(496));
      System.out.println(p507.checkPerfectNumber(9));

*/
