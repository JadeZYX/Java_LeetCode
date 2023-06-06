import java.util.ArrayList;
import java.util.List;

public class P0728SelfDividingNumbers { 
    public List<Integer> selfDividingNumber(int left,int right){
        ArrayList<Integer> res=new ArrayList<>();//空间复杂度O(D)使用数组存放结果
        if(left<=0||right<=0){
            return res;
        }
        for(int i=left;i<=right;i++){//时间复杂度O(D) D是区间里的整数
            if(isSelfDividingNumber(i)){
                res.add(i);
            }
        }
        return res;

    }
    public boolean isSelfDividingNumber(int num){//用String来做
        String number=Integer.toString(num);
        //String number=String.valueOf(num);
        //String number=""+num;
        for(int i=0;i<number.length();i++){
            if(number.charAt(i)-'0'==0||num%(number.charAt(i)-'0')!=0){
                return false;
            }
        }
        return true;
    }
    public boolean isSelfDividingNumber1(int num){//用char[]来做
        for(char c:String.valueOf(num).toCharArray()){
            if(c=='0'||(num%(c-'0')!=0)){
                return false;
            }
        }
        return true;
    }
}
//自除数是指可以被它包含的每一位数除尽的数，不允许包含0。
//         P0728SelfDividingNumbers p728=new P0728SelfDividingNumbers();
//         System.out.println(p728.selfDividingNumber(10, 22));
//         System.out.println(p728.selfDividingNumber(47, 85));