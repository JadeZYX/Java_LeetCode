public class P1528ShuffleString {
    public String restoreString(String s,int[]indices){
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<indices.length;++i){
            sb.setCharAt(indices[i], s.charAt(i));
        }
        return sb.toString();
    }
    public String restoreString1(String s, int[]indices){
        char[]temp=new char[indices.length];
        for(int i=0;i<indices.length;i++){
            temp[indices[i]]=s.charAt(i);
        }
        return String.valueOf(temp);//String.valueOf()将char类型的数组转成string类型
    }
}
/*
        P1528ShuffleString p1528=new P1528ShuffleString();
        System.out.println(p1528.restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
*/
