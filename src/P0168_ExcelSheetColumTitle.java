
public class P0168_ExcelSheetColumTitle {
    public String convertToTitle(int columnNumber){
        StringBuilder sb=new StringBuilder();
        char[]letters=new char[26];
        for(int i=0;i<26;i++){
            letters[i]=(char)(i+'A');//存储26个大写字母
        }
        while(columnNumber>0){
            if(columnNumber%26==0){ //若为26特殊处理，因为26对应字母Z 若取模则为0，商为1，取不到Z
                sb.append(letters[25]);
            }
            else{
                int remain=columnNumber%26;
                sb.append(letters[remain-1]); //数组里下标从0-25
            } 
            columnNumber--;
            columnNumber/=26;
        }
        return sb.reverse().toString();
    }
    public String convertToTitle0(int column){
        StringBuilder st=new StringBuilder();
        while(column>0){
            column--;
            int remain=column%26;
            st.append((char)(remain+'A'));//最先算出来的是高位，所以要reverse
            column/=26;
        }

        return st.reverse().toString();
    }
}

/*
      P0168_ExcelSheetColumTitle p168=new P0168_ExcelSheetColumTitle();
      System.out.println(p168.convertToTitle(52));
      System.out.println(p168.convertToTitle(28));
      System.out.println(p168.convertToTitle(701));
      System.out.println(p168.convertToTitle(2147483647));  
*/