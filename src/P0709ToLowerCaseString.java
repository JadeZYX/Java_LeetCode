public class P0709ToLowerCaseString {
    public String toLowerCase(String s){
       StringBuilder sb=new StringBuilder();
       for(int index=0;index<s.length();index++){
           char i=s.charAt(index);
           if(i>=65&&i<=90){
            sb.append((char)(i+32));
           }
           else{
            sb.append(i); 
           }
       }
       return sb.toString();
    }
}
/*
        P0709ToLowerCaseString p709=new P0709ToLowerCaseString();
        System.out.println(p709.toLowerCase("Hello"));
        System.out.println(p709.toLowerCase("al&phaBET"));
asc码中，大小字母是65-90，小写字母是97-122.题要求不用内置函数将string里的大写字母变成小写。
根据ask码，可以用当前字母所在asc 码中的位置+32就是asc码中小写字母的位置，即(char)(i+32);
*/
