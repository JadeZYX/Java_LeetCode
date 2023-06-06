public class P0258_AddDigits_Math {
    public int addDigits(int num){//递归recursion
        if(num<=9) return num;
        int sum=0;
        while(num>0){
            sum=sum+(num%10);
            num/=10;
        }
        return addDigits(sum);
    }
}
/*
        P0258_AddDigits_Math p258=new P0258_AddDigits_Math();
        System.out.println(p258.addDigits(38));
        System.out.println(p258.addDigits(0));
        System.out.println(p258.addDigits(9));
*/