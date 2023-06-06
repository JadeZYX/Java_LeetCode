public class P0007 {
    public int reverse(int x) { // x = 421   O(logN)+O(1)
        double Max = Math.pow(2, 31) - 1;  // 123
        double Min = -Math.pow(2, 31);     // -124
        //int Max = Integer.MAX_VALUE;
        //int Min = Integer.MIN_VALUE; 
        int res = 0; // 0 -> 1 -> 12 -> overflow
        while (x != 0) {   // x = 4
            int remain = x % 10;  // 4 
            if (res > Max / 10 || (res == Max / 10 && remain > Max % 10)) {
                return 0;
            }
            if (res < Min / 10 || (res == Min / 10 && remain < Min % 10)) {
                return 0;
            }
            
            res = res * 10 + remain; // 12 * 10 + 4 = 124 > 123
            x /= 10;
        }

        return res;
    }
    public int reverse1(int x){
         int res=0;
         while(x!=0){
             int remain=x%10;
             int newRes=res*10+remain;//假设一个新的数来试探是否越界
             if(newRes/10!=res){
                 return 0;
             }
             res=newRes;
             x/=10;
         }
         return res;
    }
}
//两个if语句提前判定下一步的倒转数是否有溢出的可能性，如果没有则继续*10+余数
//         P0007 p7=new P0007();
//         System.out.println(p7.reverse(123));
//         System.out.println(p7.reverse(-123));
//         System.out.println(p7.reverse(120));
//         System.out.println(p7.reverse(0));