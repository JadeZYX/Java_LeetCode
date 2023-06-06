public class P0171ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle){
        int res=0;
        int multi=1;
        for(int i=columnTitle.length()-1;i>=0;i--){ //从后往前，看末位一共进了几次26；首次是26的0次方也就是1；
            res=res+(columnTitle.charAt(i)-'A'+1)*multi;
            multi*=26;
        }
        return res;
    }
    public int titleToNumber0(String columnTitle){
        int res=0;
        for (int i = 0; i < columnTitle.length(); ++i) {
            res *= 26;//相当于向左边位移，类似于十进制中的左移进位
            res += (columnTitle.charAt(i)-'A'+1);
        }
        return res;
    }//从前往后，先进位（开始是0）再把末位加进去
}  
/*
      P0171ExcelSheetColumnNumber p171=new P0171ExcelSheetColumnNumber();
      System.out.println(p171.titleToNumber("A"));
      System.out.println(p171.titleToNumber("AB"));
      System.out.println(p171.titleToNumber("ZY"));
      System.out.println(p171.titleToNumber("FXSHRXW"));
*/
