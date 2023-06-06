public class P0012IntegerToRoman {
    public String intToRoman(int num){
        int[]numbers=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[]romans=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<numbers.length;i++){
           while(num>=numbers[i]){
               sb.append(romans[i]);
               num-=numbers[i];
           }
        }
        return sb.toString();
    }
    //找第一个比num小或者是相等的值。所以从大到小
}
